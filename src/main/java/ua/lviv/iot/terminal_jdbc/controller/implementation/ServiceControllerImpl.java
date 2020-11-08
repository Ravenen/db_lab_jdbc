package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.ServiceController;
import ua.lviv.iot.terminal_jdbc.model.entity.ServiceEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.ServiceServiceImpl;

public class ServiceControllerImpl extends AbstractController<ServiceEntity, Integer> implements ServiceController {

  public ServiceControllerImpl() {
    super(new ServiceServiceImpl());
  }

}
