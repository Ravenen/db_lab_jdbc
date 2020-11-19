package ua.lviv.iot.terminal.model.dataaccess.implementation;

import ua.lviv.iot.terminal.model.dataaccess.ManufacturerDataAccess;
import ua.lviv.iot.terminal.model.entity.ManufacturerEntity;

public class ManufacturerDataAccessImpl extends AbstractDataAccess<ManufacturerEntity, Integer>
    implements ManufacturerDataAccess {

  public ManufacturerDataAccessImpl() {
    super(ManufacturerEntity.class);
  }

}
