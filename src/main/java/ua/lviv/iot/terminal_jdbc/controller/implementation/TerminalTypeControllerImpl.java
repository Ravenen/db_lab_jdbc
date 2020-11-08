package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.TerminalTypeController;
import ua.lviv.iot.terminal_jdbc.model.entity.TerminalTypeEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.TerminalTypeServiceImpl;

public class TerminalTypeControllerImpl extends AbstractController<TerminalTypeEntity, Integer>
    implements TerminalTypeController {

  public TerminalTypeControllerImpl() {
    super(new TerminalTypeServiceImpl());
  }

}
