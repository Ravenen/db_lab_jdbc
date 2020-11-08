package ua.lviv.iot.terminal_jdbc.model.manager;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.terminal_jdbc.model.annotation.Column;
import ua.lviv.iot.terminal_jdbc.model.annotation.InputIgnore;
import ua.lviv.iot.terminal_jdbc.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal_jdbc.model.annotation.Table;

public class EntityManager<T, K> {

  private Class<T> clazz;
  private Field[] fields;

  public EntityManager(Class<T> clazz) {
    this.clazz = clazz;
    this.fields = clazz.getDeclaredFields();
  }

  public Class<T> getEntityClass() {
    return clazz;
  }

  public Field[] getEntityFields() {
    return fields;
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
  public K getPrimaryKeyValue(T entity) throws IllegalArgumentException, IllegalAccessException {
    for (Field field : fields) {
      if (field.isAnnotationPresent(PrimaryKey.class)) {
        field.setAccessible(true);
        return (K) field.get(entity);
      }
    }
    return null;
  }

  public List<String> getColumnsNamesInputable() {
    List<String> columnsNames = new LinkedList<String>();
    List<Field> columns = getColumnsInputable();
    for (Field field : columns) {
      columnsNames.add(field.getAnnotation(Column.class).name());
    }
    return columnsNames;
  }

  public List<Field> getColumnsInputable() {
    List<Field> inputableColumns = new LinkedList<Field>();
    List<Field> columns = getColumns();
    for (Field field : columns) {
      if (!field.isAnnotationPresent(PrimaryKey.class) && !field.isAnnotationPresent(InputIgnore.class)) {
        inputableColumns.add(field);
      }
    }
    return inputableColumns;
  }

  public List<String> getColumnsNames() {
    List<String> columnsNames = new LinkedList<String>();
    List<Field> columns = getColumns();
    for (Field field : columns) {
      columnsNames.add(field.getAnnotation(Column.class).name());
    }
    return columnsNames;
  }

  public List<Field> getColumns() {
    List<Field> columns = new LinkedList<Field>();
    for (Field field : fields) {
      if (field.isAnnotationPresent(Column.class)) {
        columns.add(field);
      }
    }
    return columns;
  }

  public String generateColumnsNamesString() {
    List<String> columns = getColumnsNamesInputable();
    String columnsNamesString = String.join(",", columns);
    return columnsNamesString;
  }

  public String generateColumnsParametersString() {
    List<String> columns = getColumnsNamesInputable();
    columns.replaceAll(s -> s = "?");
    String columnsParameters = String.join(",", columns);
    return columnsParameters;
  }

  public String generateUpdateColumnsString() {
    List<String> columns = getColumnsNamesInputable();
    columns.replaceAll(s -> s += "=?");
    String updateColumnsString = String.join(",", columns);
    return updateColumnsString;
  }

  public T setFieldByName(T entity, String fieldName, Object fieldValue)
      throws IllegalArgumentException, IllegalAccessException {
    for (Field field : fields) {
      if (field.getName().equals(fieldName)) {
        field.setAccessible(true);
        field.set(entity, fieldValue);
        break;
      }
    }
    return entity;
  }

}
