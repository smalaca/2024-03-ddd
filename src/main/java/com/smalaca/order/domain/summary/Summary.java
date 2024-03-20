package com.smalaca.order.domain.summary;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.order.domain.amount.Amount;
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

    public Order accept(OrderFactory orderFactory) {
        CreateOrderCommand command = new CreateOrderCommand(summaryId, buyerId, productsAsMap());
        return orderFactory.create(command);
    }

    private Map<UUID, Amount> productsAsMap() {
        Map<UUID, Amount> productsAsMap = new HashMap<>();
        products.forEach(item -> productsAsMap.put(item.getProductId(), item.getAmount()));
        return productsAsMap;
    }
}
