package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.TerminalController;
import ua.lviv.iot.terminal.model.entity.TerminalEntity;
import ua.lviv.iot.terminal.model.service.implementation.TerminalServiceImpl;

public class TerminalControllerImpl extends AbstractController<TerminalEntity, Integer> implements TerminalController {

  public TerminalControllerImpl() {
    super(new TerminalServiceImpl());
  }

}
