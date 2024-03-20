package com.smalaca.order.domain.order;

import com.smalaca.order.domain.amount.Amount;

import java.util.Map;
import java.util.UUID;

public record CreateOrderCommand(
        UUID summaryId, UUID buyerId, Map<UUID, Amount> products) {
}
