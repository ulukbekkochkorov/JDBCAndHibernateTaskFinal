package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoJdbcImpl();

    public void createUsersTable() {
userDao.createUsersTable();
    }

    public void dropUsersTable() {
userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            userDao.saveUser(name, lastName, age);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        try{
            userDao.removeUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
