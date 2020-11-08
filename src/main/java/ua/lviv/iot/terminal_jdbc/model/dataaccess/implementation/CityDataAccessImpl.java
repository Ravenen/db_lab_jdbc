package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.CityDataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.CityEntity;

public class CityDataAccessImpl extends AbstractDataAccess<CityEntity, Integer> implements CityDataAccess {

  public CityDataAccessImpl() {
    super(CityEntity.class);
  }

}
