package edu.cursor.u21.dao.jdbcConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Kermit The Frog on 02.03.2017.
 */
public class JDBCConnector {
    private static Connection connection;

    public JDBCConnector() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    }

    public Connection getConnection(String URL, String user, String password) throws SQLException {
        if (connection != null) {
            return connection;
        }
        return DriverManager.getConnection(URL, user, password);
    }
}