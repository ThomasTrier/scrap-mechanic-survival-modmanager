package scrap.mechanic.survival.modmanager.tools;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.List;
import scrap.mechanic.survival.modmanager.tools.entities.Index;
import scrap.mechanic.survival.modmanager.tools.entities.MyGUI;

public class MainController {
    
    private String root;
    private String iconfolder;
    private List<String> icons;
    private boolean survival = false;

    public String chooseRootPathFileDialog() {
        OpenFileDialog dialog = new OpenFileDialog();
        root = dialog.askForScrapRoot();
        return root;
    }

    public String chooseIconPath() {
        OpenFileDialog dialog = new OpenFileDialog();
        iconfolder = dialog.askForIconFolder();
        return iconfolder;
    }

    public int getIconCount() {
        File dir = new File(iconfolder);
        int c = 0;
        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                if (f.getName().endsWith(".png")) {
                    c++;
                }
            }
        }
        return c;
    }

    public boolean createBackup() {
        if (root != null) {
            try {
                if(survival){
                    Files.copy(Paths.get(root.concat("\\Survival\\Gui\\IconMapSurvival.xml")), Paths.get(root.concat("\\Survival\\Gui\\IconMapSurvival_Save_" + System.currentTimeMillis() + ".xml")), REPLACE_EXISTING);
                    Files.copy(Paths.get(root.concat("\\Survival\\Gui\\IconMapSurvival.png")), Paths.get(root.concat("\\Survival\\Gui\\IconMapSurvival_Save_" + System.currentTimeMillis() + ".png")), REPLACE_EXISTING);
                }else{
                    Files.copy(Paths.get(root.concat("\\Data\\Gui\\IconMapSurvival.xml")), Paths.get(root.concat("\\Data\\Gui\\IconMapSurvival_Save_" + System.currentTimeMillis() + ".xml")), REPLACE_EXISTING);
                    Files.copy(Paths.get(root.concat("\\Data\\Gui\\IconMapSurvival.png")), Paths.get(root.concat("\\Data\\Gui\\IconMapSurvival_Save_" + System.currentTimeMillis() + ".png")), REPLACE_EXISTING);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean insertIcons() {
        if (root != null && iconfolder != null) {
            IconMapXMLReader reader = new IconMapXMLReader();
            IconMapController iconCtrl = new IconMapController();
            ImageController imgCtrl = new ImageController();            
            MyGUI gui = reader.readIconMap(root.concat(survival ? "\\Survival\\Gui\\IconMapSurvival.xml" : "\\Data\\Gui\\IconMapSurvival.xml"));
            File dir = new File(iconfolder);
            for (File file : dir.listFiles()) {
                Index i = iconCtrl.addNewIndex(gui, file.getName().substring(0, file.getName().length()-3));
                imgCtrl.addNewIcon(root.concat(survival ? "\\Survival\\Gui\\IconMapSurvival.png" : "\\Data\\Gui\\IconMapSurvival.png"), file.getAbsolutePath(), i.getFrame());
                reader.writeIconMap(gui, root.concat(survival ? "\\Survival\\Gui\\IconMapSurvival.xml" : "\\Data\\Gui\\IconMapSurvival.xml"));
            }
            return true;
        }
        return false;
    }

    public boolean isSurvival() {
        return survival;
    }

    public void setSurvival(boolean survival) {
        this.survival = survival;
    }
}
