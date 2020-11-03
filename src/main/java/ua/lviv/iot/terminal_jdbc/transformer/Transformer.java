package ua.lviv.iot.terminal_jdbc.transformer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.terminal_jdbc.model.annotation.Column;
import ua.lviv.iot.terminal_jdbc.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal_jdbc.model.annotation.Table;

public class Transformer<T, ID> {

  private Class<T> clazz;
  private Field[] fields;

  public Transformer(Class<T> clazz) {
    this.clazz = clazz;
    this.fields = clazz.getDeclaredFields();
  }

  public T fromResultSetToEntity(ResultSet resultSet) throws InstantiationException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
    T entity = null;
    entity = clazz.getConstructor().newInstance();
    for (Field field : fields) {
      if (field.isAnnotationPresent(Column.class)) {
        Column column = field.getAnnotation(Column.class);
        String name = column.name();
        field.setAccessible(true);
        Class<?> fieldType = field.getType();
        if (fieldType == String.class) {
          field.set(entity, resultSet.getString(name));
        } else if (fieldType == Integer.class) {
          field.set(entity, resultSet.getInt(name));
        } else if (fieldType == Date.class) {
          field.set(entity, resultSet.getDate(name));
        }
      }
    }
    return entity;
  }

  public String generateColumnsNamesString() {
    List<String> columns = getColumnsNames();
    String columnsNamesString = String.join(",", columns);
    return columnsNamesString;
  }

  public String generateColumnsParametersString() {
    List<String> columns = getColumnsNames();
    columns.replaceAll(s -> s = "?");
    String columnsParameters = String.join(",", columns);
    return columnsParameters;
  }

  public String generateUpdateColumnsString() {
    List<String> columns = getColumnsNames();
    columns.replaceAll(s -> s += "=?");
    String updateColumnsString = String.join(",", columns);
    return updateColumnsString;
  }

  public String getTableName() {
    Table table = clazz.getAnnotation(Table.class);
    String tableName = table.name();
    return tableName;
  }

  public String getPrimaryKeyName() {
    for (Field field : fields) {
      if (field.isAnnotationPresent(PrimaryKey.class)) {
        return field.getAnnotation(Column.class).name();
      }
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  public ID getPrimaryKeyValue(T entity) throws IllegalArgumentException, IllegalAccessException {
    for (Field field : fields) {
      if (field.isAnnotationPresent(PrimaryKey.class)) {
        field.setAccessible(true);
        return (ID) field.get(entity);
      }
    }
    return null;
  }

  public int fillInColumnsInPreparedStatement(int startFromIndex, PreparedStatement ps, T entity)
      throws IllegalArgumentException, IllegalAccessException, SQLException {
    int index = startFromIndex;
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
    int nextFreeIndex = index;
    return nextFreeIndex;
  }

  private List<String> getColumnsNames() {
    List<String> columnsNames = new LinkedList<String>();
    for (Field field : fields) {
      if (field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(PrimaryKey.class)) {
        columnsNames.add(field.getAnnotation(Column.class).name());
      }
    }
    return columnsNames;
  }
}
