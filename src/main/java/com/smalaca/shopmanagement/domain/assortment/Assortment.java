package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.shopmanagement.domain.eventpublisher.EventPublisher;
import com.smalaca.shopmanagement.domain.productverificationservice.ProductToVerify;
import com.smalaca.shopmanagement.domain.productverificationservice.ProductVerificationService;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AggregateRoot
public class Assortment {
//public class Assortment extends AbstractAggregateRoot<Assortment> {
    @Id
    private UUID assortmentId;

    // bussiness identifier
    private UUID sellerId;

    private final List<AssortmentItem> products = new ArrayList<>();

    @PrimaryPort
    public void addProduct(
            Amount amount, AddProductCommand command, EventPublisher eventPublisher, ProductVerificationService productVerificationService) {
        if (isInvalidProduct(productVerificationService, command)) {
            NotAcceptableProductRecognized event = NotAcceptableProductRecognized.create(sellerId, command.serialNumber());
            eventPublisher.publish(event);
//            this.andEvent(event);

            throw new NotAcceptableProductExcetpion(command);
        } else {
            products.add(AssortmentItem.from(amount, command));
        }

    }

    private boolean isInvalidProduct(ProductVerificationService productVerificationService, AddProductCommand command) {
        return productVerificationService.isValid(new ProductToVerify(command.serialNumber()));
    }
}
