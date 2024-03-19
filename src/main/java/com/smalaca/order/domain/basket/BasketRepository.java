package com.smalaca.order.domain.basket;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface BasketRepository {
    Basket findById(UUID basketId);

    void save(Basket basket);
}
