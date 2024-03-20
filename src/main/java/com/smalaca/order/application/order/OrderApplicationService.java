package com.smalaca.order.application.order;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.order.domain.eventpublisher.EventPublisher;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderRepository;
import com.smalaca.order.domain.paymentservice.PaymentService;

import java.util.Optional;
import java.util.UUID;

public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final EventPublisher eventPublisher;
    private final PaymentService paymentService;

    public OrderApplicationService(OrderRepository orderRepository, EventPublisher eventPublisher, PaymentService paymentService) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
        this.paymentService = paymentService;
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

        order.accept(paymentService, eventPublisher);

        orderRepository.save(order);
    }
}
