package jdbc;

import jdbc.entities.User;
import jdbc.mysqlUtilities.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {

    private Connection connection;

    private PreparedStatement statement;

    public void updateIpByGender(String newIp, String gender) {
        init();
        String sql = "UPDATE MOCK_DATA SET ip_address = ? WHERE gender = ?;";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, newIp);
            statement.setString(2, gender);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void deleteById(int id) {
        init();
        String sql = "delete from MOCK_DATA where id= ?;";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            close();
        }
    }

    public void updateName(int id, String newFirstName) {
        init();
        String sql = "UPDATE MOCK_DATA SET first_name = ? WHERE id=?;";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, newFirstName);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            close();
        }
    }

    public void insert(String firstName, String lastName, String email, String gender, String ipAddress) {
        init();
        String sql = "insert into MOCK_DATA (id, first_name, last_name, email, gender, ip_address) " +
                "values (?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 1001);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, email);
            statement.setString(5, gender);
            statement.setString(6, ipAddress);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            close();
        }
    }

    public List<User> readAllData() {
        init();
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM mock_data";
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("gender"),
                        resultSet.getString("ip_address")
                ));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            close();
        }
        return users;
    }

    private void init(){
        statement = null;
        Connectible sqlConnector = new MySQLConnector();
        connection = sqlConnector.getConnection();
    }

    private void close() {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException se2) {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
