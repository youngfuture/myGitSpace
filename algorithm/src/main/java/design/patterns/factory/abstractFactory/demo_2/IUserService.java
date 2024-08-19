package design.patterns.factory.abstractFactory.demo_2;

import design.patterns.factory.abstractFactory.User;

public interface IUserService {

    void insert(User user);

    User get(String id);
}
