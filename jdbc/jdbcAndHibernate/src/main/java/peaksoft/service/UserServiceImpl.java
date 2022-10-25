package peaksoft.service;

import org.hibernate.HibernateException;
import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoJdbcImpl();
    private UserDao userDao1 = new UserDaoHibernateImpl();

    public void createUsersTable() {
//   userDao.createUsersTable();
            userDao1.createUsersTable();
            System.out.println("Table created successfully!");
        }

    public void dropUsersTable() {
//        userDao.dropUsersTable();
        userDao1.dropUsersTable();
    }
    public void saveUser(String name, String lastName, byte age) {
//        try {
//            userDao.saveUser(name, lastName, age);
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
        try {
            userDao1.saveUser(name, lastName, age);
        }catch (HibernateException | SQLException e){
            e.getMessage();
        }

    }

    public void removeUserById(long id) {
//        try{
//            userDao.removeUserById(id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
       try {
           userDao1.removeUserById(id);
       }catch (HibernateException | SQLException e) {
           e.getMessage();
       }

    }

    public List<User> getAllUsers() {
//        return userDao.getAllUsers();
        return userDao1.getAllUsers();
    }

    public void cleanUsersTable() {
//        userDao.cleanUsersTable();
        userDao1.cleanUsersTable();
    }
}
