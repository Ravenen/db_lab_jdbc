package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.ServiceTypeController;
import ua.lviv.iot.terminal.model.entity.ServiceTypeEntity;
import ua.lviv.iot.terminal.model.service.implementation.ServiceTypeServiceImpl;

public class ServiceTypeControllerImpl extends AbstractController<ServiceTypeEntity, Integer>
    implements ServiceTypeController {

  public ServiceTypeControllerImpl() {
    super(new ServiceTypeServiceImpl());
  }

}
