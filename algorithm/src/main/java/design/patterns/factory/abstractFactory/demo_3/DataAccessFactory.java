package design.patterns.factory.abstractFactory.demo_3;

import design.patterns.factory.abstractFactory.demo_2.IUserService;
import design.patterns.factory.abstractFactory.demo_2.MySQLUserService;
import design.patterns.factory.abstractFactory.demo_2.TidbUserService;

public class DataAccessFactory {
    public static IUserService createUserService(String dbName) throws Exception {
        if (dbName.equals("MySQL")) {
            return new MySQLUserService();
        } else if (dbName.equals("TiDB")) {
            return new TidbUserService();
        } else {
            throw new Exception("不支持的数据库");
        }
    }
}
