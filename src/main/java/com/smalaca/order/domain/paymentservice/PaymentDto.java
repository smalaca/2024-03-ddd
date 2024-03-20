package com.smalaca.order.domain.paymentservice;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentDto(UUID buyerId, UUID orderId, BigDecimal value) {
}
