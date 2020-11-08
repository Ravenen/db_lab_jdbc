package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.PositionDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.PositionEntity;
import ua.lviv.iot.terminal.model.service.PositionService;

public class PositionServiceImpl extends AbstractService<PositionEntity, Integer> implements PositionService {

  public PositionServiceImpl() {
    super(new PositionDataAccessImpl());
  }

}
