package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.WorkmanDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.WorkmanEntity;
import ua.lviv.iot.terminal_jdbc.model.service.WorkmanService;

public class WorkmanServiceImpl extends AbstractService<WorkmanEntity, Integer> implements WorkmanService {

  public WorkmanServiceImpl() {
    super(new WorkmanDataAccessImpl());
  }

}
