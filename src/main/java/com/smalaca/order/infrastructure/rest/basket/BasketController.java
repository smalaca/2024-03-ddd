package com.smalaca.order.infrastructure.rest.basket;

import com.smalaca.order.application.basket.AddProductDto;
import com.smalaca.order.application.basket.BasketApplicationService;
import com.smalaca.order.application.basket.RemoveProductDto;
import com.smalaca.order.query.basket.BasketQueryService;
import com.smalaca.order.query.basket.BasketView;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("basket")
public class BasketController {
    private final BasketApplicationService basketApplicationService;
    private final BasketQueryService basketQueryService;

    public BasketController(BasketApplicationService basketApplicationService, BasketQueryService basketQueryService) {
        this.basketApplicationService = basketApplicationService;
        this.basketQueryService = basketQueryService;
    }

    @PostMapping
    @RequestMapping("product")
    public void addProduct(@RequestBody AddProductDto dto) {
        basketApplicationService.addProduct(dto);
    }

    @DeleteMapping
    @RequestMapping("product")
    public void removeProduct(@RequestBody RemoveProductDto dto) {
        basketApplicationService.removeProduct(dto);
    }

    @GetMapping
    public BasketView display(@PathVariable UUID basketId) {
        return basketQueryService.findById(basketId);
    }
}
