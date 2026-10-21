package com.gamezone.ui;

import com.gamezone.exceptions.EmptySaleException;
import com.gamezone.exceptions.InvalidCategoryException;
import com.gamezone.exceptions.InvalidReturnException;
import com.gamezone.exceptions.UnsupportedWarrantyException;
import com.gamezone.service.*;
import java.util.Scanner;
import com.gamezone.model.Sale;
import com.gamezone.model.Promotion;
import com.gamezone.model.Return;
import com.gamezone.model.Warranty;

/**
 * Console-based menu for GameZoneUnicesar system.
 */
public class ConsoleMenu {
    private SaleService saleService;
    private PromotionService promotionService;
    private ReturnService returnService;
    private WarrantyService warrantyService;

    public ConsoleMenu(SaleService saleService,
                       PromotionService promotionService,
                       ReturnService returnService,
                       WarrantyService warrantyService) {
        this.saleService = saleService;
        this.promotionService = promotionService;
        this.returnService = returnService;
        this.warrantyService = warrantyService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== GameZoneUnicesar ===");
            System.out.println("1. Register Sale");
            System.out.println("2. Apply Promotion");
            System.out.println("3. Register Return");
            System.out.println("4. Register Warranty");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    try {
                        // Register a sale
                        System.out.print("Enter the sale ID: ");
                        String saleId = scanner.next();

                        System.out.print("Enter subtotal: ");
                        double subtotal = scanner.nextDouble();

                        Sale sale = new Sale(saleId, java.util.List.of("ITEM1"), subtotal);
                        saleService.registerSale(sale);

                        System.out.println("Sale successfully recorded!");
                    } catch (EmptySaleException e) {
                        System.out.println("Error: the sale must include at least one product or accessory.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        // Apply promotion
                        System.out.print("Enter promotion category: ");
                        String category = scanner.next();

                        Promotion promo = new Promotion("P1", "PromoTest", category, 20.0);
                        promotionService.registerPromotion(promo);

                        System.out.println("Promotion applied successfully!");
                    } catch (InvalidCategoryException e) {
                        System.out.println("Error: invalid category when registering the promotion.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        // Register a return
                        System.out.print("Enter return ID: ");
                        String returnId = scanner.next();

                        Return ret = new Return(returnId, "SALE1", java.util.List.of("ITEM1"), 50.0);
                        returnService.registerReturn(ret);

                        System.out.println("Return successfully recorded!");
                    } catch (InvalidReturnException e) {
                        System.out.println("Error: the item does not belong to the original sale.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        // Register a warranty
                        System.out.print("Enter warranty ID: ");
                        String warrantyId = scanner.next();

                        Warranty warranty = new Warranty(warrantyId, "CONSOLE123", "SALE1", true, 100.0);
                        warrantyService.registerWarranty(warranty);

                        System.out.println("Warranty successfully registered!");
                    } catch (UnsupportedWarrantyException e) {
                        System.out.println("Error: only consoles can have an extended warranty.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);

        scanner.close();
    }
}
