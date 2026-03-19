# Part 2: Proposed Redesign Using CRC Cards

The redesigned system decomposes the monolithic `OrderProcessor` into several highly-cohesive classes. This promotes loose coupling and adheres to the Single Responsibility Principle.

### CRC Card 1: Order
| Class: Order | |
| :--- | :--- |
| **Responsibilities** | **Collaborators** |
| - Maintain order details (customer, item, price) | - TaxCalculator |
| - Encapsulate data with private fields/getters | - DiscountService |

---

### CRC Card 2: TaxCalculator
| Class: TaxCalculator | |
| :--- | :--- |
| **Responsibilities** | **Collaborators** |
| - Calculate tax based on item price | - Order |

---

### CRC Card 3: DiscountService
| Class: DiscountService | |
| :--- | :--- |
| **Responsibilities** | **Collaborators** |
| - Determine eligibility for discounts | - Order |
| - Calculate the discounted total | |

---

### CRC Card 4: OrderRepository
| Class: OrderRepository | |
| :--- | :--- |
| **Responsibilities** | **Collaborators** |
| - Persist order data to a storage medium (File/DB) | - Order |

---

### CRC Card 5: NotificationService
| Class: NotificationService | |
| :--- | :--- |
| **Responsibilities** | **Collaborators** |
| - Send confirmation emails to customers | - Order |

---

### CRC Card 6: OrderManager (Coordinator)
| Class: OrderManager | |
| :--- | :--- |
| **Responsibilities** | **Collaborators** |
| - Orchestrate the order fulfillment workflow | - Order, TaxCalculator |
| - Sequence tax, discount, saving, and notification | - DiscountService, OrderRepository |
| | - NotificationService |
