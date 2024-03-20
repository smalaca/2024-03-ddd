package com.smalaca.order.domain.summary;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.order.domain.amount.Amount;
import com.smalaca.order.domain.order.Address;
import com.smalaca.order.domain.order.CreateOrderCommand;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderFactory;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Summary {
    @Id
    private UUID summaryId;
    // business identifier
    private UUID buyerId;

    private final List<SummaryItem> products = new ArrayList<>();

    @Factory
    @PrimaryPort
    public Order accept(Address address, OrderFactory orderFactory) {
        return orderFactory.create(asCreateOrderCommand(address));
    }

    private CreateOrderCommand asCreateOrderCommand(Address address) {
        return new CreateOrderCommand(summaryId, buyerId, productsAsMap(), address);
    }

    private Map<UUID, Amount> productsAsMap() {
        Map<UUID, Amount> productsAsMap = new HashMap<>();
        products.forEach(item -> productsAsMap.put(item.getProductId(), item.getAmount()));
        return productsAsMap;
    }
}
