package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.CountryDataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.CountryEntity;

public class CountryDataAceessImpl extends AbstractDataAccess<CountryEntity, Integer> implements CountryDataAccess {

  public CountryDataAceessImpl() {
    super(CountryEntity.class);
  }

  @Override
  public List<CountryEntity> findAll() throws SQLException {
    return super.findAll();
  }

  @Override
  public CountryEntity findById(Integer id) throws SQLException {
    return super.findById(id);
  }

  @Override
  public int create(CountryEntity entity) throws SQLException {
    return super.create(entity);
  }

  @Override
  public int update(CountryEntity entity) throws SQLException {
    return super.update(entity);
  }

  @Override
  public int delete(Integer id) throws SQLException {
    return super.delete(id);
  }

}
