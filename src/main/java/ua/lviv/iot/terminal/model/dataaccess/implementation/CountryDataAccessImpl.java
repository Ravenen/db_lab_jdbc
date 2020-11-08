package ua.lviv.iot.terminal.model.dataaccess.implementation;

import ua.lviv.iot.terminal.model.dataaccess.CountryDataAccess;
import ua.lviv.iot.terminal.model.entity.CountryEntity;

public class CountryDataAccessImpl extends AbstractDataAccess<CountryEntity, Integer> implements CountryDataAccess {

  public CountryDataAccessImpl() {
    super(CountryEntity.class);
  }

}
