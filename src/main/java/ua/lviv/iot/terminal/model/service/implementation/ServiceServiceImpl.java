package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.ServiceDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.ServiceEntity;
import ua.lviv.iot.terminal.model.service.ServiceService;

public class ServiceServiceImpl extends AbstractService<ServiceEntity, Integer> implements ServiceService {

  public ServiceServiceImpl() {
    super(new ServiceDataAccessImpl());
  }

}
