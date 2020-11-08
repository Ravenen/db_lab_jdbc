package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.ServiceDataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.ServiceEntity;

public class ServiceDataAccessImpl extends AbstractDataAccess<ServiceEntity, Integer> implements ServiceDataAccess {

  public ServiceDataAccessImpl() {
    super(ServiceEntity.class);
  }

}
