package design.patterns.factory.abstractFactory.demo_2;

public class TidbServiceFactory implements IFactory{

    @Override
    public IUserService createUserService() {
        return new TidbUserService();
    }
}
