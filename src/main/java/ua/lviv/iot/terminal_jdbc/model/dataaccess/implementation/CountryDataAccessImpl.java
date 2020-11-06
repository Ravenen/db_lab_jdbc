package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.CountryDataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.CountryEntity;

public class CountryDataAccessImpl extends AbstractDataAccess<CountryEntity, Integer> implements CountryDataAccess {

  public CountryDataAccessImpl() {
    super(CountryEntity.class);
  }

}
