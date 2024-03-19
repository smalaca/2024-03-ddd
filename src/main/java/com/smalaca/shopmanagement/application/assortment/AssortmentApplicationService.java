package com.smalaca.shopmanagement.application.assortment;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.shopmanagement.domain.assortment.Assortment;
import com.smalaca.shopmanagement.domain.assortment.AssortmentRepository;

import java.util.UUID;

public class AssortmentApplicationService {
    private final AssortmentRepository assortmentRepository;

    public AssortmentApplicationService(AssortmentRepository assortmentRepository) {
        this.assortmentRepository = assortmentRepository;
    }

    @PrimaryAdapter
    public void addProduct(UUID assortmentId) {
        // 1. tłumaczenie na Aggregate albo ValueObject [0...*]
        Assortment assortment = assortmentRepository.findById(assortmentId);

        // 2. wywołanie metody z domain [1]
        assortment.addProduct();

        // 3. zapisanie zmian [0...*]
        assortmentRepository.save(assortment);
    }
}
