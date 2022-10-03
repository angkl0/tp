package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents a Task in the task list.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {
    private TaskName name;
    private Module module;
    private Deadline deadline;

    public Task(TaskName name, Module module, Deadline deadline) {
        requireAllNonNull(name, module, deadline);
        this.name = name;
        this.module = module;
        this.deadline = deadline;
    }

    public TaskName getName() {
        return name;
    }

    public Module getModule() {
        return module;
    }

    public Deadline getDeadline() {
        return deadline;
    }

    public boolean isSameTask(Task other) {
        if (other == this) {
            return true;
        }

        return other != null
                && other.getName().equals(this.getName())
                && other.getModule().equals(this.getModule());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return otherTask.getName().equals(getName())
                && otherTask.getModule().equals(this.getModule())
                && otherTask.getDeadline().equals(this.getDeadline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.module, this.deadline);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Task: ");

        builder.append(this.getName())
                .append("; Module: ")
                .append(this.getModule())
                .append("; Deadline: ")
                .append(this.getDeadline());

        return builder.toString();
    }
}
