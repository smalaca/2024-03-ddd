package com.smalaca.order.infrastructure.rest.order;

import com.smalaca.order.application.order.OrderApplicationService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderApplicationService service;

    public OrderController(OrderApplicationService service) {
        this.service = service;
    }

    @DeleteMapping
    @RequestMapping("${orderId}")
    public void cancel(@PathVariable UUID orderId) {
        service.cancel(orderId);
    }
}
