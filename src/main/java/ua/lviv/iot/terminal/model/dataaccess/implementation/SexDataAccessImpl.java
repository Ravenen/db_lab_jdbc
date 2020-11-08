package ua.lviv.iot.terminal.model.dataaccess.implementation;

import ua.lviv.iot.terminal.model.dataaccess.SexDataAccess;
import ua.lviv.iot.terminal.model.entity.SexEntity;

public class SexDataAccessImpl extends AbstractDataAccess<SexEntity, Integer> implements SexDataAccess {

  public SexDataAccessImpl() {
    super(SexEntity.class);
  }

}
