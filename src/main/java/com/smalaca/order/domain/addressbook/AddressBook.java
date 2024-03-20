package com.smalaca.order.domain.addressbook;

import com.smalaca.annotation.architecture.SecondaryPort;

@SecondaryPort
public interface AddressBook {
    boolean doesExist(AddressDto addressDto);
}
