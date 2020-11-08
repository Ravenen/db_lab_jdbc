package ua.lviv.iot.terminal_jdbc.model.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
  private static final String DB_URL = "jdbc:mysql://localhost:3306/pavliyk_3?useUnicode=true&serverTimezone=UTC";
  private static final String DB_USERNAME = "lidl";
  private static final String DB_PASSWORD = "CoolPassword233";

  private static Connection connection = null;

  private ConnectionManager() {
  }

  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
    return connection;
  }

}
