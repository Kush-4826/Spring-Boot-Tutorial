package org.example.springecommerce.model.dto;

import java.math.BigDecimal;

public record OrderItemResponse(
        String name,
        int quantity,
        BigDecimal totalPrice
) {
}
