package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.SexDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.SexEntity;
import ua.lviv.iot.terminal.model.service.SexService;

public class SexServiceImpl extends AbstractService<SexEntity, Integer> implements SexService {

  public SexServiceImpl() {
    super(new SexDataAccessImpl());
  }

}
