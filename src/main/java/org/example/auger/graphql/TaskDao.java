package org.example.auger.graphql;

import java.util.List;
import java.util.stream.Collectors;

public class TaskDao {

    private final List<Task> tasks;

    public TaskDao(List<Task> tasks) {
        this.tasks = tasks;
    }


    public List<Task> getOperatorTasks(String operator) {
        return tasks.stream()
                .filter(task -> operator.equals(task.getOperatorId()))
                .collect(Collectors.toList());
    }

    public List<Task> getLastTask(int count, int offset) {
        return tasks.stream()
                .skip(offset)
                .limit(count)
                .collect(Collectors.toList());
    }

    public Task getTask(String number) {
        return tasks.stream()
                .filter(task -> number.equals(task.getNumber()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public void saveTask(Task task) {
        tasks.add(task);
    }
}
