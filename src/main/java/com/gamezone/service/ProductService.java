package com.gamezone.service;

import com.mycompany.gamezone.unicesar.Product;
import com.gamezone.repository.ProductRepository;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;
    private final List<Product> products;

    public ProductService() {
        this.productRepository = new ProductRepository();
        this.products = productRepository.loadAll();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        products.add(product);
        productRepository.saveAll(products);
    }

    public Product findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del producto no es válido");
        }
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("El producto con identificador " + id + " no fue encontrado"));
    }

    public List<Product> getAllProducts() {
        return products;
    }
}