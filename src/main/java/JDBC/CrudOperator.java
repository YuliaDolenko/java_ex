package JDBC;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static JDBC.JDBCDataReader.PASS;
import static JDBC.JDBCDataReader.USER;

public class CrudOperator {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Testtt?serverTimezone=UTC";


        Connection conn = null;
        Statement stmt = null;

        public CrudOperator() throws SQLException {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }




}
