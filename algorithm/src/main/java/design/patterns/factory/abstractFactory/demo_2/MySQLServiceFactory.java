package design.patterns.factory.abstractFactory.demo_2;

public class MySQLServiceFactory implements IFactory{

    @Override
    public IUserService createUserService() {
        return new MySQLUserService();
    }
}
