package com.smalaca.order.infrastructure.repository.jpa.basket;

import com.smalaca.annotation.architecture.SecondaryAdapter;
import com.smalaca.order.domain.basket.Basket;
import com.smalaca.order.domain.basket.BasketRepository;

import java.util.UUID;

@SecondaryAdapter
public class JpaBasketRepository implements BasketRepository {
    @Override
    public Basket findById(UUID basketId) {
        return null;
    }

    @Override
    public void save(Basket basket) {

    }
}
