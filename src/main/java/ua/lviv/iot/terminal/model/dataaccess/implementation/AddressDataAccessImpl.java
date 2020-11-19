package ua.lviv.iot.terminal.model.dataaccess.implementation;

import ua.lviv.iot.terminal.model.dataaccess.AddressDataAccess;
import ua.lviv.iot.terminal.model.entity.AddressEntity;

public class AddressDataAccessImpl extends AbstractDataAccess<AddressEntity, Integer> implements AddressDataAccess {

  public AddressDataAccessImpl() {
    super(AddressEntity.class);
  }

}
