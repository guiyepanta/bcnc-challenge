package com.bcnc.challenge.application.port.out.db;

import java.time.LocalDateTime;

import com.bcnc.challenge.domain.Price;

public interface QueryPricePort {

    Price getPriceBy(LocalDateTime filterDate, Integer productId, Integer brandId);

}