package design.patterns.factory;

import lombok.Data;

@Data
public class OperationFactory {
    public static Operation createOperation(String operationSymbol) throws Exception {
        if ("+".equals(operationSymbol)) {
            return new AddOperation();
        } else if ("-".equals(operationSymbol)) {
            return new ReduceOperation();
        } else {
            throw new Exception("不支持的操作符");
        }
    }
}
