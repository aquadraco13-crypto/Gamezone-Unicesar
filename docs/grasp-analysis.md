# GRASP Analysis and Methodology - GameZone Unicesar

## 1. Criteria for GRASP Pattern Violations
The team evaluates code against the nine GRASP patterns using structural and behavioral criteria. A violation is identified when a class assumes responsibilities outside its domain (low cohesion), couples tightly with external implementation details instead of abstractions (high coupling/low decoupling), or bypasses standard delegation rules (e.g., Creator, Information Expert). Minimum evidence required includes the exact class name, method name, code snippet or line range in the current `develop` branch, and a clear explanation of the resulting rigidity or maintainability risk.

## 2. Boundary Findings Between Team Members
Boundary violations occur when a class managed by one developer directly manipulates or couples with internal logic belonging to another module. For instance, direct validations or data manipulation of product stock inside sales processing or menu interactions. These are registered in the consolidated audit, cross-referencing the originating modules, and assigned to the respective module owners for synchronized correction.

## 3. Overlapping Patterns and Correction Priority
Certain patterns are tightly related, such as Low Coupling and Protected Variations, or Information Expert and High Cohesion. When code violates multiple patterns simultaneously, the primary violation is cataloged under the most foundational structural pattern (e.g., Information Expert or Creator), while secondary impacts are addressed as concurrent benefits during the refactoring process to avoid duplicate tracking.

## 4. Preservation of External Behavior (No-Regression Strategy)
To ensure the system behavior remains intact, the team establishes a baseline execution matrix covering all menu operations (product registration, sales processing with discounts/warranties, returns, and validations). Before any refactoring, execution results are documented. Each refactoring commit is followed by a regression test running through the console menu with identical inputs to verify identical outputs and messages.

## 5. Refactoring Order and Coordination
Refactoring begins from the innermost domain and model layers outward to services, repositories, and finally UI components (`ConsoleMenu` and `Main`). When a fix spans across team boundaries, changes are coordinated sequentially: domain/service adjustments are merged first via Pull Requests, followed by dependent menu integrations, preventing merge conflicts in the shared `develop` branch.
