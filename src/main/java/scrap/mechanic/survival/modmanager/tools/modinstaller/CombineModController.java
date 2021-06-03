package scrap.mechanic.survival.modmanager.tools.modinstaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import scrap.mechanic.survival.modmanager.tools.modinstaller.entity.Mod;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class CombineModController {

    private String scrapMechanicsRoot;
    final static Logger logger = Logger.getLogger(CombineModController.class.getName());

    public CombineModController(String scrapMechanicsRoot) {
        this.scrapMechanicsRoot = scrapMechanicsRoot;
    }

    public Mod combine(Mod modA, Mod modB) {
        try {
            File file = new File(scrapMechanicsRoot + "\\backup\\combined");
            Files.deleteIfExists(file.toPath());
            Files.createDirectory(file.toPath());
            Mod combined = new Mod(scrapMechanicsRoot + "\\backup\\combined", "combined");
        } catch (IOException ex) {
            logger.error(null, ex);
        }
        return null;
    }
}
