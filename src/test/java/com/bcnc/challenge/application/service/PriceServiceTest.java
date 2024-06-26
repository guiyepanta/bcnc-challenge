package com.bcnc.challenge.application.service;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bcnc.challenge.application.port.out.db.QueryPricePort;
import com.bcnc.challenge.domain.Price;
import com.bcnc.challenge.utils.DateUtil;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    @Mock
    QueryPricePort queryPricePort;

    @InjectMocks
    PriceService service;

    @Test
    @DisplayName("Test 01: Test get Price - Response 200 (ok)")
    public void test01() throws Exception {
	// GIVEN
	Price priceMock = new Price();
	priceMock.setId(1);
	priceMock.setBrandId(1);
	priceMock.setStartDate(DateUtil.getDateFromString("2020-06-14 00:00:00"));
	priceMock.setEndDate(DateUtil.getDateFromString("2020-12-31 23:59:59"));
	priceMock.setPriceList(1);
	priceMock.setProductId(35455);
	priceMock.setPriority(0);
	priceMock.setPrice(Float.valueOf("35.50"));
	priceMock.setCurr("EUR");

	// WHEN
	LocalDateTime applicationDate = DateUtil.getDateFromString("2020-06-14 10:00:00");
	Integer productId = 35455;
	Integer brandId = 1;

	when(queryPricePort.getPriceBy(applicationDate, productId, brandId)).thenReturn(priceMock);

	Price response = service.getPriceBy(applicationDate, productId, brandId);

	// THEN
	Assertions.assertEquals(1, response.getId());
	Assertions.assertEquals(Float.valueOf("35.50"), response.getPrice());

    }
}
