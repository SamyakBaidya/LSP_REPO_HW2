## AI Usage Report - Question 1

**AI Tools Used:**
Gemini

**Prompts Used:**
1. "Identify shared resources and concurrency risks in the provided RequestManager Java code."
2. "Explain why addRequest() is thread-unsafe based on non-atomic operations."
3. "Provide a short code snippet using AtomicInteger and CopyOnWriteArrayList to make the code thread-safe."

**How AI Helped:**
The AI assisted in identifying the specific race conditions involving the `nextId` counter and the `ArrayList`. It also helped verify Arthur Riel’s heuristics regarding the encapsulation of the ID generation logic.

**Reflection:**
I learned that even if one part of a method is synchronized, the entire operation must be thread-safe to prevent data corruption in collections like ArrayList.