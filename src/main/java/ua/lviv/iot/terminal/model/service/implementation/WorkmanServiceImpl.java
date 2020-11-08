package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.WorkmanDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.WorkmanEntity;
import ua.lviv.iot.terminal.model.service.WorkmanService;

public class WorkmanServiceImpl extends AbstractService<WorkmanEntity, Integer> implements WorkmanService {

  public WorkmanServiceImpl() {
    super(new WorkmanDataAccessImpl());
  }

}
