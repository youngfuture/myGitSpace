package design.patterns.factory;

public class ReduceOperation extends Operation {

    @Override
    public double getResult() {
        return super.getA() - super.getB();
    }
}
