package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.TerminalDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.TerminalEntity;

public class TerminalServiceImpl extends AbstractService<TerminalEntity, Integer> {

  public TerminalServiceImpl() {
    super(new TerminalDataAccessImpl());
  }

}
