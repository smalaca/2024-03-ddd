package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.order.domain.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.List;

@Factory
public class OrderFactory {
    private final Warehouse warehouse;

    public OrderFactory(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Order create(CreateOrderCommand command) {
        OrderNumber orderNumber = OrderNumber.from(command.buyerId());
        List<OrderItem> items = new ArrayList<>();
        command.products().forEach((id, amount) -> items.add(new OrderItem(id, amount)));

        return new Order(orderNumber, command.summaryId(), command.buyerId(), items);
    }
}
