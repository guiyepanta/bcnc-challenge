package com.bcnc.challenge.application.port.out.db;

import com.bcnc.challenge.domain.Price;

public interface CommandPricePort {

    Price save(Price price);

}