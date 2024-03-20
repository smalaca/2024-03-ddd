package com.smalaca.shopmanagement.application.assortment;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.shopmanagement.domain.assortment.AddProductCommand;
import com.smalaca.shopmanagement.domain.assortment.Amount;
import com.smalaca.shopmanagement.domain.assortment.Assortment;
import com.smalaca.shopmanagement.domain.assortment.AssortmentRepository;
import com.smalaca.shopmanagement.domain.assortment.Price;

public class AssortmentApplicationService {
    private final AssortmentRepository assortmentRepository;

    public AssortmentApplicationService(AssortmentRepository assortmentRepository) {
        this.assortmentRepository = assortmentRepository;
    }

    @PrimaryAdapter
    public void addProduct(AddProductDto dto) {
        // 1. tłumaczenie na Aggregate albo ValueObject [0...*]
        Assortment assortment = assortmentRepository.findById(dto.assortmentId());
        Amount amount = new Amount(dto.amount());
        Price price = new Price(dto.price());
        AddProductCommand command = new AddProductCommand(dto.name(), dto.description(), dto.serialNumber(), price);

        // 2. wywołanie metody z domain [1]
        assortment.addProduct(amount, command);

        // 3. zapisanie zmian [0...*]
        assortmentRepository.save(assortment);
    }
}
