package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.ServiceTypeDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.ServiceTypeEntity;
import ua.lviv.iot.terminal_jdbc.model.service.ServiceTypeService;

public class ServiceTypeServiceImpl extends AbstractService<ServiceTypeEntity, Integer> implements ServiceTypeService {

  public ServiceTypeServiceImpl() {
    super(new ServiceTypeDataAccessImpl());
  }

}
