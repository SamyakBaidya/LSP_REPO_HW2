package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task with an ID, description, and status.
 * The default status is "OPEN". Status can be updated to one of
 * "OPEN", "IN_PROGRESS", "COMPLETE", or "UNKNOWN" if an invalid value is given.
 * 
 * @author Samyak Baidya
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a new Task with the given ID and description.
     * The status is initialized to "OPEN".
     * 
     * @param taskId the unique identifier of the task
     * @param description a short description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     * 
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     * 
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the current status of the task.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the task status. Allowed values are "OPEN", "IN_PROGRESS", "COMPLETE".
     * If any other value is supplied, the status is set to "UNKNOWN".
     * 
     * @param status the new status
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string representation of the task in the format:
     * taskId description [status]
     * 
     * @return formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}