package com.smalaca.order.application.summary;

import java.util.UUID;

public record AcceptSummaryDto(UUID summaryId, String street, String postalCode, String city) {
}
