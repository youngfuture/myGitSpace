package design.patterns.factory.abstractFactory.demo_1;

import design.patterns.factory.abstractFactory.User;

public class MySQLUserService {
    public void insert(User user) {
        System.out.printf("insert user to MySQL db,userId=" + user.getId());
    }

    public void get(int id) {
        System.out.printf("get user from MySQL db,userId=" + id);
    }
}
