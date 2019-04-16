package jdbc.mysqlUtilities;

import jdbc.Connectible;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector implements Connectible {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Testtt?serverTimezone=UTC&useSSL=false";

    private static final String USER = "root";

    private static final String PASS = "111";

    private Connection connection;

    @Override
    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}