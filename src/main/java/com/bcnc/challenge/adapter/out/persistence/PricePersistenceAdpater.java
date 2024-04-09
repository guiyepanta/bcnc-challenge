package com.bcnc.challenge.adapter.out.persistence;

import java.time.LocalDateTime;

import com.bcnc.challenge.adapter.out.persistence.entities.PriceEntity;
import com.bcnc.challenge.adapter.out.persistence.mappers.PriceMapper;
import com.bcnc.challenge.adapter.out.persistence.repositories.JPAPriceRepository;
import com.bcnc.challenge.application.exceptions.PriceNotFoundException;
import com.bcnc.challenge.application.port.out.db.CommandPricePort;
import com.bcnc.challenge.application.port.out.db.QueryPricePort;
import com.bcnc.challenge.common.PersistenceAdapter;
import com.bcnc.challenge.domain.Price;

@PersistenceAdapter
public class PricePersistenceAdpater implements QueryPricePort, CommandPricePort {

    private JPAPriceRepository repository;

    public PricePersistenceAdpater(JPAPriceRepository priceRepository) {
	this.repository = priceRepository;
    }

    @Override
    public Price getPriceBy(LocalDateTime filterDate, Integer productId, Integer brandId) {
	return repository
		.findTopByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
			filterDate, filterDate, productId, brandId)
		.map(PriceMapper::entityToDomain).orElseThrow(() -> new PriceNotFoundException("Price not found."));
    }

    @Override
    public Price save(Price price) {
	PriceEntity newPrice = PriceMapper.domainToEntity(price);
	return PriceMapper.entityToDomain(repository.save(newPrice));
    }
}
