package com.smalaca.order.infrastructure.rest.basket;

import com.smalaca.order.application.basket.AddProductDto;
import com.smalaca.order.application.basket.BasketApplicationService;
import com.smalaca.order.application.basket.RemoveProductDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("product")
    public void removeProduct(@RequestBody RemoveProductDto dto) {
        service.removeProduct(dto);
    }
}
