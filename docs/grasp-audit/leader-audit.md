# Technical Leader Audit Report - GameZone Unicesar

## 1. Scope of Audit
The following modules, classes, and methods under the Technical Leader's responsibility have been audited against the nine GRASP patterns:
- **Sales Module**: `Sale` class, `SaleRepository` class, `SaleService` class (including integrations for accessories, promotions, and warranties).
- **Application & UI Module**: `ConsoleMenu` class, `Main` class.
- **Product Integration**: `ProductService.restoreStock` method.

---

## 2. GRASP Pattern Evaluation

### Information Expert
- **Verdict**: Violation
- **Evidence**: `SaleService.registerSale` directly handles stock deductions and validation details instead of delegating domain checks to `Sale` or `Product`.
- **Explanation / Justification**: `Sale` contains the items and total calculations, so it should encapsulate sale-specific operations rather than leaking domain calculations into the service layer.

### Creator
- **Verdict**: Correct
- **Evidence**: `SaleService` creates `Sale` instances when receiving complete sale parameters.
- **Explanation / Justification**: `SaleService` aggregates and processes sales, making it an appropriate candidate for instantiating `Sale` domain objects.

### Controller
- **Verdict**: Correct
- **Evidence**: `ConsoleMenu` acts as the primary user interface controller receiving console events and routing execution to application services.
- **Explanation / Justification**: UI handling is separated from domain logic and directed toward service layers.

### Low Coupling
- **Verdict**: Violation
- **Evidence**: `ConsoleMenu` directly instantiates concrete repository and service classes in initialization blocks.
- **Explanation / Justification**: Direct instantiation creates tight coupling to concrete implementations rather than relying on dependency injection or interface abstractions.

### High Cohesion
- **Verdict**: Violation
- **Evidence**: `SaleService` combines sale orchestration with promotional discount rules and warranty assignment logic directly inside core methods.
- **Explanation / Justification**: Mixing promotion calculations and warranty assignment lowers cohesion within `SaleService`.

### Polymorphism
- **Verdict**: Not Applicable
- **Evidence**: `Sale` and `SaleService` do not manage multiple polymorphic variants of sales in this module layer.
- **Explanation / Justification**: Behavior variations are handled by separate hierarchies in other modules (e.g., Promotion and Warranty).

### Pure Fabrication
- **Verdict**: Correct
- **Evidence**: `SaleRepository` handles persistent file storage for sale entities.
- **Explanation / Justification**: Persistence logic is separated into a repository fabrication class to keep domain entities clean.

### Indirection
- **Verdict**: Correct
- **Evidence**: `SaleService` mediates between `ConsoleMenu` and `SaleRepository`.
- **Explanation / Justification**: The service layer acts as an intermediate coordinator preventing UI components from interacting directly with data persistence layers.

### Protected Variations
- **Verdict**: Violation
- **Evidence**: Hardcoded file paths and direct format handling inside `SaleRepository`.
- **Explanation / Justification**: Structural changes in storage formats or file structures directly impact repository methods without an abstraction layer.

---

## 3. Identified Violations

| ID | Pattern | Module / Requirement | Evidence (Class, Method) | Explanation | Consequence | Proposed Solution | Other Member Code Affected? |
|---|---|---|---|---|---|---|---|
| V-01 | Low Coupling | UI / Main | `ConsoleMenu` | Direct instantiation of concrete services | Hard to substitute implementations | Introduce dependency injection in constructor | No |
| V-02 | High Cohesion | Sales / SaleService | `SaleService.registerSale` | Sales orchestration mixed with promotions and warranties | Rigid method with multiple responsibilities | Delegate discount and warranty applications to strategy handlers | No |
