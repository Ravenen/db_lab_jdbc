package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.WorkmanController;
import ua.lviv.iot.terminal_jdbc.model.entity.WorkmanEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.WorkmanServiceImpl;

public class WorkmanControllerImpl extends AbstractController<WorkmanEntity, Integer> implements WorkmanController {

  public WorkmanControllerImpl() {
    super(new WorkmanServiceImpl());
  }

}
