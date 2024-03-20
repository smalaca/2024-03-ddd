package com.smalaca.order.domain.warehouse;

import com.smalaca.order.domain.amount.Amount;

import java.util.UUID;

public record ProductToBlockDto(UUID id, Amount amount) {
}
