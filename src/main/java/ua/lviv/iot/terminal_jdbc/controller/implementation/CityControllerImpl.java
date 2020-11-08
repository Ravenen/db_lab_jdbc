package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.CityController;
import ua.lviv.iot.terminal_jdbc.model.entity.CityEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.CityServiceImpl;

public class CityControllerImpl extends AbstractController<CityEntity, Integer> implements CityController {

  public CityControllerImpl() {
    super(new CityServiceImpl());
  }

}
