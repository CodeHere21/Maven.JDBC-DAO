package daos;

import java.sql.*;
import java.util.concurrent.DelayQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RUNNER {
    static String username = "Lena";
    static String password = "password";
    static String dbUrl = "jdbc:mysql://localhost:3306/jdbcdao";
    static Logger demoLog = Logger.getLogger("demoJDBC");

    //Get a connection to database, return Connection object
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection (dbUrl,username,password);
        } catch (SQLException ex) {
           throw new RuntimeException("Error connecting to the database",ex);
        }
    }
    //to test Connection
    public static void main(String[] args) throws SQLException {
        Connection connection =RUNNER.getConnection();
        DAOCLASS daoclass = new DAOCLASS();
       daoclass.findById(2);
    }


}