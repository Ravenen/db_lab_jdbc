package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.RegionDataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.RegionEntity;

public class RegionDataAccessImpl extends AbstractDataAccess<RegionEntity, Integer> implements RegionDataAccess {

  public RegionDataAccessImpl() {
    super(RegionEntity.class);
  }

}
