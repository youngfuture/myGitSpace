package design.patterns.factory;

public class AddOperation extends Operation {

    @Override
    public double getResult() {
        return super.getA() + super.getB();
    }
}
