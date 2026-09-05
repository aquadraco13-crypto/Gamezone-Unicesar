package com.mycompany.gamezone.unicesar;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryMemory implements IProductRepository {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product getProductById(String id) {
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equalsIgnoreCase(product.getId())) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        return products.removeIf(p -> p.getId().equalsIgnoreCase(id));
    }
}
a