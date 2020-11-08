package ua.lviv.iot.terminal.model.persistant;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

  private static Connection connection = null;

  private ConnectionManager() {
  }

  public static Connection getConnection() throws SQLException, IOException {
    if (connection == null) {
      try (InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties")) {

        Properties prop = new Properties();
        prop.load(input);
        connection = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.username"),
            prop.getProperty("db.password"));
      }
    }
    return connection;
  }

}
