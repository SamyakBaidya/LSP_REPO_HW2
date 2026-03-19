# Design Evaluation: PriceCalculator

The original implementation of `PriceCalculator` suffers from several design flaws that hinder maintainability and extensibility:

1.  **Violation of the Open/Closed Principle (OCP):** Every time a new customer type (e.g., "STUDENT" or "SENIOR") is added, the `calculatePrice` method must be modified. A class should be open for extension but closed for modification.
2.  **Poor Scalability:** As the number of customer types grows, the `if-else` or `switch` logic becomes a "long method" that is difficult to read, test, and debug.
3.  **Lack of Encapsulation:** The specific discount algorithms are hard-coded directly into the calculator. These algorithms cannot be reused elsewhere or changed at runtime without altering the core logic.
4.  **Fragility:** Modifying the method to change one discount rate risks accidentally breaking the logic for other customer types.
