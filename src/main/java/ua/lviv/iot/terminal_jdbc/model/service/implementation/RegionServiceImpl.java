package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.RegionDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.RegionEntity;
import ua.lviv.iot.terminal_jdbc.model.service.RegionService;

public class RegionServiceImpl extends AbstractService<RegionEntity, Integer> implements RegionService {

  public RegionServiceImpl() {
    super(new RegionDataAccessImpl());
  }

}
