package com.smalaca.order.infrastructure.rest.basket;

import com.smalaca.order.application.basket.BasketApplicationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("basket")
public class BasketController {
    private final BasketApplicationService service;

    public BasketController(BasketApplicationService service) {
        this.service = service;
    }

    @PostMapping
    @RequestMapping("${basketId}/product")
    public void addProduct(@PathVariable UUID basketId) {
        service.addProduct(basketId);
    }
}
