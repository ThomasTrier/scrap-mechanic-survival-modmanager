package scrap.mechanic.survival.modmanager.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import scrap.mechanic.survival.modmanager.tools.entities.Controller;
import scrap.mechanic.survival.modmanager.tools.modinstaller.SurvivalModManagementController;
import scrap.mechanic.survival.modmanager.tools.modinstaller.entity.Mod;

public class CombineModController extends Controller {

  final static Logger logger = Logger.getLogger(CombineModController.class.getName());
  private JSONController jSONController = new JSONController();

  public Mod combine(List<Mod> mods) {
    mngTmp();
    File tmp = new File(configController.getPathToScrapToolFolder() + File.separator + "tmp" + File.separator + File.separator + "merged" + File.separator);
    if (tmp.exists()) {
      tmp.delete();
    }
    try {
      tmp.mkdir();
    } catch (Exception ex) {
      java.util.logging.Logger.getLogger(CombineModController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    Mod merged = new Mod(tmp.getAbsolutePath(), "merged");

    for (Mod mod : mods) {
      combineWithConflicts(merged, mod);
    }

    return merged;
  }

  private void combineWithConflicts(Mod mod1, Mod mod2) {
    for (String filePath : mod2.getFilePaths()) {
      if (mod1.getFilePaths().contains(filePath)) {
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        fileName = fileName.substring(0, fileName.lastIndexOf("."));

        if ("IconMapSurvival".equals(fileName)) {
          String xml_tmp = configController.getPathToScrapToolFolder() + File.separator + "tmp" + File.separator + "IconMapSurvival.xml";
          String png_tmp = configController.getPathToScrapToolFolder() + File.separator + "tmp" + File.separator + "IconMapSurvival.png";
          new CombineIconMapsController().combine(mod1.getSourcePath()+filePath.replace("png", "xml"), mod2.getSourcePath()+filePath.replace("png", "xml"), mod1.getSourcePath()+filePath.replace("xml", "png"), mod2.getSourcePath()+filePath.replace("xml", "png"), png_tmp, xml_tmp);
        } else {
          if (fileType.contains("json")) {
            jSONController.merge();
          } else {
            if (fileType.contains("xml")) {

            }else{
              if (fileType.contains("lua")){
                return ; //not yet supported
              }
            }
          }
        }

      } else {
        File src = new File(mod2.getSourcePath() + filePath);
        File trg = new File(mod1.getSourcePath() + filePath);
        try {
          Files.copy(src.toPath(), trg.toPath());
          mod1.getFilePaths().add(filePath);
        } catch (IOException ex) {
          java.util.logging.Logger.getLogger(CombineModController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      }
    }

  }

  private File mergeFiles(File file1, File file2) {
    return null;
  }

  private void mngTmp() {
    File tmp = new File(configController.getPathToScrapToolFolder() + File.separator + "tmp" + File.separator);
    if (!tmp.exists()) {
      try {
        tmp.mkdir();
      } catch (Exception ex) {
        java.util.logging.Logger.getLogger(SurvivalModManagementController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
