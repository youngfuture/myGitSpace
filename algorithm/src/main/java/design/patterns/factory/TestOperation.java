package design.patterns.factory;

public class TestOperation {
    public static void main(String[] args) throws Exception {
        //普通实现
        AddOperation addOperation = new AddOperation();
        addOperation.setA(1.3);
        addOperation.setB(3.5);
        double addResult = addOperation.getResult();
        System.out.printf("addOperation" + addResult);


        //简单工厂
        Operation operation = OperationFactory.createOperation("+");
        operation.setA(1.3);
        operation.setB(3.5);
        System.out.printf("addResult" + operation.getResult());


        //工厂方法
        IOperationFactory factory = new AddOperationFactory();
        Operation operation2 = factory.createOperation();
        operation2.setA(1);
        operation2.setB(2);
        System.out.printf("getResult" + operation2.getResult());

    }
}
