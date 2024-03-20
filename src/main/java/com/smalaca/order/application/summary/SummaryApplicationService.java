package com.smalaca.order.application.summary;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.order.domain.order.Address;
import com.smalaca.order.domain.order.AddressFactory;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderFactory;
import com.smalaca.order.domain.order.OrderRepository;
import com.smalaca.order.domain.summary.Summary;
import com.smalaca.order.domain.summary.SummaryRepository;

public class SummaryApplicationService {
    private final SummaryRepository summaryRepository;
    private final OrderRepository orderRepository;
    private final OrderFactory orderFactory;
    private final AddressFactory addressFactory;

    public SummaryApplicationService(
            SummaryRepository summaryRepository, OrderRepository orderRepository,
            OrderFactory orderFactory, AddressFactory addressFactory) {
        this.summaryRepository = summaryRepository;
        this.orderRepository = orderRepository;
        this.orderFactory = orderFactory;
        this.addressFactory = addressFactory;
    }

    @PrimaryAdapter
    public void accept(AcceptSummaryDto dto) {
        Summary summary = summaryRepository.findById(dto.summaryId());
        Address address = addressFactory.create(dto.street(), dto.postalCode(), dto.city());

        Order order = summary.accept(address, orderFactory);

        orderRepository.save(order);
    }
}
