package com.bcnc.challenge.application.port.in.web;

import java.time.LocalDateTime;

import org.apache.coyote.BadRequestException;

import com.bcnc.challenge.domain.Price;

public interface PricePort {
    // Query methods
    Price getPriceBy(LocalDateTime applicationrDate, Integer productId, Integer brandId);

    // Command methods
    Price create(PriceRequest priceRequest);

    Price update(Integer id, PriceRequest priceRequest) throws BadRequestException;
}
