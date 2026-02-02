package design.patterns.factory.abstractFactory.demo_2;

import design.patterns.factory.abstractFactory.User;

public class Demo2Test {
    public static void main(String[] args) {
        //工厂方法模式

        //用户对象
        User user = new User();

        //IFactory serviceFactory = new MySQLServiceFactory();
        IFactory serviceFactory = new TidbServiceFactory();

        IUserService userService = serviceFactory.createUserService();

        userService.insert(user);

    }
}
