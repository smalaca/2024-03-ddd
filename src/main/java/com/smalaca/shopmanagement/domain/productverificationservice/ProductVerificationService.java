package com.smalaca.shopmanagement.domain.productverificationservice;

public interface ProductVerificationService {
    boolean isValid(ProductToVerify productToVerify);
}
