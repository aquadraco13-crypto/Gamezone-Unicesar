# Layer Architecture Diagram

```mermaid
graph TD
    subgraph UI_Layer [UI Layer]
        MainUI[ConsoleUI / Main]
    end

    subgraph Service_Layer [Service Layer]
        ProductService[ProductService]
        PersonService[PersonService]
        SaleService[SaleService]
    end

    subgraph Persistence_Layer [Persistence Layer]
        ProductRepo[ProductRepository]
        PersonRepo[PersonRepository]
        SaleRepo[SaleRepository]
    end

    subgraph Model_Layer [Model Layer]
        ModelEntities[Domain Classes]
    end

    MainUI --> ProductService
    MainUI --> PersonService
    MainUI --> SaleService

    ProductService --> ProductRepo
    ProductService --> ModelEntities
    PersonService --> PersonRepo
    PersonService --> ModelEntities
    SaleService --> SaleRepo
    SaleService --> ModelEntities

    ProductRepo --> ModelEntities
    PersonRepo --> ModelEntities
    SaleRepo --> ModelEntities