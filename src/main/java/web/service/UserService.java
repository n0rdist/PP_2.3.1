package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    User readUser(int id);

    void updateUser(int id, String name, String lastname, int age);

    void deleteUser(int id);

    List<User> getUsers();
}