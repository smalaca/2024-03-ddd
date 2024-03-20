package com.smalaca.order.infrastructure.rest.order;

import java.util.Optional;
import java.util.UUID;

public record CancelOrderDto(UUID orderId, Optional<String> reason) {
}
