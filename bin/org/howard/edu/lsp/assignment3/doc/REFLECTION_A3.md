# REFLECTION – Assignment 3 (Object-Oriented Redesign)

## Overview
In Assignment 2, I implemented the ETL pipeline primarily in a procedural style, with most logic concentrated in one main driver class. In Assignment 3, I redesigned the same pipeline into multiple classes with clearer responsibilities while keeping the exact same behavior as Assignment 2 (same input/output paths, transformations, rounding, row skipping rules, and error handling).

## What is different in the design (A2 vs A3)
**Assignment 2:**
- ETL steps (extract, transform, load) were implemented in a more “all-in-one” style.
- Parsing, transformation rules, and writing were closely tied together in the main flow.

**Assignment 3:**
- The pipeline is decomposed into separate classes:
  - `Product`: represents one CSV row as an object (ProductID, Name, Price, Category, PriceRange).
  - `DataLoader`: reads `data/products.csv`, applies row-skipping rules, and counts rows read/skipped.
  - `DataTransformer`: applies the transformations in the exact required order and performs rounding.
  - `DataWriter`: writes `data/transformed_products.csv` with the required header and formatting.
  - `ETLPipeline`: orchestrates the steps and prints the run summary.
- This separation makes the code easier to read, test, and maintain.

## How Assignment 3 is more object-oriented
- **Encapsulation:** The `Product` class keeps fields private and uses public getters/setters, so data is controlled and organized.
- **Single Responsibility / Decomposition:** Each class has one clear job (extract, transform, load, orchestration).
- **Objects:** Instead of passing raw string arrays around, the program works with `Product` objects.

## OO ideas used (object, class, encapsulation, inheritance, polymorphism)
- **Object/Class:** Each product row becomes a `Product` object; ETL components are separate classes.
- **Encapsulation:** Product data is private, accessed through methods.
- **Inheritance/Polymorphism:** I did not heavily use inheritance/polymorphism because the assignment emphasis was OO decomposition and matching A2 behavior. However, the redesign still demonstrates core OO principles through classes, objects, and encapsulation.

## Testing to confirm Assignment 3 works the same as Assignment 2
I tested the same cases required in Assignment 2:
1. **Robust Sample Input:** Verified output exactly matches the expected `transformed_products.csv` rows and formatting (uppercase names, electronics discount, Premium Electronics rule, correct PriceRange, and 2-decimal HALF_UP rounding).
2. **Empty Input (header only):** Confirmed the program still creates `data/transformed_products.csv` containing only the header.
3. **Missing Input File:** Confirmed the program prints a clear error message and exits cleanly without a stack trace.
4. **Row Skipping:** Confirmed blank rows, rows with wrong field counts, and rows with unparseable ProductID/Price are skipped and do not appear in output, while the run summary counts rows read/transformed/skipped correctly.

## Conclusion
Assignment 3 keeps the same correct behavior as Assignment 2 but is more object-oriented due to better separation of responsibilities and use of a dedicated `Product` class. This redesign improves readability and maintainability while preserving the exact required ETL output and error handling.