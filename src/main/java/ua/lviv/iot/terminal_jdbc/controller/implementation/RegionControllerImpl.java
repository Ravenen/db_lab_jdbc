package ua.lviv.iot.terminal_jdbc.controller.implementation;

import ua.lviv.iot.terminal_jdbc.controller.RegionController;
import ua.lviv.iot.terminal_jdbc.model.entity.RegionEntity;
import ua.lviv.iot.terminal_jdbc.model.service.implementation.RegionServiceImpl;

public class RegionControllerImpl extends AbstractController<RegionEntity, Integer> implements RegionController {

  public RegionControllerImpl() {
    super(new RegionServiceImpl());
  }

}
