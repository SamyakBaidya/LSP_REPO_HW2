# Part 1: Design Evaluation of OrderProcessor

The `OrderProcessor` class violates several fundamental object-oriented design principles, leading to poor maintainability, low cohesion, and high coupling. Below is an evaluation of its specific design flaws, referencing concepts similar to Arthur Riel's object-oriented design heuristics.

### 1. Poor Encapsulation (Violation of Data Hiding)
* **Issue:** The class exposes its internal data (`customerName`, `email`, `item`, `price`) as public fields.
* **Impact:** This allows any external class to directly modify the state of an `OrderProcessor` object without validation. If the internal data structure changes, every class using these fields breaks. This violates the principle of hiding implementation details.

### 2. Low Cohesion (The "God Object" Anti-pattern)
* **Issue:** The class is a "Jack of all trades." It handles data storage, business logic (tax/discounts), File I/O, console output, and email simulation.
* **Impact:** According to Riel’s heuristics, a class should not be a "God Object." Because it has too many responsibilities, it has too many reasons to change. A change in the tax law, a move to a database, or a change in email provider all require modifying this same file, increasing the risk of regression bugs.

### 3. Logic Ordering and Functional Errors
* **Issue:** The discount is applied *after* the receipt is printed and the order is saved to the file.
* **Impact:** The system generates incorrect data. The "orders.txt" file and the printed receipt reflect the expensive total, while the actual business logic intends for a 10% reduction. This is a side effect of procedural programming masquerading as an object.

### 4. Tight Coupling and Rigidity
* **Issue:** The class directly instantiates `FileWriter` and uses `System.out`.
* **Impact:** The logic is hard-coded to a text file and the console. You cannot easily unit test this class without actually writing to the disk, nor can you reuse it in a mobile or web context where "printing to console" is irrelevant.

### 5. Lack of Separation of Concerns
* **Issue:** There is no distinction between the "Order" (the data) and the "Processor" (the behavior). 
* **Impact:** You cannot have an "Order" object without also having the overhead of the processing logic. This makes the system inflexible and difficult to extend.
