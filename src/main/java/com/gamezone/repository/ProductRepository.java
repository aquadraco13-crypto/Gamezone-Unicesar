package com.gamezone.repository;

import com.mycompany.gamezone.unicesar.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final String filePath = "products.txt";

    public List<Product> loadAll() {
        List<Product> products = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return products;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Lógica de lectura
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de productos: " + filePath, e);
        }
        return products;
    }

    public void saveAll(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Product p : products) {
                // Lógica de escritura
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo de productos: " + filePath, e);
        }
    }
}