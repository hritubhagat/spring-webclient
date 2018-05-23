package com.bhagat.hritu.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.util.ResourceUtils;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;



@Configuration
@EnableWebFlux
@ComponentScan(basePackages = {"com.sapient.publicis"})
public class WebClientConfig{

    /**
     * Logger Instance
     */
    private static final Logger LOG = LoggerFactory.getLogger(WebClientConfig.class);

    // @Value("${aurora.rest.base.url:}")
    private String baseUrl = "http://localhost:3000";

    @Bean
    public WebClient webClient() {
        LOG.info("Creating webclient with base url as ::{}", baseUrl);
        return WebClient.builder().baseUrl(baseUrl)
                //.exchangeStrategies(strategies())
                .clientConnector(connector())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

    @Bean
    public ReactorClientHttpConnector connector() {
        return new ReactorClientHttpConnector(options -> options.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
//                .poolResources(PoolResources.fixed("myPool", 100))
                .compression(true).afterNettyContextInit(ctx -> 
                    //ctx.addHandlerLast(new ReadTimeoutHandler(10000, TimeUnit.MILLISECONDS))
                      ctx.addHandlerLast(new ReadTimeoutHandler(10000, TimeUnit.MILLISECONDS))
                ));
        
        /* * return new ReactorClientHttpConnector(options -> {
         * options.option(ChannelOption.SO_TIMEOUT, 2000);
         * options.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000);
         * options.poolResources(PoolResources.fixed("myPool", 100)); });*/
         
    }
    
    @Bean
    public ExchangeStrategies strategies() {
        return ExchangeStrategies.builder().codecs(clientDefaultCodecsConfigurer -> {
            clientDefaultCodecsConfigurer.defaultCodecs()
                    .jackson2JsonEncoder(new Jackson2JsonEncoder(mapper(), MediaType.APPLICATION_JSON));
            clientDefaultCodecsConfigurer.defaultCodecs()
                    .jackson2JsonDecoder(new Jackson2JsonDecoder(mapper(), MediaType.APPLICATION_JSON));

        }).build();
    }
    
    @Bean
    public ObjectMapper mapper(){
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new SimpleModule().addSerializer(DateTime.class, new JsonSerializer<DateTime>() {
            @Override
            public void serialize(DateTime value, JsonGenerator jsonGenerator, SerializerProvider provider)
                    throws IOException {
                jsonGenerator.writeString(ISODateTimeFormat.dateTime().print(value));
            }
        }));
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        mapper.setDateFormat(dateFormat);
        return mapper;
    }
    
    @Bean
    public LoggerContext loggerContext() {
        LOG.info("log4j2 Configuration is being created");
        String log4jConfigFile = EnvironmentConfigUtil.getEnvSpecificFile(
                "classpath:environment/log4j2-{env}.properties", "classpath:config/log4j2.properties");
        LoggerContext loggerContext = null;
        File file = null;
        try {
            file = ResourceUtils.getFile(log4jConfigFile);
            loggerContext = (LoggerContext) LogManager.getContext(false);
            loggerContext.setConfigLocation(file.toURI());
            loggerContext.start();
        } catch (FileNotFoundException e) {
            LOG.info("File not found::{}", e);
        }
        LOG.info("log4j2 configuration file is ::{}",log4jConfigFile);
        return loggerContext;
    }
}
