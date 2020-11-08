package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.WorkmanController;
import ua.lviv.iot.terminal.model.entity.WorkmanEntity;
import ua.lviv.iot.terminal.model.service.implementation.WorkmanServiceImpl;

public class WorkmanControllerImpl extends AbstractController<WorkmanEntity, Integer> implements WorkmanController {

  public WorkmanControllerImpl() {
    super(new WorkmanServiceImpl());
  }

}
