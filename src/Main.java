
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//import java.sql.*;

import java.sql.*;
import javax.sql.*;
import javax.ejb.*;
import javax.naming.*;

import javax.sql.DataSource;
import javax.xml.transform.Result;

public class Main {
    /*  Design patters planned:
        Singleton for DB connection
        Builder for pizzas
        ??Facade for hiding the pizza building complexity??
        Facade in the singleton because we hide the complexity of accessing the DB
        Builder for the orders
        DAO patterns for the DB
     */

    /*
    DB Tables:
    Pizzas
    Orders
    Customers
     */

    public static Connection conn = null;

    public static boolean connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.ConnectionGroup");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/PizziSalle",
                    "java", "password");
            if (conn != null) {
                System.out.println("Connection failed");
            }
            return true;
        } catch(SQLException ex) {
            System.out.println("Problems SQL ex");
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("java");
        dataSource.setPassword("password");

        dataSource.setUrl("jdbc:mysql://localhost:3306/PizziSalle");

        dataSource.setServerName("PizziSalle");

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM pizzas");

        rs.next();
        System.out.println(rs.getString("pizza_name"));


        rs.close();
        stmt.close();
        conn.close();
    }

}
