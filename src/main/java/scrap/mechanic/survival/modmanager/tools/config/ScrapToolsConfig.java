package scrap.mechanic.survival.modmanager.tools.config;

import java.util.ArrayList;
import java.util.List;
import scrap.mechanic.survival.modmanager.tools.modinstaller.entity.Mod;

public class ScrapToolsConfig {
  
    private List<Mod> mods = new ArrayList<>();    
    private String pathToScrapmechanic = "unknown";
    private String pathToScrapToolFolder = "unknown";
    
    public ScrapToolsConfig(){
    }
    

    public List<Mod> getMods() {
        return mods;
    }

    public void setMods(List<Mod> mods) {
        this.mods = mods;
    }

  public String getPathToScrapmechanic() {
    return pathToScrapmechanic;
  }

  public void setPathToScrapmechanic(String pathToScrapmechanic) {
    this.pathToScrapmechanic = pathToScrapmechanic;
  }
  
  public String getPathToScrapmechanicSurvival() {
    return pathToScrapmechanic + "\\Survival";
  }
  
  public String getPathToBackupfolder() {
    return pathToScrapToolFolder + "\\backup";
  }
  
  public String getPathToModfolder() {
    return pathToScrapToolFolder + "\\mods";
  }
  
  public String getPathToLogFile() {
    return pathToScrapToolFolder + "\\debug-log.out";
  }


  public String getPathToScrapToolFolder() {
    return pathToScrapToolFolder;
  }

  public void setPathToScrapToolFolder(String pathToScrapToolFolder) {
    this.pathToScrapToolFolder = pathToScrapToolFolder;
  }

}
