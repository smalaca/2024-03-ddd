package com.smalaca.order.application.summary;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderFactory;
import com.smalaca.order.domain.order.OrderRepository;
import com.smalaca.order.domain.summary.Summary;
import com.smalaca.order.domain.summary.SummaryRepository;

public class SummaryApplicationService {
    private final SummaryRepository summaryRepository;
    private final OrderRepository orderRepository;
    private final OrderFactory orderFactory;

    public SummaryApplicationService(
            SummaryRepository summaryRepository, OrderRepository orderRepository, OrderFactory orderFactory) {
        this.summaryRepository = summaryRepository;
        this.orderRepository = orderRepository;
        this.orderFactory = orderFactory;
    }

    @PrimaryAdapter
    public void accept(AcceptSummaryDto dto) {
        Summary summary = summaryRepository.findById(dto.summaryId());

        Order order = summary.accept(orderFactory);

        orderRepository.save(order);
    }
}
