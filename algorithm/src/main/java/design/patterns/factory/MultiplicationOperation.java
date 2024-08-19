package design.patterns.factory;

public class MultiplicationOperation extends Operation {

    @Override
    public double getResult() {
        return super.getA() * super.getB();
    }
}
