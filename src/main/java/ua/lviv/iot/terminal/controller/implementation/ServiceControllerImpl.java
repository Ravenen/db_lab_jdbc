package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.ServiceController;
import ua.lviv.iot.terminal.model.entity.ServiceEntity;
import ua.lviv.iot.terminal.model.service.implementation.ServiceServiceImpl;

public class ServiceControllerImpl extends AbstractController<ServiceEntity, Integer> implements ServiceController {

  public ServiceControllerImpl() {
    super(new ServiceServiceImpl());
  }

}
