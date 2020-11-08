package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.SexController;
import ua.lviv.iot.terminal_jdbc.model.entity.SexEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.SexServiceImpl;

public class SexControllerImpl extends AbstractController<SexEntity, Integer> implements SexController {

  public SexControllerImpl() {
    super(new SexServiceImpl());
  }

}
