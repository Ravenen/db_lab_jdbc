package ua.lviv.iot.terminal_jdbc.model.transformer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.lviv.iot.terminal_jdbc.model.annotation.Column;
import ua.lviv.iot.terminal_jdbc.model.annotation.PrimaryKey;
import ua.lviv.iot.terminal_jdbc.model.entity.EntityManager;

public class Transformer<T, K> {
  
  private EntityManager<T, K> entityManager;

  public Transformer(Class<T> clazz) {
    this.entityManager = new EntityManager<T, K>(clazz);
  }

  public T fromResultSetToEntity(ResultSet resultSet) throws InstantiationException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
    T entity = null;
    entity = entityManager.getEntityClass().getConstructor().newInstance();
    for (Field field : entityManager.getEntityFields()) {
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

  public int fillInColumnsInPreparedStatement(int startFromIndex, PreparedStatement ps, T entity)
      throws IllegalArgumentException, IllegalAccessException, SQLException {
    int index = startFromIndex;
    for (Field field : entityManager.getEntityFields()) {
      if (field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(PrimaryKey.class)) {
        field.setAccessible(true);
        setPreparedStatementWithType(index, ps, field.get(entity));
        index++;
      }
    }
    int nextFreeIndex = index;
    return nextFreeIndex;
  }

  public boolean setPreparedStatementWithType(int index, PreparedStatement ps, Object value) throws SQLException {
    Class<?> fieldType = value.getClass();
    if (fieldType == Integer.class) {
      ps.setInt(index, (Integer) value);
    } else if (fieldType == String.class) {
      ps.setString(index, (String) value);
    } else if (fieldType == Date.class) {
      ps.setDate(index, (Date) value);
    } else {
      return false;
    }
    return true;
  }
  
}
