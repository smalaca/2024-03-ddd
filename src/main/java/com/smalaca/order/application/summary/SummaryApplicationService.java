package com.smalaca.order.application.summary;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderRepository;
import com.smalaca.order.domain.summary.Summary;
import com.smalaca.order.domain.summary.SummaryRepository;

public class SummaryApplicationService {
    private final SummaryRepository summaryRepository;
    private final OrderRepository orderRepository;

    public SummaryApplicationService(SummaryRepository summaryRepository, OrderRepository orderRepository) {
        this.summaryRepository = summaryRepository;
        this.orderRepository = orderRepository;
    }

    @PrimaryAdapter
    public void accept(AcceptSummaryDto dto) {
        Summary summary = summaryRepository.findById(dto.summaryId());

        Order order = summary.accept();

        orderRepository.save(order);
    }
}
