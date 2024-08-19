package design.patterns.factory.abstractFactory.demo_3;

import design.patterns.factory.abstractFactory.User;
import design.patterns.factory.abstractFactory.demo_2.IUserService;

public class Demo3Test {
    public static void main(String[] args) throws Exception {
        //用简单工厂改进抽象工厂

        User user = new User();

        IUserService userService = DataAccessFactory.createUserService();

        userService.insert(user);

    }
}
