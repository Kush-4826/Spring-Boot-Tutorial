package org.example.springecommerce.model.dto;

import java.math.BigInteger;

public record OrderItemResponse(
        String name,
        int quantity,
        BigInteger totalPrice
) {
}
