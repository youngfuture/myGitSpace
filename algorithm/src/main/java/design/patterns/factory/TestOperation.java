package design.patterns.factory;

public class TestOperation {
    public static void main(String[] args) throws Exception {
        AddOperation addOperation = new AddOperation();
        addOperation.setA(1.3);
        addOperation.setB(3.5);
        double addResult = addOperation.getResult();
        System.out.printf("addOperation" + addResult);

        ReduceOperation reduceOperation = new ReduceOperation();
        reduceOperation.setA(3.5);
        reduceOperation.setB(1.5);
        double reduceResult = reduceOperation.getResult();
        System.out.printf("reduceResult" + reduceResult);


        Operation operation = OperationFactory.createOperation("+");
        operation.setA(1.3);
        operation.setB(3.5);
        System.out.printf("reduceResult" + operation.getResult());


        IOperationFactory factory = new AddOperationFactory();
        Operation operation2 = factory.createOperation();
        operation2.setA(1);
        operation2.setB(2);
        System.out.printf("addResult" + operation2.getResult());

    }

}
