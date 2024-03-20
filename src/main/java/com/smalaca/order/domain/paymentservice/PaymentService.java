package com.smalaca.order.domain.paymentservice;

import com.smalaca.annotation.architecture.SecondaryPort;

@SecondaryPort
public interface PaymentService {
    void pay(PaymentDto paymentDto);
}
