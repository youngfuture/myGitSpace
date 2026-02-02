package design.patterns.factory.abstractFactory.demo_3;

import design.patterns.factory.abstractFactory.User;
import design.patterns.factory.abstractFactory.demo_2.IUserService;

public class Demo3Test {
    public static void main(String[] args) throws Exception {
        //简单工厂

        //用户对象
        User user = new User();

        //String dbName = "MySQL";
        String dbName = "TiDB";

        IUserService userService = DataAccessFactory.createUserService(dbName);

        userService.insert(user);

    }
}
