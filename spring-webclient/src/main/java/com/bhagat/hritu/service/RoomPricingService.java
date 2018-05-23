package com.bhagat.hritu.service;

import com.bhagat.hritu.aurora.messages.GetRoomPricingAndAvailabilityResponse;

import reactor.core.publisher.Mono;

public interface RoomPricingService {

    public Mono<GetRoomPricingAndAvailabilityResponse> getRoomPricing();
}
