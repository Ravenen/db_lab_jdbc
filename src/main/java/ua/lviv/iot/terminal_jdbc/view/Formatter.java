package ua.lviv.iot.terminal_jdbc.view;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.terminal_jdbc.model.entity.EntityManager;

public class Formatter<T, K> {

  private EntityManager<T, K> entityManager;

  public Formatter(Class<T> clazz) {
    entityManager = new EntityManager<>(clazz);
  }

  public void formatTable(List<T> entities) {
    try {
      String format = "| ";
      int[] columnLengthes;

      columnLengthes = getColumnLengthes(entities);
      for (int i = 0; i < columnLengthes.length; i++) {
        format += "%-" + columnLengthes[i] + "s | ";
      }
      String[] columns = getColumnNames();
      String formattedNames = String.format(format, (Object[]) columns);
      String delimitter = formattedNames.replaceAll("[^|]", "-").replace("|", "+");
      delimitter = delimitter.substring(0, delimitter.length() - 1);

      System.out.println(delimitter);
      System.out.println(formattedNames);
      System.out.println(delimitter);
      for (T entity : entities) {
        System.out.format(format + "\n", (Object[]) propertiesToArray(entity));
      }
      System.out.println(delimitter);
    } catch (IllegalArgumentException | IllegalAccessException e) {
      System.out.println("[Error] Exeption while preparing to format data");
      System.out.println("[Error] Message: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void formatRow(T entity) {
    List<T> singleEntityList = new LinkedList<T>();
    singleEntityList.add(entity);
    formatTable(singleEntityList);
  }

  private String[] propertiesToArray(T entity) throws IllegalArgumentException, IllegalAccessException {
    Field[] fields = entityManager.getEntityFields();
    String[] properties = new String[fields.length];
    for (int i = 0; i < fields.length; i++) {
      fields[i].setAccessible(true);
      if (fields[i].get(entity) != null) {
        properties[i] = fields[i].get(entity).toString();
      } else {
        properties[i] = "-";
      }
    }
    return properties;
  }

  private String[] getColumnNames() {
    String[] fieldNames = entityManager.getColumnsNames().toArray(new String[0]);
    return fieldNames;
  }

  private int[] getColumnLengthes(List<T> entities) throws IllegalArgumentException, IllegalAccessException {
    Field[] fields = entityManager.getEntityFields();
    int[] lengthes = new int[fields.length];
    for (T entity : entities) {
      for (int i = 0; i < fields.length; i++) {
        fields[i].setAccessible(true);
        if (fields[i].get(entity) != null) {
          int fieldLength = fields[i].get(entity).toString().length();
          lengthes[i] = (lengthes[i] < fieldLength) ? fieldLength : lengthes[i];
        }
      }
    }
    for (int i = 0; i < fields.length; i++) {
      int fieldNameLength = fields[i].getName().length();
      lengthes[i] = (lengthes[i] < fieldNameLength) ? fieldNameLength : lengthes[i];
    }

    return lengthes;
  }
}
