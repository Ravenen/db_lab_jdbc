package ua.lviv.iot.terminal.model.dataaccess.implementation;

import ua.lviv.iot.terminal.model.dataaccess.TerminalDataAccess;
import ua.lviv.iot.terminal.model.entity.TerminalEntity;

public class TerminalDataAccessImpl extends AbstractDataAccess<TerminalEntity, Integer> implements TerminalDataAccess {

  public TerminalDataAccessImpl() {
    super(TerminalEntity.class);
  }

}
