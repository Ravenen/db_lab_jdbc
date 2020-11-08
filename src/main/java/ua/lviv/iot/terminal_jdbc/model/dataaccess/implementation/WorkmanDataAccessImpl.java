package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.WorkmanDataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.WorkmanEntity;

public class WorkmanDataAccessImpl extends AbstractDataAccess<WorkmanEntity, Integer> implements WorkmanDataAccess {

  public WorkmanDataAccessImpl() {
    super(WorkmanEntity.class);
  }

}
