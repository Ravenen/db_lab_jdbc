package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.DataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.EntityManager;
import ua.lviv.iot.terminal_jdbc.model.service.Service;

public abstract class AbstractService<T, K> implements Service<T, K> {
  
  private DataAccess<T, K> dataAccess;
  
  public AbstractService(DataAccess<T, K> dataAccess) {
    this.dataAccess = dataAccess;
  }

  @Override
  public List<T> findAll() throws SQLException {
    return dataAccess.findAll();
  }

  @Override
  public T findById(K id) throws SQLException {
    return dataAccess.findById(id);
  }

  @Override
  public T create(T entity) throws SQLException {
    int newEntitiesCount = dataAccess.create(entity);
    T newEntity = null;
    if (newEntitiesCount > 0) {
      List<T> entities = findAll();
      newEntity = entities.get(entities.size() - 1);
    }
    return newEntity;
  }

  @Override
  public T update(K id, String fieldName, Object fieldValue) throws SQLException {
    T entity = findById(id); 
    T oldEntity = findById(id); 
    @SuppressWarnings("unchecked")
    EntityManager<T, K> manager = new EntityManager<T, K>((Class<T>) entity.getClass());
    try {
      entity = manager.setFieldByName(entity, fieldName, fieldValue);
      int updatedEntitiesCount = dataAccess.update(entity);
      if (updatedEntitiesCount > 0) {
        return oldEntity;
      }
    } catch (IllegalArgumentException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public T delete(K id) throws SQLException {
    T oldEntity = findById(id); 
    int deletedEntitiesCount = dataAccess.delete(id);
    if (deletedEntitiesCount > 0) {
      return oldEntity;
    }
    return null;
  }

}
