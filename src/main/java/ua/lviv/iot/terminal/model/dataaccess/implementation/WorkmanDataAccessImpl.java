package ua.lviv.iot.terminal.model.dataaccess.implementation;

import ua.lviv.iot.terminal.model.dataaccess.WorkmanDataAccess;
import ua.lviv.iot.terminal.model.entity.WorkmanEntity;

public class WorkmanDataAccessImpl extends AbstractDataAccess<WorkmanEntity, Integer> implements WorkmanDataAccess {

  public WorkmanDataAccessImpl() {
    super(WorkmanEntity.class);
  }

}
