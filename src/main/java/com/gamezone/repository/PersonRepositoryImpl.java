package com.gamezone.repository;

import com.gamezone.model.Person;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl {
    private final String filePath = "persons.txt";

    public List<Person> loadAll() {
        List<Person> persons = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return persons;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Lógica de lectura
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar datos desde el archivo de personas: " + filePath, e);
        }
        return persons;
    }

    public void saveAll(List<Person> persons) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Person p : persons) {
                // Lógica de escritura
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar los datos en el archivo de personas: " + filePath, e);
        }
    }
}