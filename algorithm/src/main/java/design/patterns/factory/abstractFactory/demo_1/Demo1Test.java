package design.patterns.factory.abstractFactory.demo_1;

import design.patterns.factory.abstractFactory.User;

public class Demo1Test {
    public static void main(String[] args) {
        //创建用户对象
        User user = new User();

        //MySQLUserService serService = new MySQLUserService();
        TidbUserService serService = new TidbUserService();

        serService.insert(user);
        serService.get(1);
    }
}
