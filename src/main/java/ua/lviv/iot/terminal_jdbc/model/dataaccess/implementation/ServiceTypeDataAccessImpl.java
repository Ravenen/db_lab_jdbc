package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.ServiceTypeDataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.ServiceTypeEntity;

public class ServiceTypeDataAccessImpl extends AbstractDataAccess<ServiceTypeEntity, Integer>
    implements ServiceTypeDataAccess {

  public ServiceTypeDataAccessImpl() {
    super(ServiceTypeEntity.class);
  }

}
