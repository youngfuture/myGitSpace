package design.patterns.factory.abstractFactory.demo_4.mysql;


import design.patterns.factory.abstractFactory.User;
import design.patterns.factory.abstractFactory.demo_4.IUserService;

public class MySQLUserService implements IUserService {

    @Override
    public void insert(User user) {
        System.out.printf("insert user to MySQL db,userId=" + user.getId());
    }

    @Override
    public User get(String id) {
        User user=new User();
        user.setId(id);
        System.out.printf("get user from MySQL db,userId=" + id);
        return user;
    }
}
