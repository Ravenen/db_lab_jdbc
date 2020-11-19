package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.CountryController;
import ua.lviv.iot.terminal.model.entity.CountryEntity;
import ua.lviv.iot.terminal.model.service.implementation.CountryServiceImpl;

public class CountryControllerImpl extends AbstractController<CountryEntity, Integer> implements CountryController {

  public CountryControllerImpl() {
    super(new CountryServiceImpl());
  }

}
