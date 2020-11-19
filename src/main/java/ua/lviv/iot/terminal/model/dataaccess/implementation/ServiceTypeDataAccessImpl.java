package ua.lviv.iot.terminal.model.dataaccess.implementation;

import ua.lviv.iot.terminal.model.dataaccess.ServiceTypeDataAccess;
import ua.lviv.iot.terminal.model.entity.ServiceTypeEntity;

public class ServiceTypeDataAccessImpl extends AbstractDataAccess<ServiceTypeEntity, Integer>
    implements ServiceTypeDataAccess {

  public ServiceTypeDataAccessImpl() {
    super(ServiceTypeEntity.class);
  }

}
