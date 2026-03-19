# Development Log - Question 2

### Resources Used
1. **Gemini (AI Tool)**
   - **Query:** "Evaluate this Java class based on Arthur Riel's heuristics and provide CRC cards for a redesign."
   - **Contribution:** Helped identify the specific Riel heuristics (God Object, Encapsulation) and provided the structural layout for the CRC cards to ensure all responsibilities of the original code were accounted for in the new design.
2. **Lecture Notes**
   - **Focus:** Reviewed the Single Responsibility Principle and the definition of Cohesion vs. Coupling.
   - **Contribution:** Used to validate that the "OrderManager" should act as a coordinator rather than containing the logic itself.

### Self-Correction/Refinement
Initially, I considered putting the tax calculation inside the `Order` class. However, following Riel’s advice to keep data objects slim, I moved it to a dedicated `TaxCalculator` to allow for different tax regions in the future.