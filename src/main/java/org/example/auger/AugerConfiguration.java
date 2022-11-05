package org.example.auger;

import org.example.auger.graphql.Operator;
import org.example.auger.graphql.OperatorDao;
import org.example.auger.graphql.Task;
import org.example.auger.graphql.TaskDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AugerConfiguration {

    @Bean
    public OperatorDao operatorDao() {
        List<Operator> operators = new ArrayList<>();
        for (int operatorId = 0; operatorId < 10; ++operatorId) {
                Operator operator = new Operator();
                operator.setId("Operator:" + operatorId);
                operator.setName("Operator name " + operatorId);
                operator.setType("Operator type");
                operators.add(operator);
            }
        return new OperatorDao(operators);
    }

    @Bean
    public TaskDao taskDao() {
        List<Task> tasks = new ArrayList<>();
        for (int taskId = 0; taskId < 10; ++taskId) {
            for (int operatorId = 0; operatorId < 10; ++operatorId) {
                Task task = new Task();
                task.setNumber("Task " + taskId + operatorId);
                task.setOperatorId("Operator:" + operatorId);
                tasks.add(task);
            }
        }
        return new TaskDao(tasks);
    }
}
