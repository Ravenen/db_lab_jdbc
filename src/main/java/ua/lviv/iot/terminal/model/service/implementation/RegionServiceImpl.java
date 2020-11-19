package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.RegionDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.RegionEntity;
import ua.lviv.iot.terminal.model.service.RegionService;

public class RegionServiceImpl extends AbstractService<RegionEntity, Integer> implements RegionService {

  public RegionServiceImpl() {
    super(new RegionDataAccessImpl());
  }

}
