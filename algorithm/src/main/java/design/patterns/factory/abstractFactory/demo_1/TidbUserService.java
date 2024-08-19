package design.patterns.factory.abstractFactory.demo_1;

import design.patterns.factory.abstractFactory.User;

public class TidbUserService {
    public void insert(User user) {
        System.out.printf("insert user to Tidb db,userId=" + user.getId());
    }

    public void get(int id) {
        System.out.printf("get user from Tidb db,userId=" + id);
    }
}
