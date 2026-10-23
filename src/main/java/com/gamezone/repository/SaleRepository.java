package com.gamezone.repository;

import com.gamezone.model.Sale;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository {
    private final String filePath = "sales.txt";

    public List<Sale> loadAll() {
        List<Sale> sales = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return sales;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Lógica de lectura
            }
        } catch (IOException e) {
            throw new RuntimeException("Error de lectura al procesar el archivo de ventas: " + filePath, e);
        }
        return sales;
    }

    public void saveAll(List<Sale> sales) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Sale s : sales) {
                // Lógica de escritura
            }
        } catch (IOException e) {
            throw new RuntimeException("Error de escritura al guardar las ventas en: " + filePath, e);
        }
    }
}