package com.smalaca.order.domain.order;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface OrderRepository {
    Order findById(UUID orderId);

    void save(Order order);
}
