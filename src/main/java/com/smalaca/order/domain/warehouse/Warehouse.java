package com.smalaca.order.domain.warehouse;

import com.smalaca.annotation.architecture.SecondaryPort;

import java.util.List;

@SecondaryPort
public interface Warehouse {
    boolean block(List<ProductToBlockDto> products);
}
