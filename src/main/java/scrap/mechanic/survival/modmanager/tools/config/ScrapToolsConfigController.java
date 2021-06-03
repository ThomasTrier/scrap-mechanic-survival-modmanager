package scrap.mechanic.survival.modmanager.tools.config;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;


public class ScrapToolsConfigController {

    Logger logger = Logger.getLogger(ScrapToolsConfigController.class.getName());
    
    private ScrapToolsConfig config = new ScrapToolsConfig();


    public ScrapToolsConfigController() {
        Gson g = new Gson();
        try {
            File file = new File("scraptoolconfig.json");
            if (!file.exists()) {
                config = new ScrapToolsConfig();
                update();
            } else {
                config = g.fromJson(Files.readString(file.toPath(), StandardCharsets.UTF_8), ScrapToolsConfig.class);
            }
        } catch (JsonSyntaxException | IOException e) {
          logger.log(Level.SEVERE, "Can not read and/or create config file", e);
        }
    }

    public final void update() {
        Gson g = new Gson();
        try {
            File file = new File("scraptoolconfig.json");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            JSONObject o = new JSONObject(g.toJson(config));
            writer.write(o.toString(4));
            writer.flush();
            
        } catch (IOException | JSONException e) {
            logger.log(Level.SEVERE, "Can not update config file", e);
        }
    }
    
   public boolean isConfigured(){
     if(config != null){
       return config.getPathToScrapToolFolder() != null && 
               !config.getPathToScrapToolFolder().trim().isEmpty() && 
               config.getPathToScrapmechanic()!= null && 
               !config.getPathToScrapmechanic().trim().isEmpty() &&
               !config.getPathToScrapToolFolder().equals("unknown") &&
               !config.getPathToScrapmechanic().equals("unknown");
     }
     return false;
   }
    
    public ScrapToolsConfig getConfig() {
        return config;
    }

    public void setConfig(ScrapToolsConfig config) {
        this.config = config;
    }

}
