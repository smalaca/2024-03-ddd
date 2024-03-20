package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.order.domain.warehouse.ProductToBlockDto;
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
        if (warehouse.block(asProductToBlockDtos(command))) {
            return new Order(
                    orderNumber(command),
                    command.summaryId(),
                    command.buyerId(),
                    asOrderItems(command),
                    command.address());
        } else {
            throw new UnavailableProductsException(command);
        }
    }

    private List<ProductToBlockDto> asProductToBlockDtos(CreateOrderCommand command) {
        List<ProductToBlockDto> products = new ArrayList<>();
        command.products().forEach((id, amount) -> products.add(new ProductToBlockDto(id, amount)));
        return products;
    }

    private OrderNumber orderNumber(CreateOrderCommand command) {
        return OrderNumber.from(command.buyerId());
    }

    private List<OrderItem> asOrderItems(CreateOrderCommand command) {
        List<OrderItem> items = new ArrayList<>();
        command.products().forEach((id, amount) -> items.add(new OrderItem(id, amount)));
        return items;
    }
}
