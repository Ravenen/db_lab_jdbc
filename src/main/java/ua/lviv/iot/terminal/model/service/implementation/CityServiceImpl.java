package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.CityDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.CityEntity;
import ua.lviv.iot.terminal.model.service.CityService;

public class CityServiceImpl extends AbstractService<CityEntity, Integer> implements CityService {

  public CityServiceImpl() {
    super(new CityDataAccessImpl());
  }

}
