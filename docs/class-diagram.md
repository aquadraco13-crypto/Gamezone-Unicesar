# Complete Class Diagram

```mermaid
classDiagram
    namespace Model {
        class Product {
            <<abstract>>
            -String id
            -String title
            -double price
            -int stock
            +getDescription()* String
        }
        class VideoGame {
            -String platform
            -String genre
            -String ageRating
            +getDescription() String
        }
        class Console {
            -String brand
            -String model
            -String generation
            +getDescription() String
        }
        class Person {
            <<abstract>>
            -String id
            -String name
            -String phone
        }
        class Customer {
            -String email
        }
        class Seller {
            -String employeeCode
            -String shift
        }
        class Sale {
            -String id
            -LocalDate date
            -double total
            +calculateTotal() double
        }
    }

    Product <|-- VideoGame
    Product <|-- Console
    Person <|-- Customer
    Person <|-- Seller
    Sale "1" --> "1" Customer
    Sale "1" --> "1" Seller
    Sale "1" --> "1..*" Product
