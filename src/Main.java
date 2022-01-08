
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
        Facade in the singleton and DAOs because we hide the complexity of accessing the DB
        Builder for the orders
        DAO patterns for the DB
     */

    /*
    DB Tables:
    Pizzas
    Orders
    Customers
     */

    public static void main(String[] args) throws SQLException {

    }

}
