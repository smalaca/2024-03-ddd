package com.smalaca.shopmanagement.domain.assortment;

public record AddProductCommand(String name, String description, String serialNumber, Price price) {
}
