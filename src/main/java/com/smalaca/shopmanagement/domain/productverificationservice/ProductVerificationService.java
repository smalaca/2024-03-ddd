package com.smalaca.shopmanagement.domain.productverificationservice;

import com.smalaca.annotation.architecture.SecondaryPort;

@SecondaryPort
public interface ProductVerificationService {
    boolean isValid(ProductToVerify productToVerify);
}
