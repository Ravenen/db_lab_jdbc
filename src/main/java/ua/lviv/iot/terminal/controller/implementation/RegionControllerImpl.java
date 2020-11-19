package ua.lviv.iot.terminal.controller.implementation;

import ua.lviv.iot.terminal.controller.RegionController;
import ua.lviv.iot.terminal.model.entity.RegionEntity;
import ua.lviv.iot.terminal.model.service.implementation.RegionServiceImpl;

public class RegionControllerImpl extends AbstractController<RegionEntity, Integer> implements RegionController {

  public RegionControllerImpl() {
    super(new RegionServiceImpl());
  }

}
