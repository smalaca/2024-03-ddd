package com.smalaca.order.infrastructure.rest.basket;

import com.smalaca.order.application.basket.AddProductDto;
import com.smalaca.order.application.basket.BasketApplicationService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("product")
    public void addProduct(@RequestBody AddProductDto dto) {
        service.addProduct(dto);
    }

    @DeleteMapping
    @RequestMapping("${basketId}/product")
    public void removeProduct(@PathVariable UUID basketId) {
        service.removeProduct(basketId);
    }
}
