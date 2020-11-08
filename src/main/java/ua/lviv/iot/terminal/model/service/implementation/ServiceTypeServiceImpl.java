package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.ServiceTypeDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.ServiceTypeEntity;
import ua.lviv.iot.terminal.model.service.ServiceTypeService;

public class ServiceTypeServiceImpl extends AbstractService<ServiceTypeEntity, Integer> implements ServiceTypeService {

  public ServiceTypeServiceImpl() {
    super(new ServiceTypeDataAccessImpl());
  }

}
