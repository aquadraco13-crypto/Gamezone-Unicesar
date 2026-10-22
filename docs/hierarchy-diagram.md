# Hierarchy Diagram

```mermaid
classDiagram
    class Product {
        <<abstract>>
    }
    class VideoGame
    class Console

    class Person {
        <<abstract>>
    }
    class Customer
    class Seller

    Product <|-- VideoGame
    Product <|-- Console
    Person <|-- Customer
    Person <|-- Seller