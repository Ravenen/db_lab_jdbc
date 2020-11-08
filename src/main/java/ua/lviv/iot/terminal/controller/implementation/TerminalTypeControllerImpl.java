package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.TerminalTypeController;
import ua.lviv.iot.terminal.model.entity.TerminalTypeEntity;
import ua.lviv.iot.terminal.model.service.implementation.TerminalTypeServiceImpl;

public class TerminalTypeControllerImpl extends AbstractController<TerminalTypeEntity, Integer>
    implements TerminalTypeController {

  public TerminalTypeControllerImpl() {
    super(new TerminalTypeServiceImpl());
  }

}
