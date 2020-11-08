package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.SexDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.SexEntity;
import ua.lviv.iot.terminal_jdbc.model.service.SexService;

public class SexServiceImpl extends AbstractService<SexEntity, Integer> implements SexService {

  public SexServiceImpl() {
    super(new SexDataAccessImpl());
  }

}
