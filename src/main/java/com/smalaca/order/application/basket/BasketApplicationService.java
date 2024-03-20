package com.smalaca.order.application.basket;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.order.domain.basket.Amount;
import com.smalaca.order.domain.basket.Basket;
import com.smalaca.order.domain.basket.BasketRepository;

import java.util.UUID;

public class BasketApplicationService {
    private final BasketRepository basketRepository;

    public BasketApplicationService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @PrimaryAdapter
    public void addProduct(AddProductDto dto) {
        Basket basket = basketRepository.findById(dto.basketId());
        Amount amount = new Amount(dto.amount());

        basket.addProduct(dto.productId(), amount);

        basketRepository.save(basket);
    }

    @PrimaryAdapter
    public void removeProduct(UUID basketId) {
        Basket basket = basketRepository.findById(basketId);

        basket.removeProduct();

        basketRepository.save(basket);
    }
}
