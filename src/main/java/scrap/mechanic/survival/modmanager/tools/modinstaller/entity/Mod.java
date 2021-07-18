package scrap.mechanic.survival.modmanager.tools.modinstaller.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Mod {

    private String id;
    private String name;
    private boolean installed = false;
    private String sourcePath;
    private List<String> filePaths; //relativ to srap mechanics root dir
    private List<String> knownCompatibleMods;

    public Mod(String sourcePath, String name) {
        id = UUID.randomUUID().toString();
        this.sourcePath = sourcePath;
        if(name != null){
            this.name=name;
        }else{
            this.name = sourcePath.substring(sourcePath.lastIndexOf("\\"));
        }
        this.name = this.name.replace("\\", "").replace("/", "").trim();
        File f = new File(sourcePath);
        filePaths = new ArrayList<>();
        findAllFiles(f);
    }

    private void findAllFiles(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
              findAllFiles(f);
            }
        }else{
            filePaths.add(file.getAbsolutePath().replace(sourcePath, ""));            
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public List<String> getKnownCompatibleMods() {
        return knownCompatibleMods;
    }

    public void setKnownCompatibleMods(List<String> knownCompatibleMods) {
        this.knownCompatibleMods = knownCompatibleMods;
    }

    public List<String> getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(List<String> filePaths) {
        this.filePaths = filePaths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }

}
