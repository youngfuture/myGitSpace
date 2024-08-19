package design.patterns.factory;

public class AddOperationFactory implements  IOperationFactory{
    @Override
    public Operation createOperation() {
        return new AddOperation();
    }
}
