package org.example.springecommerce.model.dto;

public record OrderItemRequest(
        String productId,
        int quantity
) {
}
