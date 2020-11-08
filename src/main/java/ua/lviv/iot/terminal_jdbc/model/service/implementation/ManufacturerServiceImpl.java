package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.ManufacturerDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.ManufacturerEntity;
import ua.lviv.iot.terminal_jdbc.model.service.ManufacturerService;

public class ManufacturerServiceImpl extends AbstractService<ManufacturerEntity, Integer>
    implements ManufacturerService {

  public ManufacturerServiceImpl() {
    super(new ManufacturerDataAccessImpl());
  }

}
