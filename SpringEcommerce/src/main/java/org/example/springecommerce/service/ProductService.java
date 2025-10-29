package org.example.springecommerce.service;

import org.example.springecommerce.exceptions.ProductNotFoundException;
import org.example.springecommerce.exceptions.ProductsTableEmptyException;
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

    public List<Product> getAllProducts() throws ProductsTableEmptyException {
        List<Product> list = this.productRepository.findAll();
        if(list.isEmpty())
            throw new ProductsTableEmptyException();
        return list;
    }

    public Product getProductById(String id) throws ProductNotFoundException {
        Product p = this.productRepository.findById(id).orElse(null);
        if(p == null) throw new ProductNotFoundException(id);
        return p;
    }

    public Product storeProduct(Product product, MultipartFile file) throws IOException {
        product.setImageName(file.getOriginalFilename());
        product.setImageType(file.getContentType());
        product.setImageData(file.getBytes());
        return this.productRepository.save(product);
    }

    public Product updateProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());

        return this.productRepository.save(product);
    }

    public void deleteProduct(String id) {
        this.productRepository.deleteById(id);
    }

    public List<Product> search(String query) {
        return this.productRepository.findByNameOrDescriptionContaining(query, query);
    }
}
