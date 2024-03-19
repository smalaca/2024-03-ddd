package com.smalaca.order.application.order;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderRepository;

import java.util.UUID;

public class OrderApplicationService {
    private final OrderRepository orderRepository;

    public OrderApplicationService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PrimaryAdapter
    public void cancel(UUID orderId) {
        Order order = orderRepository.findById(orderId);

        order.cancel();

        orderRepository.save(order);
    }
}
