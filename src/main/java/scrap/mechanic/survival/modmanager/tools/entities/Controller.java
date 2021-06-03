package scrap.mechanic.survival.modmanager.tools.entities;

import scrap.mechanic.survival.modmanager.tools.config.ScrapToolsConfig;
import scrap.mechanic.survival.modmanager.tools.config.ScrapToolsConfigController;

public class Controller {
  protected ScrapToolsConfigController configController = new ScrapToolsConfigController();
  protected ScrapToolsConfig config = configController.getConfig();

}
