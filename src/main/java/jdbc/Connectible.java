package jdbc;

import java.sql.Connection;

public interface Connectible {
    Connection getConnection();
}
