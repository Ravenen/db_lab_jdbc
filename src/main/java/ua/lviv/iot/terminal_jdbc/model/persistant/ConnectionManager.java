package ua.lviv.iot.terminal_jdbc.model.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
  private static final String url = "";
  private static final String user = "";
  private static final String password = "";
  
  private static Connection connection = null;
  
  private ConnectionManager() { 
  }
  
  public static Connection getConnection() {
    if (connection == null) {
        try {
          connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
          System.out.println("SQLException: " + e.getMessage());
          System.out.println("SQLState: " + e.getSQLState());
          System.out.println("VendorError: " + e.getErrorCode());
        }
    }
    return connection;
  }

}
