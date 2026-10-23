package com.gamezone.ui;

import com.gamezone.service.IReturnService;
import com.gamezone.service.IWarrantyService;
import java.util.Scanner;

/**
 * Console-based menu for GameZoneUnicesar system.
 */
public class ConsoleMenu {
    private final IReturnService returnService;
    private final IWarrantyService warrantyService;

    public ConsoleMenu(IReturnService returnService, IWarrantyService warrantyService) {
        if (returnService == null || warrantyService == null) {
            throw new IllegalArgumentException("Services cannot be null.");
        }
        this.returnService = returnService;
        this.warrantyService = warrantyService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== GAMEZONE UNICESAR ===");
            System.out.println("1. Process Return");
            System.out.println("2. Process Warranty");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.println("Returning feature selected.");
                    break;
                case 2:
                    System.out.println("Warranty feature selected.");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
        
        scanner.close();
    }
}