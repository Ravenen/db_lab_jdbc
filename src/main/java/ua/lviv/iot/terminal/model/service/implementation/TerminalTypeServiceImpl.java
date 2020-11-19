package ua.lviv.iot.terminal.model.service.implementation;

import ua.lviv.iot.terminal.model.dataaccess.implementation.TerminalTypeDataAccessImpl;
import ua.lviv.iot.terminal.model.entity.TerminalTypeEntity;
import ua.lviv.iot.terminal.model.service.TerminalTypeService;

public class TerminalTypeServiceImpl extends AbstractService<TerminalTypeEntity, Integer>
    implements TerminalTypeService {

  public TerminalTypeServiceImpl() {
    super(new TerminalTypeDataAccessImpl());
  }

}
