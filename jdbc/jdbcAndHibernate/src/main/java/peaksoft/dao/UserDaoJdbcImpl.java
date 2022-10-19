package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }


    public void createUsersTable() {
        String sql = "create table if not exists Users(id serial primary key, name varchar (26), last_name varchar (25), age int)";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String drop = "drop table if exists Users";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(drop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String save = "Insert into Users (name, last_name, age) values (?, ?, ?);";
        try (Connection connection = Util.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(save)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SQLException();
        }

    }

    public void removeUserById(long id) throws SQLException {
    String query = "delete from Users where id = ?";
    try (Connection connection = Util.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        throw new SQLException();
    }

    }

    public List<User> getAllUsers() {
      String query = "select * from users;";
      List<User> list = new ArrayList<>();
      try (Connection connection = Util.connection();
      Statement statement = connection.createStatement();
           ResultSet res = statement.executeQuery(query)) {
          while ((res.next())) {
              User user = new User();
              user.setId(res.getLong("id"));
              user.setName(res.getString("name"));
              user.setLastName(res.getString("last_name"));
              user.setAge(res.getByte("age"));
              list.add(user);
          }
      }catch (SQLException e) {
          e.printStackTrace();
      }return list;
    }

    public void cleanUsersTable() {
        String clean = "delete from users";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(clean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}