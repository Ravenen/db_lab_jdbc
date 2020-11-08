package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.AddressController;
import ua.lviv.iot.terminal_jdbc.model.entity.AddressEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.AddressServiceImpl;

public class AddressControllerImpl extends AbstractController<AddressEntity, Integer> implements AddressController {

  public AddressControllerImpl() {
    super(new AddressServiceImpl());
  }

}
