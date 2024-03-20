package com.smalaca.order.query.basket;

import java.util.Map;
import java.util.UUID;

public class BasketView {
    private UUID basketId;
    private UUID buyerId;
    private Map<UUID, Integer> products;
}
