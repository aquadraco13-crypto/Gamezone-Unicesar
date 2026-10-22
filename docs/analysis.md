System Analysis \& Design - GameZone Unicesar



\## 1. People in the System

`Person` is the abstract base class containing common fields (`id`, `name`, `phone`). `Customer` adds `email` and purchase history, while `Seller` adds `employeeCode` and `shift`.



\## 2. Generic Person Instantiation

No. A generic person doesn't exist in our business logic—everyone is either a customer or a seller. Making `Person` abstract prevents direct instantiation.



\## 3. Products in the System

`Product` holds basic properties (`id`, `title`, `price`, `stock`). `VideoGame` extends it with `platform`, `genre`, and `ageRating`. `Console` extends it with `brand`, `model`, and `generation`.



\## 4. Product Description Behavior

We declare `public abstract String getDescription()` in `Product`. Subclasses override this method to return their specific details using polymorphism.



\## 5. Sales \& Relationships

`Sale` uses associations/aggregations: it holds 1 `Customer`, 1 `Seller`, and a list of 1 or more `Product` items. These are domain relationships, not inheritance.



\## 6. Total Sale Calculation

`Sale` calculates its own total sum by iterating through its list of products.



\## 7. Business Constraints - Sale Validation

Validations (like ensuring at least one product is added) belong in `SaleService` before persisting the transaction.



\## 8. Inventory Update

When `SaleService` registers a sale, it calls `ProductService` to verify available stock and reduce the inventory quantities accordingly.



\## 9. Four-Layer Architecture

\- \*\*Model:\*\* Domain classes (`Product`, `Person`, `Sale`).

\- \*\*Persistence:\*\* File handling repositories.

\- \*\*Service:\*\* Business rules and validations.

\- \*\*UI:\*\* Console menus and user input.



\## 10. Separation of Concerns

Putting file logic inside model classes breaks the Single Responsibility Principle and couples data to storage formats. Separating them makes the system easier to maintain.



\## 11. Layer Dependencies

Allowed flow: `UI` -> `Service` -> `Persistence` \& `Model`. 

UI should never talk directly to Persistence, and Model doesn't depend on any upper layer.

