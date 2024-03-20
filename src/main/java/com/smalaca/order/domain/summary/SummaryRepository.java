package com.smalaca.order.domain.summary;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface SummaryRepository {
    Summary findById(UUID summaryId);
}
