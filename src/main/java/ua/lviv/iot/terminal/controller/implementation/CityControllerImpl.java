package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.CityController;
import ua.lviv.iot.terminal.model.entity.CityEntity;
import ua.lviv.iot.terminal.model.service.implementation.CityServiceImpl;

public class CityControllerImpl extends AbstractController<CityEntity, Integer> implements CityController {

  public CityControllerImpl() {
    super(new CityServiceImpl());
  }

}
