package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.PositionController;
import ua.lviv.iot.terminal.model.entity.PositionEntity;
import ua.lviv.iot.terminal.model.service.implementation.PositionServiceImpl;

public class PositionControllerImpl extends AbstractController<PositionEntity, Integer> implements PositionController {

  public PositionControllerImpl() {
    super(new PositionServiceImpl());
  }

}
