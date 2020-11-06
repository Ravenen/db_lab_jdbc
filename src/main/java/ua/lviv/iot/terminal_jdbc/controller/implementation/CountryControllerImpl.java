package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.CountryController;
import ua.lviv.iot.terminal_jdbc.model.entity.CountryEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.CountryServiceImpl;

public class CountryControllerImpl extends AbstractController<CountryEntity, Integer> implements CountryController {

  public CountryControllerImpl() {
    super(new CountryServiceImpl());
  }

}
