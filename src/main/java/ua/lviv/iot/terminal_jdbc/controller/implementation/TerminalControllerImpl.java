package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.TerminalController;
import ua.lviv.iot.terminal_jdbc.model.entity.TerminalEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.TerminalServiceImpl;

public class TerminalControllerImpl extends AbstractController<TerminalEntity, Integer> implements TerminalController {

  public TerminalControllerImpl() {
    super(new TerminalServiceImpl());
  }

}
