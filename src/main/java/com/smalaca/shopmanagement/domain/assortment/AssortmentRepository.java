package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface AssortmentRepository {
    Assortment findById(UUID assortmentId);

    void save(Assortment assortment);
}
