package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.ManufacturerDataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.ManufacturerEntity;

public class ManufacturerDataAccessImpl extends AbstractDataAccess<ManufacturerEntity, Integer>
    implements ManufacturerDataAccess {

  public ManufacturerDataAccessImpl() {
    super(ManufacturerEntity.class);
  }

}
