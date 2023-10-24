package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao=new UserDaoJdbcImpl();
    UserDao userDao1=new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDao.createUsersTable();

    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
        userDao1.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
        userDao1.saveUser(name, lastName,age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
        userDao1.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao1.getAllUsers();
    }

        public void cleanUsersTable() {
        userDao.cleanUsersTable();
        userDao1.cleanUsersTable();
    }
}
