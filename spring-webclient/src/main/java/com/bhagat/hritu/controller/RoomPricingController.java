package com.bhagat.hritu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bhagat.hritu.aurora.messages.GetRoomPricingAndAvailabilityResponse;
import com.bhagat.hritu.service.RoomPricingService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(
        value = "/step2")
@Slf4j
public class RoomPricingController {

//     private static final Logger LOGGER =
//     LoggerFactory.getLogger(RoomPricingController.class);

    @Autowired
    private RoomPricingService pricingService;
    @Autowired
    private ObjectMapper mapper;
    
    @ResponseBody
    @ResponseStatus(
            value = HttpStatus.OK)
    @RequestMapping(
            value = "/list.sjson", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Mono<GetRoomPricingAndAvailabilityResponse> getBalancesFull() {
        log.info("Room booking controller start");
        return pricingService.getRoomPricing()
               .doOnSuccess(response -> log.info("ROOM BOOKING RESPONSE FROM SERVICE :: {}", response)) 
               .doAfterSuccessOrError((afterSuccessOrError, throwable) -> log.info("Room booking controller end"));
              /*.map(res -> {
            try {
                LOGGER.info("Room booking response from rest end point::{}", mapper.writeValueAsString(res));
            } catch (IOException e) {
                LOGGER.info("Exception occurred while logging response::{}", e);
            }
            return res;
        });*/
      

    }
}
