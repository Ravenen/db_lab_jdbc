package ua.lviv.iot.terminal_jdbc.model.service.implementation;

import ua.lviv.iot.terminal_jdbc.model.dataaccess.implementation.TerminalTypeDataAccessImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.TerminalTypeEntity;
import ua.lviv.iot.terminal_jdbc.model.service.TerminalTypeService;

public class TerminalTypeServiceImpl extends AbstractService<TerminalTypeEntity, Integer>
    implements TerminalTypeService {

  public TerminalTypeServiceImpl() {
    super(new TerminalTypeDataAccessImpl());
  }

}
