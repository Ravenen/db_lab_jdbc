package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.AddressController;
import ua.lviv.iot.terminal.model.entity.AddressEntity;
import ua.lviv.iot.terminal.model.service.implementation.AddressServiceImpl;

public class AddressControllerImpl extends AbstractController<AddressEntity, Integer> implements AddressController {

  public AddressControllerImpl() {
    super(new AddressServiceImpl());
  }

}
