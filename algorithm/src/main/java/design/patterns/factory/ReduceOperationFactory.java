package design.patterns.factory;

public class ReduceOperationFactory implements  IOperationFactory{
    @Override
    public Operation createOperation() {
        return new ReduceOperation();
    }
}
