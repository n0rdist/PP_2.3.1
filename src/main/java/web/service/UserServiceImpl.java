package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.UserDao;
import web.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public User readUser(int id) {
        return userDao.readUser(id);
    }

    @Override
    public void updateUser(int id, String name, String lastname, int age) {
        userDao.updateUser(id, name, lastname, age);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
