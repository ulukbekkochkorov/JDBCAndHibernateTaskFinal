package peaksoft;
import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.util.Util;


public class Main {
    public static void main(String[] args) {
//        UserDao userDao = new UserDaoJdbcImpl();
        UserDaoHibernateImpl userDao1 = new UserDaoHibernateImpl();

//       userDao.createUsersTable();
//        userDao.dropUsersTable();
//        userDao.cleanUsersTable();
//        userDao.saveUser("Asan", "Asanov", (byte)18);
//        userDao.removeUserById(1);
//        userDao.getAllUsers();
        userDao1.createUsersTable();
//        userDao1.saveUser("Marat", "Asanov", (byte) 20);
    }
}
