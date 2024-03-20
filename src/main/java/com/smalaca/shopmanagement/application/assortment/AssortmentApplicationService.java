package com.smalaca.shopmanagement.application.assortment;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.shopmanagement.domain.assortment.AddProductCommand;
import com.smalaca.shopmanagement.domain.assortment.Amount;
import com.smalaca.shopmanagement.domain.assortment.Assortment;
import com.smalaca.shopmanagement.domain.assortment.AssortmentRepository;
import com.smalaca.shopmanagement.domain.assortment.Price;
import com.smalaca.shopmanagement.domain.eventpublisher.EventPublisher;
import com.smalaca.shopmanagement.domain.productverificationservice.ProductVerificationService;

public class AssortmentApplicationService {
    private final AssortmentRepository assortmentRepository;
    private final ProductVerificationService productVerificationService;
    private final EventPublisher eventPublisher;

    public AssortmentApplicationService(
            AssortmentRepository assortmentRepository, ProductVerificationService productVerificationService, EventPublisher eventPublisher) {
        this.assortmentRepository = assortmentRepository;
        this.productVerificationService = productVerificationService;
        this.eventPublisher = eventPublisher;
    }

    @PrimaryAdapter
    public void addProduct(AddProductDto dto) {
        // 1. tłumaczenie na Aggregate albo ValueObject [0...*]
        Assortment assortment = assortmentRepository.findById(dto.assortmentId());
        Amount amount = Amount.from(dto.amount());
        Price price = Price.from(dto.price());
        AddProductCommand command = new AddProductCommand(dto.name(), dto.description(), dto.serialNumber(), price);

        // 2. wywołanie metody z domain [1]
        assortment.addProduct(amount, command, eventPublisher, productVerificationService);

        // 3. zapisanie zmian [0...*]
        assortmentRepository.save(assortment);
    }
}
