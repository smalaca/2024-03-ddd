package com.smalaca.order.domain.order;

class NotExistingAddressException extends RuntimeException {
    private final String street;
    private final String postalCode;
    private final String city;

    NotExistingAddressException(String street, String postalCode, String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }
}
