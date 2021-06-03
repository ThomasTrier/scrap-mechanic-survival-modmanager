package scrap.mechanic.survival.modmanager.tools.modinstaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import scrap.mechanic.survival.modmanager.tools.config.ScrapToolsConfigController;
import scrap.mechanic.survival.modmanager.tools.config.ScrapToolsConfig;
import scrap.mechanic.survival.modmanager.tools.modinstaller.entity.Mod;
import org.apache.log4j.Logger;

public class ModInstaller {

//    private String scrapMechanicsRoot = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Scrap Mechanic";
    private String scrapMechanicsRoot = "F:\\testfolder\\Scrap Mechanic";
    private ScrapToolsConfigController configController;
    private ScrapToolsConfig config;
    private List<Mod> installedMods = new ArrayList<>();
    private List<Mod> knownMods = new ArrayList<>();

    final static Logger logger = Logger.getLogger("Modinstaller");

    public ModInstaller() {
        configController = new ScrapToolsConfigController();
        config = configController.getConfig();
        for (Mod mod : config.getMods()) {
            if (mod.isInstalled()) {
                installedMods.add(mod);
            } else {
                knownMods.add(mod);
            }
        }
    }

    public void installMod(String modName) {
        Mod mod = knownMods.stream().filter(m -> m.getName().equals(modName)).findFirst().orElse(null);
        if(mod == null){
            return;
        }
        if (updateBackup(mod)) {
            if (copyModFiles(mod)) {
                mod.setInstalled(true);
                logger.info("\"" + mod.getName() + "\" installed.");
                mod.setInstalled(true);
                knownMods.remove(mod);
                installedMods.add(mod);
                config.setMods(knownMods);
                config.getMods().addAll(installedMods);
                configController.setConfig(config);
                configController.update();
            }else{
               logger.warn("Error while installing \"" + mod.getName() + "\".");
            }
        } else {
            logger.warn("Could not update backupfiles. Installation stopped.");
        }

    }

    public boolean findSurvivalModsAndAddToList(String sourcePath, String name) {
        File file = new File(sourcePath);
        if (file.isDirectory()) {
            List<File> ff = Arrays.asList(file.listFiles());
            if (Arrays.asList(file.listFiles()).stream().anyMatch(f -> f.getAbsolutePath().toLowerCase().endsWith("\\survival") || f.getAbsolutePath().toLowerCase().contains("\\survival\\"))) {
                Mod newMod = new Mod(sourcePath, null);
                if (!installedMods.stream().anyMatch(m -> m.getName().equals(newMod.getName())) && !knownMods.stream().anyMatch(m -> m.getName().equals(newMod.getName()))) {
                    knownMods.add(newMod);
                    config.getMods().add(newMod);
                    configController.setConfig(config);
                    configController.update();
                    logger.info("Found: \"" + newMod.getName() + "\".");
                }
            } else {
                int index = 0;
                for (File f : file.listFiles()) {
                    if (f.isDirectory()) {
                        findSurvivalModsAndAddToList(f.getAbsolutePath(), sourcePath.substring(sourcePath.lastIndexOf("\\")) + "_" + index++);
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean removeKnownMod(String modname) {
        for (Mod mod : config.getMods()) {
            System.err.println(mod.getName());
        }
        Mod toRemove = config.getMods().stream().filter(mod -> mod.getName().equals(modname)).findFirst().orElse(null);
        if (toRemove != null) {
            if (!toRemove.isInstalled()) {
                boolean result = config.getMods().remove(toRemove);
                knownMods.remove(toRemove);
                configController.update();
                if (result) {
                    logger.info("Mod \"" + modname + "\" succesfully removed");
                } else {
                    logger.error("Cannot remove mod.");
                }
            } else {
                logger.warn("Cannot remove installed mods");
            }
        } else {
            logger.warn("Cant find \"" + modname + "\".");
            return false;
        }
        return true;
    }

    public boolean updateBackup(Mod mod) {
        try {
            File backupFolder = new File(scrapMechanicsRoot + "\\backup");
            if (!backupFolder.exists()) {
                Files.createDirectory(backupFolder.toPath());
            }

            for (String path : mod.getFilePaths()) {
                File trg = new File(backupFolder.getAbsolutePath() + path);
                if (!trg.exists()) {
                    File src = new File(scrapMechanicsRoot + path);
                    if (src.exists()) {
                        Files.createDirectories(trg.getParentFile().toPath());
                        Files.copy(src.toPath(), trg.toPath());
                    }
                }
            }
        } catch (Exception e) {
            logger.error(null, e);
            return false;
        }
        return true;
    }

    public void resetGame() {
        for (Mod mod : installedMods) {
            if (mod.isInstalled()) {
                for (String filePath : mod.getFilePaths()) {
                    File file = new File(scrapMechanicsRoot + filePath);
                    if (file.exists()) {
                        System.err.println("delete: " + file.toPath().toString());
                        file.delete();
                    }
                }
                mod.setInstalled(false);
                logger.info("Mod \"" + mod.getName() + "\" uninstalled");
            }
        }
        knownMods.addAll(installedMods);
        config.setMods(knownMods);
        configController.setConfig(config);
        configController.update();
        File backupFolder = new File("backup");

        if (backupFolder.exists()) {
            copyBackupFiles(backupFolder);
            logger.info("Backuped files restored");
        }
    }

    private boolean copyBackupFiles(File file) {
        try {
            if (file.isFile()) {
                File trg = new File(scrapMechanicsRoot + file.getAbsolutePath().split("backup")[1]);
                if (trg.exists()) {
                    Files.move(file.toPath(), trg.toPath(), StandardCopyOption.ATOMIC_MOVE);
                    logger.info("File \"" + file.getName() + "\" restored.");
                }
            } else {
                for (File listFile : file.listFiles()) {
                    copyBackupFiles(listFile);
                }
            }
        } catch (IOException e) {
            logger.error(null, e);
            return false;
        }
        return true;
    }

    private boolean copyModFiles(Mod mod) {
        try {
            for (String filePath : mod.getFilePaths()) {
                File src = new File(mod.getSourcePath() + filePath);
                File trg = new File(scrapMechanicsRoot + filePath);
                Files.copy(src.toPath(), trg.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            logger.error(null, e);
            return false;
        }
        return true;
    }

    public String getScrapMechanicsRoot() {
        return scrapMechanicsRoot;
    }

    public void setScrapMechanicsRoot(String scrapMechanicsRoot) {
        this.scrapMechanicsRoot = scrapMechanicsRoot;
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
