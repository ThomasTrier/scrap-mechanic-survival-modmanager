package scrap.mechanic.survival.modmanager.tools.modinstaller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import scrap.mechanic.survival.modmanager.tools.entities.Controller;
import scrap.mechanic.survival.modmanager.tools.modinstaller.entity.Mod;

public class SurvivalModManagementController extends Controller {

  private List<Mod> installedMods = new ArrayList<>();
  private List<Mod> knownMods = new ArrayList<>();

  private final Logger LOGGER = Logger.getLogger(getClass().getName());

  public SurvivalModManagementController() {
    reloadMods();
  }

  private void reloadMods() {
    installedMods = new ArrayList<>();
    knownMods = new ArrayList<>();
    for (Mod mod : configController.getMods()) {
      if (mod.isInstalled()) {
        installedMods.add(mod);
      } else {
        knownMods.add(mod);
      }
    }
  }

  public void installMod(String modName) {
    Mod mod = knownMods.stream().filter(m -> m.getName().equals(modName)).findFirst().orElse(null);
    if (mod == null || mod.isInstalled()) {
      if (mod == null) {
        LOGGER.info("Mod: " + modName + " could not be found. Nothing changed.");
      } else {
        LOGGER.info("Mod: " + mod.getName() + "already installed. Nothing changed.");
      }
      return;
    }

    if (updateBackup(mod)) {
      if (copyModFiles(mod)) {
        mod.setInstalled(true);
        LOGGER.info("\"" + mod.getName() + "\" installed.");
        mod.setInstalled(true);
        configController.setMods(knownMods);
        configController.getMods().addAll(installedMods);
        reloadMods();
        configController.update();
      } else {
        LOGGER.warn("Error while installing \"" + mod.getName() + "\".");
      }
    } else {
      LOGGER.warn("Could not update backupfiles. Installation stopped.");
    }

  }

  public boolean findSurvivalModsAndAddToList(String sourcePath, String name) {
    File file = new File(sourcePath);
    String descriptionname = name;
    if (file.isDirectory()) {
      String tmp = checkForSteamDescriptionFile(file);
      if (tmp != null) {
        descriptionname = tmp;
      }
      if (Arrays.asList(file.listFiles()).stream().anyMatch(f -> f.getAbsolutePath().toLowerCase().endsWith("\\survival") || f.getAbsolutePath().toLowerCase().contains("\\survival\\"))) {
        Mod newMod = new Mod(sourcePath, descriptionname);
        if (!installedMods.stream().anyMatch(m -> m.getName().equals(newMod.getName())) && !knownMods.stream().anyMatch(m -> m.getName().equals(newMod.getName()))) {
          knownMods.add(newMod);
          configController.getMods().add(newMod);
          configController.update();
          LOGGER.info("Found: \"" + newMod.getName() + "\".");
        }
      } else {
        int index = 0;
        for (File f : file.listFiles()) {
          if (f.isDirectory()) {
            if (descriptionname == null) {
              descriptionname = sourcePath.substring(sourcePath.lastIndexOf("\\")) + "_" + index++;
            }
            findSurvivalModsAndAddToList(f.getAbsolutePath(), descriptionname);
          }
        }
      }
    } else {
      return false;
    }
    return true;
  }

  private String checkForSteamDescriptionFile(File file) {
    if (file.isDirectory()) {
      File description = Arrays.asList(file.listFiles()).stream().filter(f -> f.isFile() && f.getName().equals("description.json")).findFirst().orElse(null);
      if (description != null) {
        try {
          FileReader reader = new FileReader(description);
          BufferedReader br = new BufferedReader(reader);
          String line = null;
          while ((line = br.readLine()) != null) {
            if (line.contains("name")) {
              String name = line.split(":")[1].split("\"")[1].split("\"")[0];
              System.err.println("name: " + name);
              return name;
            }
          }
        } catch (Exception ex) {
        }

      }
    }
    return null;
  }

  public boolean removeKnownMod(String modname) {
    Mod toRemove = configController.getMods().stream().filter(mod -> mod.getName().equals(modname)).findFirst().orElse(null);
    if (toRemove != null) {
      if (!toRemove.isInstalled()) {
        boolean result = configController.getMods().remove(toRemove);
        knownMods.remove(toRemove);
        configController.update();
        if (result) {
          LOGGER.info("Mod \"" + modname + "\" succesfully removed");
        } else {
          LOGGER.error("Cannot remove mod.");
        }
      } else {
        LOGGER.warn("Cannot remove installed mods");
      }
    } else {
      LOGGER.warn("Cant find \"" + modname + "\".");
      return false;
    }
    return true;
  }

  public boolean updateBackup(Mod mod) {
    try {
      File backupFolder = new File(configController.getPathToBackupfolder());
      if (!backupFolder.exists()) {
        Files.createDirectory(backupFolder.toPath());
      }

      for (String path : mod.getFilePaths()) {
        File trg = new File(backupFolder.getAbsolutePath() + path);
        if (!trg.exists()) {
          File src = new File(configController.getPathToScrapmechanic() + path);
          if (src.exists()) {
            Files.createDirectories(trg.getParentFile().toPath());
            Files.copy(src.toPath(), trg.toPath());
          }
        }
      }
    } catch (IOException e) {
      LOGGER.error(null, e);
      return false;
    }
    return true;
  }

  public void resetGame() {
    for (Mod mod : installedMods) {
      if (mod.isInstalled()) {
        for (String filePath : mod.getFilePaths()) {
          File file = new File(configController.getPathToScrapmechanic() + filePath);
          if (file.exists()) {
            file.delete();
          }
        }
        mod.setInstalled(false);
        LOGGER.info("Mod \"" + mod.getName() + "\" uninstalled");
      }
    }
    configController.setMods(knownMods);
    configController.getMods().addAll(installedMods);
    configController.update();
    reloadMods();
    File backupFolder = new File(configController.getPathToBackupfolder());

    if (backupFolder.exists()) {
      copyBackupFiles(backupFolder);
      LOGGER.info("Backuped files restored");
    }
  }

  private boolean copyBackupFiles(File file) {
    try {
      if (file.isFile()) {
        File trg = new File(configController.getPathToScrapmechanic() + file.getAbsolutePath().split("backup")[1]);
        Files.move(file.toPath(), trg.toPath(), StandardCopyOption.ATOMIC_MOVE);
        LOGGER.info("File \"" + file.getName() + "\" restored.");
      } else {
        for (File listFile : file.listFiles()) {
          copyBackupFiles(listFile);
        }
      }
    } catch (IOException e) {
      LOGGER.error(null, e);
      return false;
    }
    return true;
  }

  private boolean copyModFiles(Mod mod) {
    try {
      for (String filePath : mod.getFilePaths()) {
        File src = new File(mod.getSourcePath() + filePath);
        File trg = new File(configController.getPathToScrapmechanic() + filePath);
        File trgDir = new File(configController.getPathToScrapmechanic() + filePath.substring(0, filePath.lastIndexOf("\\")));
        if (!trgDir.exists()) {
          trgDir.mkdirs();
        }
        Files.copy(src.toPath(), trg.toPath(), StandardCopyOption.REPLACE_EXISTING);
      }
    } catch (IOException e) {
      LOGGER.error(null, e);
      return false;
    }
    return true;
  }

  public String[] getInstalledMods() {
    String[] k = new String[installedMods.size()];
    for (int i = 0; i < installedMods.size(); i++) {
      k[i] = installedMods.get(i).getName();
    }
    return k;
  }

  public void setInstalledMods(List<Mod> installedMods) {
    this.installedMods = installedMods;
  }

  public String[] getKnownMods() {
    String[] k = new String[knownMods.size()];
    for (int i = 0; i < knownMods.size(); i++) {
      k[i] = knownMods.get(i).getName();
    }
    return k;
  }

  public void setKnownMods(List<Mod> knownMods) {
    this.knownMods = knownMods;
  }

}
