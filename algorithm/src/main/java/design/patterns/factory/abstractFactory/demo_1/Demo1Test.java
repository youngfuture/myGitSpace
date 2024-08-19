package design.patterns.factory.abstractFactory.demo_1;

import design.patterns.factory.abstractFactory.User;

public class Demo1Test {
    public static void main(String[] args) {
        //最简单的方法

        User user = new User();

        MySQLUserService mySQLUserService = new MySQLUserService();

        mySQLUserService.insert(user);

        mySQLUserService.get(1);
    }
}
