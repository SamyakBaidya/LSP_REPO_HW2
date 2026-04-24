Heuristic 1:
Name: All data should be hidden within its class.
Explanation: This ensures encapsulation by hiding internal state, making the code more maintainable. In lecture, this was shown by explaining that exposing fields directly makes refactoring difficult and breaks external dependencies.

Heuristic 2:
Name: Users of a class must be dependent on its public interface, but a class should not be dependent on its users.
Explanation: This promotes loose coupling and reusability. Class discussions emphasized that a class should remain "unaware" of who calls it, allowing it to function as a modular, independent component.

Heuristic 3:
Name: Distribute system intelligence horizontally as uniformly as possible.
Explanation: This prevents "God Classes" from dominating the system. It improves readability by ensuring logic is placed where the data lives, which was illustrated in class by contrasting centralized controllers with decentralized, behavior-rich objects.