package com.smalaca.order.infrastructure.repository.jpa.order;

import com.smalaca.annotation.architecture.SecondaryAdapter;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderRepository;

import java.util.UUID;

@SecondaryAdapter
public class JpaOrderRepository implements OrderRepository {

    @Override
    public Order findById(UUID orderId) {
        return null;
    }

    @Override
    public void save(Order order) {

    }
}
