\# GRASP Audit Report - Developer 2



\## 1. Scope

This audit covers the classes, repositories, and services developed under Developer 2 responsibility across all project iterations:



\* \*\*Person Module:\*\* `Person`, `Customer`, `Seller`, `PersonRepositoryImpl`, `PersonServiceImpl`

\* \*\*Accessory Module:\*\* `AccessoryRepository`, `AccessoryService`

\* \*\*Promotion Module:\*\* `PromotionRepository`, `PromotionService`

\* \*\*Return Module:\*\* `ReturnRepository`, `ReturnService` (including monthly balance logic)

\* \*\*Warranty Module:\*\* `WarrantyRepository`, `WarrantyService`

\* \*\*Cross-Cutting:\*\* Validation delegation and custom exception usage in services and repositories.



\---



\## 2. Pattern Evaluation



\### 2.1 Information Expert

\* \*\*Verdict:\*\* Violation

\* \*\*ID:\*\* V-DEV2-01

\* \*\*Module:\*\* Person Module / Taller 1

\* \*\*Evidence:\*\* `PersonServiceImpl.java` line 24 (`findById` method filtering logic)

\* \*\*Explanation:\*\* The service explicitly interrogates person objects to compare IDs rather than encapsulating ID comparison or business rules within the domain class.

\* \*\*Consecuence:\*\* Tight coupling between service filtering and internal state representation.

\* \*\*Proposed Solution:\*\* Delegate identity checks or specific validation directly to domain entities.

\* \*\*Code from other member:\*\* No.



\### 2.2 Creator

\* \*\*Verdict:\*\* Correct

\* \*\*Evidence:\*\* `PersonServiceImpl.java` instantiates `PersonRepositoryImpl` as the service manages person data persistence.

\* \*\*Explanation:\*\* The service directly uses and records person data, adhering to Creator principles.



\### 2.3 Controller

\* \*\*Verdict:\*\* Not Applicable

\* \*\*Explanation:\*\* UI event handling and system coordination are managed by `ConsoleMenu`, which is under Leader responsibility.



\### 2.4 Low Coupling

\* \*\*Verdict:\*\* Violation

\* \*\*ID:\*\* V-DEV2-02

\* \*\*Module:\*\* Return \& Warranty Services

\* \*\*Evidence:\*\* `ReturnService` and `WarrantyService` directly instantiate concrete repository implementations (`new ReturnRepository()`, `new WarrantyRepository()`).

\* \*\*Explanation:\*\* Services depend on concrete file implementation classes rather than abstract repository interfaces.

\* \*\*Consecuence:\*\* Changing storage mechanism requires modifying service business logic.

\* \*\*Proposed Solution:\*\* Inject repository interfaces into service constructors.

\* \*\*Code from other member:\*\* No.



\### 2.5 High Cohesion

\* \*\*Verdict:\*\* Correct

\* \*\*Evidence:\*\* `ReturnService.java` focuses exclusively on return operations and monthly balance computations.

\* \*\*Explanation:\*\* Responsibilities are strictly bounded to return domain rules.



\### 2.6 Polymorphism

\* \*\*Verdict:\*\* Not Applicable

\* \*\*Explanation:\*\* Polymorphic behaviors for discounts and product hierarchies are audited under Developer 1 / Leader scopes.



\### 2.7 Pure Fabrication

\* \*\*Verdict:\*\* Correct

\* \*\*Evidence:\*\* `PersonRepositoryImpl.java` handles file storage.

\* \*\*Explanation:\*\* Persistence is separated into a Pure Fabrication class to avoid cluttering domain models.



\### 2.8 Indirection

\* \*\*Verdict:\*\* Violation

\* \*\*ID:\*\* V-DEV2-03

\* \*\*Module:\*\* Exception \& Validation Layer

\* \*\*Evidence:\*\* Inline throw statements of general `RuntimeException` inside `PersonServiceImpl` and `SaleService`.

\* \*\*Explanation:\*\* Validation errors bypass custom domain-specific exceptions (`PersistenceException` / `ValidationException`).

\* \*\*Consecuence:\*\* UI cannot differentiate between I/O failures and domain validation errors.

\* \*\*Proposed Solution:\*\* Introduce dedicated indirection/exception mapping in service layers.

\* \*\*Code from other member:\*\* Yes (Leader code affected in shared exception handling).



\### 2.9 Protected Variations

\* \*\*Verdict:\*\* Correct

\* \*\*Evidence:\*\* Interfaces `IPersonRepository` and `IPersonService` shield clients from concrete implementation changes.

