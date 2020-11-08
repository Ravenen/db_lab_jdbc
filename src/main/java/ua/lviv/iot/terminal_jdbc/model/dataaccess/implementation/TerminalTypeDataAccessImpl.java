package ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.TerminalTypeDataAccess;
import ua.lviv.iot.terminal_jdbc.model.entity.TerminalTypeEntity;

public class TerminalTypeDataAccessImpl extends AbstractDataAccess<TerminalTypeEntity, Integer>
    implements TerminalTypeDataAccess {

  public TerminalTypeDataAccessImpl() {
    super(TerminalTypeEntity.class);
  }

}
