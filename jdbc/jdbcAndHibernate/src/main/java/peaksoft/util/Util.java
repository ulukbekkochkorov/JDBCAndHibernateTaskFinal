package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String username = "postgres";
    private static final String password = "2406";
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    public static Connection connection () throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
//    public static SessionFactory createSessionFactory(){
//        Properties properties = new Properties();
//        properties.put(Environment.DRIVER, "org.postgresql.Driver");
//        properties.put(Environment.URL, "jdbc:postgres://localhost:5432/postgres");
//        properties.put(Environment.USER, "postgres");
//        properties.put(Environment.PASS, "2406");
//        properties.put(Environment.HBM2DDL_AUTO, "create");
//        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
//        properties.put(Environment.SHOW_SQL, "true");
////<mapping class = "peaksoft,model.User"/>;
//
//        Configuration configuration = new Configuration();
//        configuration.addProperties(properties);
//        configuration.addAnnotatedClass(User.class);
//        return configuration.buildSessionFactory();
//
//    }
    public static EntityManagerFactory createEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("peaksoft");
    }
}
