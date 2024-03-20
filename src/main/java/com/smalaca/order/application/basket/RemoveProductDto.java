package com.smalaca.order.application.basket;

import java.util.UUID;

public record RemoveProductDto(UUID basketId, UUID productId, int amount) {
}
