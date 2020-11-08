package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.AddressDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.AddressEntity;
import ua.lviv.iot.terminal_jdbc.model.service.AddressService;

public class AddressServiceImpl extends AbstractService<AddressEntity, Integer> implements AddressService {

  public AddressServiceImpl() {
    super(new AddressDataAccessImpl());
  }

}
