# Development Log

## AI Tool (ChatGPT) – Full Conversation Transcript

**User:** I have an exam problem: implement Task and TaskManager from CRC cards, with given Driver. Can you guide me?

**AI:** Yes. Task needs fields taskId, description, status (default OPEN). Constructor, getters, setStatus (valid values OPEN, IN_PROGRESS, COMPLETE else UNKNOWN). toString format: "taskId description [status]".

**User:** Show Task code.

**AI:**
```java
class Task {
    private String id, desc, status = "OPEN";
    Task(String id, String desc) { this.id = id; this.desc = desc; }
    String getTaskId() { return id; }
    String getDescription() { return desc; }
    String getStatus() { return status; }
    void setStatus(String s) { status = (s.equals("OPEN") || s.equals("IN_PROGRESS") || s.equals("COMPLETE")) ? s : "UNKNOWN"; }
    public String toString() { return id + " " + desc + " [" + status + "]"; }
}
```

**User:** TaskManager? Data structure?

**AI:** HashMap<String,Task> for O(1) lookup and duplicate prevention. getTasksByStatus iterates values and collects matches.

**User:** Show TaskManager code.

**AI:**
```java
import java.util.*;
class TaskManager {
    Map<String,Task> tasks = new HashMap<>();
    void addTask(Task t) {
        if (tasks.containsKey(t.getTaskId())) throw new IllegalArgumentException("Duplicate ID");
        tasks.put(t.getTaskId(), t);
    }
    Task findTask(String id) { return tasks.get(id); }
    List<Task> getTasksByStatus(String s) {
        List<Task> r = new ArrayList<>();
        for (Task t : tasks.values()) if (t.getStatus().equals(s)) r.add(t);
        return r;
    }
}
```

**User:** Javadoc example?

**AI:** Add class description with @author, @param and @return for methods.

**User:** crccards.md explanation?

**AI:** TaskManager needs Task data to manage; Task doesn't need manager – unidirectional collaboration.

## Other Resources

- Oracle HashMap docs: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html – verified containsKey behavior.
- Stack Overflow: https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap – iterating HashMap values.
- Lecture notes: CRC Cards (Howard LSP) – collaboration direction.