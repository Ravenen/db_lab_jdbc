package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.SexController;
import ua.lviv.iot.terminal.model.entity.SexEntity;
import ua.lviv.iot.terminal.model.service.implementation.SexServiceImpl;

public class SexControllerImpl extends AbstractController<SexEntity, Integer> implements SexController {

  public SexControllerImpl() {
    super(new SexServiceImpl());
  }

}
