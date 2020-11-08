package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.PositionController;
import ua.lviv.iot.terminal_jdbc.model.entity.PositionEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.PositionServiceImpl;

public class PositionControllerImpl extends AbstractController<PositionEntity, Integer> implements PositionController {

  public PositionControllerImpl() {
    super(new PositionServiceImpl());
  }

}
