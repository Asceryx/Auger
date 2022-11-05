package org.example.auger.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class OperatorController {

    private final TaskDao taskDao;

    private final OperatorDao operatorDao;

    public OperatorController(TaskDao taskDao, OperatorDao operatorDao) {
        this.taskDao = taskDao;
        this.operatorDao = operatorDao;
    }

    @SchemaMapping
    public List<Task> tasks(Operator operator) {
        return taskDao.getOperatorTasks(operator.getId());
    }

    @QueryMapping
    public Operator operator(@Argument String id) {
        return operatorDao.getOperator(id);
    }
}
