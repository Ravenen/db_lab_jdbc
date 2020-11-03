package ua.lviv.iot.terminal_jdbc;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.CountryDataAccess;
import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.CountryDataAceessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.CountryEntity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      CountryDataAccess data = new CountryDataAceessImpl();
      List<CountryEntity> counties;
      try {
        counties = data.findAll();
        System.out.println(counties);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
}
