package JDBC;

import java.io.Closeable;
import java.sql.*;

public class CrudOperator implements Closeable {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/testmock?serverTimezone=UTC&useSSL=false";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "password";

    Connection connection = null;

    public CrudOperator() throws SQLException {
        try {
            if (connection == null)
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection to Testmock DB succesfull!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public void read() throws SQLException {
        reopenConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM mock_data";
        ResultSet rs = statement.executeQuery(sql);
        // Extract data from result set
        while (rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("id");
            String first = rs.getString("first_name");
            String last = rs.getString("last_name");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String ip = rs.getString("ip_address");

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", First_name: " + first);
            System.out.println(", Last_name: " + last);
            System.out.println(", email: " + email);
            System.out.println(", gender: " + gender);
            System.out.println(", ip: " + ip);
        }
        rs.close();
        statement.close();
    }

    public void insertRecord(String values) throws SQLException {
        String sql = "INSERT INTO  mock_data VALUES(" + values + ")";
        executeSqlStatement(sql, "Inserted values to Table MOCK_DATA");
    }

    public void updateRecord(String last_name, int id) throws SQLException {
        String sql = "UPDATE mock_data SET last_name = '" + last_name + "' WHERE ID = " + id;
        executeSqlStatement(sql, "Changed last_name for entries with ID  = " + id);
    }

    public void updateIpByGender(String ip_address, String gender) throws SQLException {
        String sql = "UPDATE mock_data SET ip_address = '" + ip_address + "' WHERE gender = '" + gender + "'";
        executeSqlStatement(sql, "Changed ip-addresses to " + ip_address + " for all " + gender + " users");
    }

    public void deleteRecord(int id) throws SQLException {
        String sql = "DELETE FROM mock_data WHERE ID = " + id;
        executeSqlStatement(sql, "Deleted data for entries with ID  = " + id);
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing SQL connections!");
        }
    }

    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        }
    }

    void executeSqlStatement(String sql, String description) throws SQLException {
        reopenConnection(); //reopen (if it is inactive) connection to the DBMS
        Statement statement = connection.createStatement();  // Create statement to execute sql commands
        statement.execute(sql); // Execute statement - sql command
        statement.close();      // Close statement to commit changes to the DBMS.
        if (description != null)
            System.out.println(description);
    }

    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }

}