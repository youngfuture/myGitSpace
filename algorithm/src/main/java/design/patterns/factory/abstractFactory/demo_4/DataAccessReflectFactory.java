package design.patterns.factory.abstractFactory.demo_4;


public class DataAccessReflectFactory {
    //反射实现

    public static IUserService createUserService(String dbName,String serviceNamePreFix) throws Exception {
        String className="design.patterns.factory.abstractFactory.demo_4."+dbName+"."+serviceNamePreFix+"UserService";

        Class<?> aClass = Class.forName(className);
        IUserService userService = (IUserService) aClass.newInstance();

        return userService;
    }
}
