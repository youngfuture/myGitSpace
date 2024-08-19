package design.patterns.factory.abstractFactory.demo_2;

import design.patterns.factory.abstractFactory.User;

public class TidbUserService implements IUserService {

    @Override
    public void insert(User user) {
        System.out.printf("insert user to Tidb db,userId=" + user.getId());
    }

    @Override
    public User get(String id) {
        User user=new User();
        user.setId(id);
        System.out.printf("get user from Tidb db,userId=" + id);
        return user;
    }
}
