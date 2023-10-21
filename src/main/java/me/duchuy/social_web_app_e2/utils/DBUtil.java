package me.duchuy.social_web_app_e2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DBUtil {
    
    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                String connectionDB = "jdbc:mysql://localhost:3306/articledb";
                String driverName = "com.mysql.cj.jdbc.Driver";
                String username = "root";
                String password = "duchuy2003";
                Class.forName(driverName);
                conn = DriverManager.getConnection(connectionDB, username, password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
