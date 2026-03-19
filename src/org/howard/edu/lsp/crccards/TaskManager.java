package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects. Provides operations to add tasks,
 * find a task by its ID, and retrieve tasks by their status.
 * Duplicate task IDs are not allowed.
 * 
 * @author Samyak Baidya
 */
public class TaskManager {
    private Map<String, Task> tasks;

    /**
     * Constructs an empty TaskManager.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a task to the manager. If a task with the same ID already exists,
     * an IllegalArgumentException is thrown.
     * 
     * @param task the Task object to add
     * @throws IllegalArgumentException if a task with the same ID is already present
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists: " + task.getTaskId());
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds and returns a task by its ID.
     * 
     * @param taskId the ID of the task to find
     * @return the Task with the given ID, or null if no such task exists
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Returns a list of all tasks whose status matches the given status.
     * 
     * @param status the status to filter by (e.g., "OPEN", "IN_PROGRESS", "COMPLETE")
     * @return a List of Task objects with the specified status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}