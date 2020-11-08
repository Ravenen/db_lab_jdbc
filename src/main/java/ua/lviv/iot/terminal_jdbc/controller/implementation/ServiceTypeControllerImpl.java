package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.ServiceTypeController;
import ua.lviv.iot.terminal_jdbc.model.entity.ServiceTypeEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.ServiceTypeServiceImpl;

public class ServiceTypeControllerImpl extends AbstractController<ServiceTypeEntity, Integer>
    implements ServiceTypeController {

  public ServiceTypeControllerImpl() {
    super(new ServiceTypeServiceImpl());
  }

}
