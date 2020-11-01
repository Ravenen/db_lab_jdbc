package ua.lviv.iot.terminal_jdbc.model.DAO.implementation;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import ua.lviv.iot.terminal_jdbc.model.DAO.GeneralDAO;
import ua.lviv.iot.terminal_jdbc.model.annotation.Column;
import ua.lviv.iot.terminal_jdbc.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal_jdbc.model.annotation.Table;
import ua.lviv.iot.terminal_jdbc.model.persistant.ConnectionManager;

public class GeneralDAOImpl<T, ID> implements GeneralDAO<T, ID> {

  private static final String INSERT = "INSERT %s (%s) VALUES (%s)";
  private static final String UPDATE = "UPDATE %s SET %s WHERE %s=?";

  @Override
  public List<T> findAll() throws SQLException {

    return null;
  }

  @Override
  public T findById(ID id) throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int create(T entity) throws SQLException {

    @SuppressWarnings("unchecked")
    Class<T> clazz = (Class<T>) entity.getClass();

    try {
      if (clazz.isAnnotationPresent(Table.class)) {

        Field[] fields = clazz.getDeclaredFields();
        List<String> columnsNames = extractColumnsNamesFromFields(fields);

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.name();
        String columnsNamesString = generateColumnsNamesString(columnsNames);
        String columnsParameters = generateColumnsParameters(columnsNames);

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(INSERT, tableName, columnsNamesString, columnsParameters);
        PreparedStatement ps = connection.prepareStatement(sql);

        int index = 1;
        for (Field field : fields) {
          if (field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(PrimaryKey.class)) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            if (fieldType == String.class) {
              ps.setString(index, (String) field.get(entity));
              index++;
            } else if (fieldType == Integer.class) {
              ps.setInt(index, (Integer) field.get(entity));
              index++;
            } else if (fieldType == Date.class) {
              ps.setDate(index, (Date) field.get(entity));
              index++;
            }
          }
        }
        return ps.executeUpdate();
      }
    } catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public int update(T entity) throws SQLException {

    @SuppressWarnings("unchecked")
    Class<T> clazz = (Class<T>) entity.getClass();

    try {
      if (clazz.isAnnotationPresent(Table.class)) {

        Field[] fields = clazz.getDeclaredFields();
        List<String> columnsNames = extractColumnsNamesFromFields(fields);

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.name();
        String updateColumnsString = generateUpdateColumnsString(columnsNames);
        String primaryKeyName = extractPrimaryKeyNameFromFields(fields);
        ID primaryKeyValue = extractPrimaryKeyValueFromFields(fields, entity);

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(UPDATE, tableName, updateColumnsString, primaryKeyName);
        PreparedStatement ps = connection.prepareStatement(sql);

        int index = 1;
        for (Field field : fields) {
          if (field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(PrimaryKey.class)) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            if (fieldType == String.class) {
              ps.setString(index, (String) field.get(entity));
              index++;
            } else if (fieldType == Integer.class) {
              ps.setInt(index, (Integer) field.get(entity));
              index++;
            } else if (fieldType == Date.class) {
              ps.setDate(index, (Date) field.get(entity));
              index++;
            }
          }
        ps.setInt(index, (Integer) field.get(entity));
        }
        return ps.executeUpdate();
      }
    } catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public int delete(ID id) throws SQLException {
    // TODO Auto-generated method stub
    return 0;
  }

  private String generateColumnsNamesString(List<String> columns) {
    String columnsNamesString = null;
    for (String column : columns) {
      if (columnsNamesString == null) {
        columnsNamesString = column;
      } else {
        columnsNamesString += ", " + column;
      }
    }
    return columnsNamesString;
  }
  
  private String generateUpdateColumnsString(List<String> columns) {
    String updateColumnsString = null;
    for (String column : columns) {
      if (updateColumnsString == null) {
        updateColumnsString = column + "=?";
      } else {
        updateColumnsString += ", " + column + "=?";
      }
    }
    return updateColumnsString;
  }

  private String generateColumnsParameters(List<String> columns) {
    String columnsParameters = null;
    for (int i = 0; i < columns.size(); i++) {
      if (columnsParameters == null) {
        columnsParameters = "?";
      } else {
        columnsParameters += ", ?";
      }
    }
    return columnsParameters;
  }
  
  private List<String> extractColumnsNamesFromFields(Field[] fields) {
    List<String> columnsNames = new LinkedList<String>();
    for (Field field : fields) {
      if (field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(PrimaryKey.class)) {
        columnsNames.add(field.getAnnotation(Column.class).name());
      }
    }
    return columnsNames;
  }
  
  private String extractPrimaryKeyNameFromFields(Field[] fields) throws IllegalArgumentException, IllegalAccessException {
    for (Field field : fields) {
      if (field.isAnnotationPresent(PrimaryKey.class)) {
        return field.getAnnotation(Column.class).name();
      }
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  private ID extractPrimaryKeyValueFromFields(Field[] fields, T entity) throws IllegalArgumentException, IllegalAccessException {
    for (Field field : fields) {
      if (field.isAnnotationPresent(PrimaryKey.class)) {
        field.setAccessible(true);
        return (ID) field.get(entity);
      }
    }
    return null;
  }

}
