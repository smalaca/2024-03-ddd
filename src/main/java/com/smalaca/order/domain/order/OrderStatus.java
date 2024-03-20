package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
enum OrderStatus {
    CREATED, CANCEL
}
