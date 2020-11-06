package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.CountryDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.CountryEntity;
import ua.lviv.iot.terminal_jdbc.model.service.CountryService;

public class CountryServiceImpl extends AbstractService<CountryEntity, Integer> implements CountryService {

  public CountryServiceImpl() {
    super(new CountryDataAccessImpl());
  }

}
