package com.smalaca.order.domain.basket;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.order.domain.amount.Amount;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AggregateRoot
public class Basket {
    @Id
    private UUID basketId;
    // business identifier
    private UUID buyerId;

    private final List<BasketItem> items = new ArrayList<>();

    @PrimaryPort
    public void addProduct(UUID productId, Amount amount) {
        items.add(new BasketItem(productId, amount));
    }

    @PrimaryPort
    public void removeProduct(UUID productId, Amount amount) {
        BasketItem item = itemFor(productId);

        if (item.hasMoreThan(amount)) {
            item.remove(amount);
        } else {
            items.remove(item);
        }
    }

    private BasketItem itemFor(UUID productId) {
        Optional<BasketItem> found = items.stream()
                .filter(basketItem -> basketItem.isFor(productId))
                .findFirst();

        return found.orElseThrow(() -> new ProductNotFoundException(productId));
    }
}
