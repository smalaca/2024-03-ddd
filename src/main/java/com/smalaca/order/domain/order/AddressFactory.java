package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.order.domain.addressbook.AddressBook;
import com.smalaca.order.domain.addressbook.AddressDto;

@Factory
public class AddressFactory {
    private final AddressBook addressBook;

    AddressFactory(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public Address create(String street, String postalCode, String city) {
        if (addressBook.doesExist(new AddressDto(street, postalCode, city))) {
            return new Address(street, postalCode, city);
        } else {
            throw new NotExistingAddressException(street, postalCode, city);
        }
    }
}
