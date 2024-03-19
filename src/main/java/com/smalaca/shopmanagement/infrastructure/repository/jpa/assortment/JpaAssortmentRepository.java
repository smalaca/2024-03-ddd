package com.smalaca.shopmanagement.infrastructure.repository.jpa.assortment;

import com.smalaca.annotation.architecture.SecondaryAdapter;
import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.shopmanagement.domain.assortment.Assortment;
import com.smalaca.shopmanagement.domain.assortment.AssortmentRepository;

import java.util.UUID;

@SecondaryAdapter
public class JpaAssortmentRepository implements AssortmentRepository {
    @Override
    public Assortment findById(UUID assortmentId) {
        return null;
    }

    @Override
    public void save(Assortment assortment) {

    }
}
