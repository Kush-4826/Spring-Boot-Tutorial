package org.example.springecommerce.exceptions;

public class ProductsTableEmptyException extends RuntimeException {
    public ProductsTableEmptyException() {
        super("No products available");
    }
}
