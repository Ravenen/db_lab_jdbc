package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.ManufacturerController;
import ua.lviv.iot.terminal_jdbc.model.entity.ManufacturerEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.ManufacturerServiceImpl;

public class ManufacturerControllerImpl extends AbstractController<ManufacturerEntity, Integer>
    implements ManufacturerController {

  public ManufacturerControllerImpl() {
    super(new ManufacturerServiceImpl());
  }

}
