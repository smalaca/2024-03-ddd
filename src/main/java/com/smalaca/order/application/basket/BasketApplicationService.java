package com.smalaca.order.application.basket;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.order.domain.basket.Basket;
import com.smalaca.order.domain.basket.BasketRepository;

import java.util.UUID;

public class BasketApplicationService {
    private final BasketRepository basketRepository;

    public BasketApplicationService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @PrimaryAdapter
    public void addProduct(UUID basketId) {
        Basket basket = basketRepository.findById(basketId);

        basket.addProduct();

        basketRepository.save(basket);
    }

    @PrimaryAdapter
    public void removeProduct(UUID basketId) {
        Basket basket = basketRepository.findById(basketId);

        basket.removeProduct();

        basketRepository.save(basket);
    }
}
