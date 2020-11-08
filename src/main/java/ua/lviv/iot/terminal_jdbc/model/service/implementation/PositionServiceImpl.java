package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.PositionDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.PositionEntity;
import ua.lviv.iot.terminal_jdbc.model.service.PositionService;

public class PositionServiceImpl extends AbstractService<PositionEntity, Integer> implements PositionService {

  public PositionServiceImpl() {
    super(new PositionDataAccessImpl());
  }

}
