package design.patterns.factory.abstractFactory.demo_4;


import design.patterns.factory.abstractFactory.User;

public class Demo4Test {
    public static void main(String[] args) throws Exception {
        //反射实现

        String dbName = "mysql";
        String serviceNamePreFix = "MySQL";


        User user = new User();

        IUserService userService = (IUserService) DataAccessReflectFactory.createUserService(dbName,serviceNamePreFix);

        userService.insert(user);

    }
}
