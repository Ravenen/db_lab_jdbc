package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.CountryDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.CountryEntity;
import ua.lviv.iot.terminal.model.service.CountryService;

public class CountryServiceImpl extends AbstractService<CountryEntity, Integer> implements CountryService {

  public CountryServiceImpl() {
    super(new CountryDataAccessImpl());
  }

}
