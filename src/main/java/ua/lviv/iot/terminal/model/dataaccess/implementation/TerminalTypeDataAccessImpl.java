package ua.lviv.iot.terminal.model.dataaccess.implementation;

import ua.lviv.iot.terminal.model.dataaccess.TerminalTypeDataAccess;
import ua.lviv.iot.terminal.model.entity.TerminalTypeEntity;

public class TerminalTypeDataAccessImpl extends AbstractDataAccess<TerminalTypeEntity, Integer>
    implements TerminalTypeDataAccess {

  public TerminalTypeDataAccessImpl() {
    super(TerminalTypeEntity.class);
  }

}
