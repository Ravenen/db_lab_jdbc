package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.ServiceDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.ServiceEntity;
import ua.lviv.iot.terminal_jdbc.model.service.ServiceService;

public class ServiceServiceImpl extends AbstractService<ServiceEntity, Integer> implements ServiceService {

  public ServiceServiceImpl() {
    super(new ServiceDataAccessImpl());
  }

}
