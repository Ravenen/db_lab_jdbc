package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.AddressDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.AddressEntity;
import ua.lviv.iot.terminal.model.service.AddressService;

public class AddressServiceImpl extends AbstractService<AddressEntity, Integer> implements AddressService {

  public AddressServiceImpl() {
    super(new AddressDataAccessImpl());
  }

}
