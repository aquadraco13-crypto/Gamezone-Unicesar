 SOLID Analysis & Orienting Questions



 1. Decision Criteria & Evidence Requirements

A code fragment was classified as a violation if it directly contradicted a SOLID principle definition. Verdicts were supported by explicit class names, method signatures, and code line references.



 2. Boundary Findings Identification

Boundary violations occurred where `SaleService` directly accessed concrete models and repositories maintained by Developer 1 and Developer 2. These findings were recorded once in the consolidated report and assigned based on class ownership.



 3. Relation to GRASP Audit

Some SOLID violations (e.g., DIP in `SaleService`) coincided with GRASP Low Coupling / High Cohesion issues. Previous GRASP refactorings resolved responsibility assignments, providing a cleaner baseline for SOLID abstraction interfaces.



 4. Non-Regression Strategy

All 10 menu operations are tested using reference input data before and after refactoring. Receipts, stock totals, and error outputs must remain identical.



 5. Correction Order & Branch Coordination

Refactoring is executed in order of dependency (Model abstractions -> Repositories -> Services -> UI). Changes affecting shared classes are coordinated via atomic commits and PR reviews.

