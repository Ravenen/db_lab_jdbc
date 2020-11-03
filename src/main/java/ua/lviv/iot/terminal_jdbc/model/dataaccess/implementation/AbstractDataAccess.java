package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.terminal_jdbc.model.annotation.Table;
import ua.lviv.iot.terminal_jdbc.model.dataaccess.DataAccess;
import ua.lviv.iot.terminal_jdbc.model.persistant.ConnectionManager;
import ua.lviv.iot.terminal_jdbc.transformer.Transformer;

abstract public class AbstractDataAccess<T, ID> implements DataAccess<T, ID> {

  private static final String FIND_ALL_FORMAT = "SELECT * FROM %s";
  private static final String FIND_BY_ID_FORMAT = "SELECT * FROM %s WHERE %s=?";
  private static final String INSERT_FORMAT = "INSERT %s (%s) VALUES (%s)";
  private static final String UPDATE_FORMAT = "UPDATE %s SET %s WHERE %s=?";
  private static final String DELETE_FORMAT = "DELETE FROM %s WHERE %s=?";

  private Class<T> clazz;
  private Transformer<T, ID> entityTranformer;

  public AbstractDataAccess(Class<T> clazz) {
    this.clazz = clazz;
    this.entityTranformer = new Transformer<T, ID>(clazz);
  }

  @Override
  public List<T> findAll() throws SQLException {

    List<T> entityList = new LinkedList<T>();

    if (clazz.isAnnotationPresent(Table.class)) {
      Connection connection = ConnectionManager.getConnection();
      String tableName = entityTranformer.getTableName();
      String sql = String.format(FIND_ALL_FORMAT, tableName);
      try (PreparedStatement ps = connection.prepareStatement(sql)) {
        try (ResultSet resultSet = ps.executeQuery()) {
          while (resultSet.next()) {
            try {
              entityList.add(entityTranformer.fromResultSetToEntity(resultSet));
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }

    return entityList;
  }

  @Override
  public T findById(ID id) throws SQLException {

    T entity = null;

    if (clazz.isAnnotationPresent(Table.class)) {
      String tableName = entityTranformer.getTableName();
      String primaryKeyName = entityTranformer.getPrimaryKeyName();

      Connection connection = ConnectionManager.getConnection();
      String sql = String.format(FIND_BY_ID_FORMAT, tableName, primaryKeyName);
      try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, (Integer) id);
        try (ResultSet resultSet = ps.executeQuery()) {
          while (resultSet.next()) {
            try {
              entity = entityTranformer.fromResultSetToEntity(resultSet);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }

    return entity;
  }

  @Override
  public int create(T entity) throws SQLException {

    try {
      if (clazz.isAnnotationPresent(Table.class)) {

        String tableName = entityTranformer.getTableName();
        String columnsNamesString = entityTranformer.generateColumnsNamesString();
        String columnsParameters = entityTranformer.generateColumnsParametersString();

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(INSERT_FORMAT, tableName, columnsNamesString, columnsParameters);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
          entityTranformer.fillInColumnsInPreparedStatement(1, ps, entity);
          return ps.executeUpdate();
        }

      }
    } catch (IllegalArgumentException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public int update(T entity) throws SQLException {

    try {
      if (clazz.isAnnotationPresent(Table.class)) {

        String tableName = entityTranformer.getTableName();
        String updateColumnsString = entityTranformer.generateUpdateColumnsString();
        String primaryKeyName = entityTranformer.getPrimaryKeyName();
        ID primaryKeyValue = entityTranformer.getPrimaryKeyValue(entity);

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(UPDATE_FORMAT, tableName, updateColumnsString, primaryKeyName);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
          int nextFreeIndex = entityTranformer.fillInColumnsInPreparedStatement(1, ps, entity);
          ps.setInt(nextFreeIndex, (Integer) primaryKeyValue);
          return ps.executeUpdate();
        }

      }
    } catch (IllegalArgumentException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public int delete(ID id) throws SQLException {

    try {
      if (clazz.isAnnotationPresent(Table.class)) {

        String tableName = entityTranformer.getTableName();
        String primaryKeyName = entityTranformer.getPrimaryKeyName();

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(DELETE_FORMAT, tableName, primaryKeyName);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
          ps.setInt(1, (Integer) id);
          return ps.executeUpdate();
        }

      }
    } catch (IllegalArgumentException | SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

}
