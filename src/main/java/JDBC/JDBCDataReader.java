package JDBC;

import java.sql.SQLException;

public class JDBCDataReader {

    private void crud() {
        try (CrudOperator crudOperator = new CrudOperator()) {
            crudOperator.read();
            String values1 = "1001,'Ann','Hurieva','ann@alevel.com','female','127.0.0.1'";
            String values2 = "1002,'Hanna','Hurieva','hanna@alevel.com','female','127.0.0.1'";
            String values3 = "1003,'Twins','Twise','2@alevel.com','male','127.0.0.1'";
            crudOperator.insertRecord(values1);
            crudOperator.insertRecord(values2);
            crudOperator.insertRecord(values3);
            crudOperator.updateRecord("Tsyguleva", 1001);
            crudOperator.deleteRecord(1003);
            crudOperator.updateIpByGender("8.8.8.8", "female");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error SQL !");
        }
    }

    public static void main(String[] args) {
        JDBCDataReader dataReader = new JDBCDataReader();
        dataReader.crud();
    }
}
