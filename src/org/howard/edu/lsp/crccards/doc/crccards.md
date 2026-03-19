
TaskManager collaborates with Task because it needs to access task information (ID, description, status) 
to fulfill its responsibilities of storing tasks, finding by ID, and retrieving tasks by status. Task does not 
collaborate with TaskManager because its responsibilities are limited to storing its own information and updating 
its own status, with no need to know about the manager or other tasks. This creates a one-way dependency where 
the manager uses tasks, but tasks operate independently.