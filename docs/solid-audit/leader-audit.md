# SOLID Audit Report - Technical Leader

## Scope
Classes and methods audited under Technical Leader responsibility:
- `com.gamezone.model.Sale`
- `com.gamezone.repository.SaleRepository`
- `com.gamezone.service.SaleService`
- `com.gamezone.ui.ConsoleMenu`
- `com.gamezone.Main`
- `com.gamezone.service.ProductService.restoreStock`

---

## 1. Single Responsibility Principle (SRP)
- **Verdict**: Violation
- **ID**: V-LEADER-01
- **Module**: Sales / UI (Taller 1 & Integration)
- **Evidence**: `ConsoleMenu.java` handles user input/output, menu loop orchestration, and business flow coordination across all modules.
- **Explanation**: The class has multiple reasons to change (UI layout changes, new menu options, validation error formatting).
- **Consequence**: High coupling in UI layer makes maintenance difficult and increases risk when extending menu features.
- **Proposed Solution**: Move menu action handlers to separate Controller or Action classes.
- **Code of another team member**: No.

---

## 2. Open/Closed Principle (OCP)
- **Verdict**: Violation
- **ID**: V-LEADER-02
- **Module**: Sales Integration (`SaleService.java`)
- **Evidence**: `SaleService.registerSale` uses explicit type checks and conditional logic when handling discounts, warranties, and stock delegation.
- **Explanation**: Adding a new product type or discount strategy requires modifying `SaleService.java`.
- **Consequence**: Increases risk of regressions whenever new requirements are introduced.
- **Proposed Solution**: Introduce abstractions/interfaces for discount processing and item stock updates.
- **Code of another team member**: Yes (Developer 1 / Developer 2 models).

---

## 3. Liskov Substitution Principle (LSP)
- **Verdict**: Not Applicable
- **Explanation**: The audited classes under Leader responsibility do not extend base domain classes or implement polymorphic hierarchies directly.

---

## 4. Interface Segregation Principle (ISP)
- **Verdict**: Correct
- **Evidence**: `SaleRepository` defines focused methods specific to sale persistence without forcing unused methods on callers.

---

## 5. Dependency Inversion Principle (DIP)
- **Verdict**: Violation
- **ID**: V-LEADER-03
- **Module**: Sales Service (`SaleService.java`) and UI (`ConsoleMenu.java`)
- **Evidence**: `SaleService` depends directly on concrete repository classes (`SaleRepository`, `ProductRepository`) instead of abstractions.
- **Explanation**: High-level business logic is coupled directly to low-level persistence implementations.
- **Consequence**: Difficult to unit test with mocks or swap persistence storage mechanisms.
- **Proposed Solution**: Introduce interfaces for repositories and inject them into services.
- **Code of another team member**: Yes (Developer 1 & Developer 2 repositories).