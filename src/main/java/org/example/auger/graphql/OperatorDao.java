package org.example.auger.graphql;
import java.util.List;


public class OperatorDao {

    private final List<Operator> operators;

    public OperatorDao(List<Operator> operators) {
        this.operators = operators;
    }


    public Operator getOperator(String id) {
        return operators.stream()
                .filter(operator -> id.equals(operator.getId()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
