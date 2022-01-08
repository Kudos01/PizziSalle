package DAO;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;

public class DBConnection {
    private static DBConnection dbConnection = null;

    public Connection conn;

    private DBConnection() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("java");
        dataSource.setPassword("password");

        dataSource.setUrl("jdbc:mysql://localhost:3306/PizziSalle");

        dataSource.setServerName("PizziSalle");

        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance() {
        if (dbConnection == null)
            dbConnection = new DBConnection();
        return dbConnection;
    }
}
