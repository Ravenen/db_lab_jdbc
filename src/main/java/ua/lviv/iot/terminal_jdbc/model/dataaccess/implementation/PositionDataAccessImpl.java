package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.PositionDataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.PositionEntity;

public class PositionDataAccessImpl extends AbstractDataAccess<PositionEntity, Integer> implements PositionDataAccess {

  public PositionDataAccessImpl() {
    super(PositionEntity.class);
  }

}
