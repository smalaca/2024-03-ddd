package com.smalaca.order.application.order;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.order.domain.eventpublisher.EventPublisher;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderRepository;

import java.util.Optional;
import java.util.UUID;

public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final EventPublisher eventPublisher;

    public OrderApplicationService(OrderRepository orderRepository, EventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    @PrimaryAdapter
    public void cancel(UUID orderId, Optional<String> reason) {
        Order order = orderRepository.findById(orderId);

        order.cancel(reason, eventPublisher);

        orderRepository.save(order);
    }

    @PrimaryAdapter
    public void accept(UUID orderId) {
        Order order = orderRepository.findById(orderId);

        order.accept(eventPublisher);

        orderRepository.save(order);
    }
}
