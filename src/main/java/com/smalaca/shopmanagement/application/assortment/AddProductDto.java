package com.smalaca.shopmanagement.application.assortment;

import java.math.BigDecimal;
import java.util.UUID;

public record AddProductDto(
        UUID assortmentId,
        String description,
        String name,
        String serialNumber,
        int amount,
        BigDecimal price) {
}
