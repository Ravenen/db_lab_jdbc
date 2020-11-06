package ua.lviv.iot.terminal_jdbc;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dnl.utils.text.table.TextTable;
import ua.lviv.iot.terminal_jdbc.model.entity.CountryEntity;
import ua.lviv.iot.terminal_jdbc.model.service.CountryService;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.CountryServiceImpl;
import ua.lviv.iot.terminal_jdbc.view.View;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) throws SQLException {
    
   
    View view = new View();
    view.show();
    
//    List<String> columnNames = new LinkedList<String>();
//    columnNames.add("id");
//    columnNames.add("name");
//    columnNames.add("address");
//    String[] columns = columnNames.toArray(new String[0]);
    
//    String[] test = {"id", "name", "address"};
    
    
//    CountryService countryService = new CountryServiceImpl();
//    List<CountryEntity> counties;
//    try {
//      counties = countryService.findAll();
//      System.out.println(counties);
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
    
//    Object[] dataObjects = counties.toArray();
//    Object[][] 
    
//    Object[][] data = {
//        {1, "Walter", "London"},
//        {2, "Santiago", "Los Angeles"},
//        {3, "Vasyl", "Los Pylesos"},
//    };
//    
//    TextTable tt = new TextTable(columns, data);
//    tt.printTable();
    
//    String format = "| %-7s | %-7s |";
//    String test = String.format(format, "hello", "world");
//    System.out.println(test);
////    String test1 = test.replace("|", "+");
//    String test1 = test.replaceAll("[^|]", "-");
//    String test2 = test1.replace("|", "+");
//    System.out.println(test2);
    
//    Map<String, Tastable> menu = new LinkedHashMap<String, Tastable>();
//    Test test = new Test();
//    menu.put("1", test::hello);
    
//    CountryService countryService = new CountryServiceImpl();
//    List<CountryEntity> counties;
//    try {
//      counties = countryService.findAll();
//      System.out.println(counties);
//      CountryEntity country = countryService.findById(1);
//      System.out.println(country);
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//      Class test = Integer.class;
//      Object obj = test.cast(2);
//      System.out.println(obj.getClass());

    
    
//    try {
//      counties = countryService.findAll();
//      System.out.println(counties);
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }

//    System.out.format("%-9s | %-9s\n", "Hello", "World");
//    System.out.format("%-9s | %-9s\n", "Hellowww", "Worwrld");
//    System.out.format("%-9s | %-9s\n", "Hwegello", "World");
//    System.out.format("%-9s | %-9s\n", "Hello", "Worweggld");
//    System.out.format("%-9s | %-9s\n", "Hewewllo", "World");
  }
  
  public static void testFormat() throws SQLException {
    CountryService countryService = new CountryServiceImpl();
    List<CountryEntity> counties = new LinkedList<CountryEntity>();
    counties = countryService.findAll();
    Field[] fields = counties.get(0).getClass().getDeclaredFields();
    int[] lengthes = new int[fields.length];
    for (CountryEntity countryEntity : counties) {
      for (int i = 0; i < fields.length; i++) {
        try {
          fields[i].setAccessible(true);
          Integer fieldLength = fields[i].get(countryEntity).toString().length();
          lengthes[i] = (lengthes[i] < fieldLength) ? fieldLength : lengthes[i];
        } catch (IllegalArgumentException | IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
    String format = "| ";
    for (int i = 0; i < fields.length; i++) {
      try {
        Integer fieldNameLength = fields[i].getName().length();
        lengthes[i] = (lengthes[i] < fieldNameLength) ? fieldNameLength : lengthes[i];
        format += "%-" + (lengthes[i]+2) + "s | ";
      } catch (IllegalArgumentException e) {
      }
    }
    format += "\n";
    
    String[] names = new String[fields.length];
    for (int i = 0; i < fields.length; i++) {
      try {
        names[i] = fields[i].getName();
      } catch (IllegalArgumentException e) {
      }
    }
    System.out.format(format, (Object[]) names);
    for (CountryEntity countryEntity : counties) {
      System.out.format(format, countryEntity.getId(), countryEntity.getName());
    }
  }
}
