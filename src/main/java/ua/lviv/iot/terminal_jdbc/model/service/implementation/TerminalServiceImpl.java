package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.TerminalDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.TerminalEntity;

public class TerminalServiceImpl extends AbstractService<TerminalEntity, Integer> {

  public TerminalServiceImpl() {
    super(new TerminalDataAccessImpl());
  }

}
