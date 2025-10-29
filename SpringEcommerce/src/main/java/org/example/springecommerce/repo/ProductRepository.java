package org.example.springecommerce.repo;

import org.example.springecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByNameOrDescriptionContaining(String name, String description);
}
