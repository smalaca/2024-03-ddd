package com.smalaca.order.application.basket;

import java.util.UUID;

public record AddProductDto(UUID basketId, UUID productId, int amount) {
}
