package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.ManufacturerDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.ManufacturerEntity;
import ua.lviv.iot.terminal.model.service.ManufacturerService;

public class ManufacturerServiceImpl extends AbstractService<ManufacturerEntity, Integer>
    implements ManufacturerService {

  public ManufacturerServiceImpl() {
    super(new ManufacturerDataAccessImpl());
  }

}
