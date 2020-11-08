package ua.lviv.iot.terminal.model.dataaccess.implementation;

import ua.lviv.iot.terminal.model.dataaccess.ServiceDataAccess;
import ua.lviv.iot.terminal.model.entity.ServiceEntity;

public class ServiceDataAccessImpl extends AbstractDataAccess<ServiceEntity, Integer> implements ServiceDataAccess {

  public ServiceDataAccessImpl() {
    super(ServiceEntity.class);
  }

}
