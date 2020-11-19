package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.ManufacturerController;
import ua.lviv.iot.terminal.model.entity.ManufacturerEntity;
import ua.lviv.iot.terminal.model.service.implementation.ManufacturerServiceImpl;

public class ManufacturerControllerImpl extends AbstractController<ManufacturerEntity, Integer>
    implements ManufacturerController {

  public ManufacturerControllerImpl() {
    super(new ManufacturerServiceImpl());
  }

}
