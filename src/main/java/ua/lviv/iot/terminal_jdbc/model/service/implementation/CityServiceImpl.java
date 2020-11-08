package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.CityDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.CityEntity;
import ua.lviv.iot.terminal_jdbc.model.service.CityService;

public class CityServiceImpl extends AbstractService<CityEntity, Integer> implements CityService {

  public CityServiceImpl() {
    super(new CityDataAccessImpl());
  }

}
