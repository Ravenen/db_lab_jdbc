package ua.lviv.iot.terminal.model.dataaccess.implementation;

import ua.lviv.iot.terminal.model.dataaccess.PositionDataAccess;
import ua.lviv.iot.terminal.model.entity.PositionEntity;

public class PositionDataAccessImpl extends AbstractDataAccess<PositionEntity, Integer> implements PositionDataAccess {

  public PositionDataAccessImpl() {
    super(PositionEntity.class);
  }

}
