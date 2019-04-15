package JDBC;

import java.sql.*;

public class JDBCDataReader {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Testtt?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "1234";


    public static void main(String[] args) {
//        selectRecord();
//        insertRecord();
//        updateRecord();
//        deleteRecord();
    }

    public static void selectRecord() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM mock_data";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("last_name");
                String gender = rs.getString("gender");
                String ip_address = rs.getString("ip_address");

                System.out.print("ID: " + ID);
                System.out.println(", First_name: " + first_name);
                System.out.println(", Last_name: " + last_name);
                System.out.println(", Email: " + email);
                System.out.println(", Gender: " + gender);
                System.out.println(", Ip_address: " + ip_address);
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    public static void insertRecord() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO mock_data VALUES (1001, 'Alex', 'sss', 'asdas@sdafa.sa', 'F', 'aaa');";
            stmt.execute(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void updateRecord() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "UPDATE mock_data SET ID = '1002' WHERE ID = '1001';";
            stmt.execute(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void deleteRecord() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "DELETE FROM mock_data WHERE ID = 1002;";
            stmt.execute(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}


