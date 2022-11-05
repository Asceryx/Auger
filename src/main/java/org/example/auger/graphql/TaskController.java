package org.example.auger.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TaskController {

    private final TaskDao taskDao;

    private final OperatorDao operatorDao;

    public TaskController(OperatorDao operatorDao, TaskDao taskDao) {
        this.operatorDao = operatorDao;
        this.taskDao = taskDao;
    }

    @SchemaMapping
    public Operator operator(Task task) {
        return operatorDao.getOperator(task.getOperatorId());
    }

    @QueryMapping
    public List<Task> lastTasks(@Argument int count, @Argument int offset) {
        return taskDao.getLastTask(count, offset);
    }

    @QueryMapping
    public Task task(@Argument String number) {
        return taskDao.getTask(number);
    }

    @QueryMapping
    public Task searchTask(@Argument String number) {
        return taskDao.getTask(number);
    }

    @MutationMapping
    public Task createTask(@Argument String number, @Argument String operatorId) {
        Task task = new Task();
        task.setNumber(number);
        task.setOperatorId(operatorId);
        taskDao.saveTask(task);

        return task;
    }


}
