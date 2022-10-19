package peaksoft;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJdbcImpl();

//       userDao.createUsersTable();
//        userDao.dropUsersTable();
//        userDao.cleanUsersTable();
//        userDao.saveUser("Asan", "Asanov", (byte)18);
//        userDao.removeUserById(1);
        userDao.getAllUsers();
    }
}
