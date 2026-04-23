Question 1: Concurrency and Design
Part 1: Shared Resources and Risk
Shared Resource #1: nextId (An integer primitive used as a counter)

Shared Resource #2: requests (A List<String> implemented as an ArrayList)

Concurrency Problem: A Race Condition occurs because multiple threads can access and modify the same data simultaneously without coordination.

Why addRequest() is unsafe: This method performs non-atomic operations. Multiple threads can read the same value of nextId before it is incremented, leading to duplicate request IDs. Additionally, ArrayList is not thread-safe; simultaneous additions can corrupt the internal array structure or lead to data loss.

Part 2: Evaluate Fixes
Fix A (synchronized getNextId): Incorrect. This only protects the counter increment. The addRequest method still modifies the requests list outside of a synchronized block, leaving the list vulnerable to corruption.

Fix B (synchronized addRequest): Correct. By synchronizing the entry point, we ensure that only one thread can execute the logic at a time, protecting both the counter and the list modifications atomically.

Fix C (synchronized getRequests): Incorrect. Synchronizing the getter only protects the act of returning the list reference. It provides no protection for the data when new requests are being added.

Part 3: Object-Oriented Design
Answer: No, getNextId() should not be public.

Explanation: Based on Arthur Riel’s Heuristics, a class should hide its implementation details and internal state. Exposing the ID generator allows external classes to interfere with the internal counting logic without actually adding a request, which violates the encapsulation and integrity of the RequestManager.

Part 4: Alternative Synchronization Approach
Description:
Instead of using synchronized, we can use Atomic Variables and Thread-Safe Collections from the java.util.concurrent package to achieve thread safety with better performance.

Code Snippet:

private AtomicInteger nextId = new AtomicInteger(1);
private List<String> requests = new CopyOnWriteArrayList<>();

public void addRequest(String studentName) {
    int id = nextId.getAndIncrement();
    requests.add("Request-" + id + " from " + studentName);
}

