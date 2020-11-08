package ua.lviv.iot.terminal.model.dataaccess.implementation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.terminal.model.annotation.Table;
import ua.lviv.iot.terminal.model.dataaccess.DataAccess;
import ua.lviv.iot.terminal.model.manager.EntityManager;
import ua.lviv.iot.terminal.model.persistant.ConnectionManager;
import ua.lviv.iot.terminal.model.transformer.Transformer;

public abstract class AbstractDataAccess<T, K> implements DataAccess<T, K> {

  private static final String FIND_ALL_FORMAT = "SELECT * FROM %s";
  private static final String FIND_BY_FORMAT = "SELECT * FROM %s WHERE %s=?";
  private static final String INSERT_FORMAT = "INSERT %s (%s) VALUES (%s)";
  private static final String UPDATE_FORMAT = "UPDATE %s SET %s WHERE %s=?";
  private static final String DELETE_FORMAT = "DELETE FROM %s WHERE %s=?";

  private static final String ERROR_EXEPTION_FORMAT = "[Error] Exeption while %s";
  private static final String ERROR_MESSAGE_FORMAT = "[Error] Message: %s";

  private Class<T> clazz;
  private Transformer<T, K> entityTranformer;
  private EntityManager<T, K> entityManager;

  public AbstractDataAccess(Class<T> clazz) {
    this.clazz = clazz;
    this.entityManager = new EntityManager<T, K>(clazz);
    this.entityTranformer = new Transformer<T, K>(clazz);
  }

  @Override
  public List<T> findAll() throws SQLException {

    List<T> entityList = new LinkedList<T>();

    if (clazz.isAnnotationPresent(Table.class)) {
      try {
        Connection connection = ConnectionManager.getConnection();
        String tableName = entityManager.getTableName();
        String sql = String.format(FIND_ALL_FORMAT, tableName);
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
          try (ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
              entityList.add(entityTranformer.fromResultSetToEntity(resultSet));
            }
          } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
              | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            System.out.println(String.format(ERROR_EXEPTION_FORMAT, "transforming data into objects"));
            System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
          }
        }
      } catch (IOException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "getting credentials to database"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }
    }

    return entityList;
  }

  @Override
  public T findById(K id) throws SQLException {

    String tableName = entityManager.getTableName();
    String primaryKeyName = entityManager.getPrimaryKeyName();
    List<T> entities = findByField(tableName, primaryKeyName, id);
    if (entities.size() > 0) {
      return entities.get(0);
    } else {
      return null;
    }
  }

  @Override
  public int create(T entity) throws SQLException {

    if (clazz.isAnnotationPresent(Table.class)) {

      try {

        String tableName = entityManager.getTableName();
        String columnsNamesString = entityManager.generateColumnsNamesString();
        String columnsParameters = entityManager.generateColumnsParametersString();

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(INSERT_FORMAT, tableName, columnsNamesString, columnsParameters);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
          entityTranformer.fillInColumnsInPreparedStatement(1, ps, entity);
          return ps.executeUpdate();
        } catch (IllegalArgumentException | IllegalAccessException e) {
          System.out.println(String.format(ERROR_EXEPTION_FORMAT, "preparing SQL query for INSERT"));
          System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        }
      } catch (IOException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "getting credentials to database"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }

    }
    return 0;
  }

  @Override
  public int update(T entity) throws SQLException {

    if (clazz.isAnnotationPresent(Table.class)) {

      try {

        String tableName = entityManager.getTableName();
        String updateColumnsString = entityManager.generateUpdateColumnsString();
        String primaryKeyName = entityManager.getPrimaryKeyName();
        K primaryKeyValue = entityManager.getPrimaryKeyValue(entity);

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(UPDATE_FORMAT, tableName, updateColumnsString, primaryKeyName);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
          int nextFreeIndex;
          nextFreeIndex = entityTranformer.fillInColumnsInPreparedStatement(1, ps, entity);
          boolean isValueSet = entityTranformer.setPreparedStatementWithType(nextFreeIndex, ps, primaryKeyValue);
          if (isValueSet == false) {
            return 0;
          }
          return ps.executeUpdate();
        }
      } catch (IllegalArgumentException | IllegalAccessException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "preparing SQL query for UPDATE"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      } catch (IOException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "getting credentials to database"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }

    }

    return 0;
  }

  @Override
  public int delete(K id) throws SQLException {

    if (clazz.isAnnotationPresent(Table.class)) {

      try {

        String tableName = entityManager.getTableName();
        String primaryKeyName = entityManager.getPrimaryKeyName();

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(DELETE_FORMAT, tableName, primaryKeyName);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
          boolean isValueSet = entityTranformer.setPreparedStatementWithType(1, ps, id);
          if (isValueSet == false) {
            return 0;
          }
          return ps.executeUpdate();
        }
      } catch (IOException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "getting credentials to database"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }

    }

    return 0;
  }

  protected List<T> findByInteger(String tableName, String fieldName, Integer fieldValue) throws SQLException {
    return findByField(tableName, fieldName, fieldValue);
  }

  private List<T> findByField(String tableName, String fieldName, Object fieldValue) throws SQLException {
    List<T> entityList = new LinkedList<T>();

    if (clazz.isAnnotationPresent(Table.class)) {
      try {
        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(FIND_BY_FORMAT, tableName, fieldName);
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

          boolean isValueSet = entityTranformer.setPreparedStatementWithType(1, ps, fieldValue);
          if (isValueSet == false) {
            return null;
          }

          try (ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
              entityList.add(entityTranformer.fromResultSetToEntity(resultSet));
            }
          } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
              | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            System.out.println(String.format(ERROR_EXEPTION_FORMAT, "transforming data into objects"));
            System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
          }
        }
      } catch (IOException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "getting credentials to database"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }
    }

    return entityList;
  }

}
