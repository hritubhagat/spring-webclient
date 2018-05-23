package com.bhagat.hritu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bhagat.hritu.aurora.messages.GetRoomPricingAndAvailabilityResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RoomPricingServiceImpl implements RoomPricingService{

   // private static final Logger LOGGER = LoggerFactory.getLogger(RoomPricingServiceImpl.class);
   
    @Autowired
    private WebClient webClient;
    
    @Autowired
    ObjectMapper mapper;
    @Override
    public Mono<GetRoomPricingAndAvailabilityResponse> getRoomPricing() {
        // TODO Auto-generated method stub
        log.info("Service started");
        return webClient.get()
                .uri("/room-pricingAndAvailabilityEx-CP-TU-66964e2b-2550-4476-84c3-1a4c0c5c067f")
//                .accept(MediaType.APPLICATION_STREAM_JSON)
                //.accept(MediaType.APPLICATION_JSON)
//                .accept(MediaType.TEXT_EVENT_STREAM)
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("Resource Not Found")))
                .onStatus(HttpStatus::is5xxServerError,clientResponse -> Mono.error(new RuntimeException("Internal Server Error")))
                .bodyToMono(GetRoomPricingAndAvailabilityResponse.class)
                .doOnSuccess(roomPricingResponse ->
                    log.info("ROOM PRICING RESPONSE : {}", roomPricingResponse));
                //.map(res-> {LOGGER.info("inside service class::{}",mapper.writeValueAsString(res));return res;});
    }

}
