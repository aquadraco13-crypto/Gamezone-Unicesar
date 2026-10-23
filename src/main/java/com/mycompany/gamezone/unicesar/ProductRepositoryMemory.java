package com.gamezone.repository;

import com.gamezone.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryMemory implements IProductRepository {

    private final List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        if (product == null || product.getId() == null) {
            throw new IllegalArgumentException("Product and its ID cannot be null.");
        }
        if (getProductById(product.getId()) != null) {
            throw new IllegalArgumentException("A product with ID " + product.getId() + " already exists.");
        }
        products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product getProductById(String id) {
        if (id == null) {
            return null;
        }
        for (Product product : products) {
            if (id.equalsIgnoreCase(product.getId())) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        if (product == null || product.getId() == null) {
            return false;
        }
        for (int i = 0; i < products.size(); i++) {
            if (product.getId().equalsIgnoreCase(products.get(i).getId())) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        if (id == null) {
            return false;
        }
        return products.removeIf(p -> id.equalsIgnoreCase(p.getId()));
    }
}