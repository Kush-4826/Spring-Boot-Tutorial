package org.example.springecommerce.service;

import org.example.springecommerce.model.Product;
import org.example.springecommerce.repo.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product getProductById(String id) {
        return this.productRepository.findById(id).orElse(null);
    }

    public Product storeProduct(Product product, MultipartFile file) throws IOException {
        product.setImageName(file.getOriginalFilename());
        product.setImageType(file.getContentType());
        product.setImageData(file.getBytes());
        return this.productRepository.save(product);
    }
}
