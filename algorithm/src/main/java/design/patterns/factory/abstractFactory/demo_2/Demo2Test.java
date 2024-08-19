package design.patterns.factory.abstractFactory.demo_2;

import design.patterns.factory.abstractFactory.User;

public class Demo2Test {
    public static void main(String[] args) {
        //工厂方法模式

        User user = new User();

        MySQLServiceFactory mysqlServiceFactory = new MySQLServiceFactory();

        IUserService userService = mysqlServiceFactory.createUserService();

        userService.insert(user);

    }
}
