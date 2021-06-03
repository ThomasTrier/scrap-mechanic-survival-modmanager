package scrap.mechanic.survival.modmanager.tools.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyJSONL implements MyJSON{

    private List<String> data;    
    private String key;
  
    public MyJSONL(String jsonstring){
        System.err.println(jsonstring);
        key = jsonstring.split("\\[")[0].replace("{", "").replace(" ", "").replace("\t", "").replace(":", "").replace("\"", "").replace("\n", "").replace("\r", "");
        List<String> lines = Arrays.asList(jsonstring.split("\\]")[0].split("\\[")[1].split("\n"));
        data = new ArrayList<>();
        for (String line : lines) {
            line = line.replace(" ", "").replace("\"", "").replace(",", "").replace("\t", "").replace("\n", "").replace("\r", "");
            if(line != null && !line.isEmpty() && !line.isBlank() && !line.startsWith("//")){
                data.add(line);
            }
        }
    }
    
    @Override
    public String getPrimaryKey() {
        return getKey();
    }

    @Override
    public void setPrimaryKey(String primaryKey) {setKey(primaryKey);}

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    @Override
    public String toJSONString(int intendation) {
        String intend = "";
        for (int i = 0; i < intendation; i++) {
            intend += " ";
        }
        String result =  "{\n";
        result += intend + "\"" + key + "\": [\n";
        for (int i = 0; i < data.size()-1; i++) {
            result += intend+intend+"\"" + data.get(i) + "\",\n";
        }
        result += intend+intend+"\"" + data.get(data.size()-1) + "\"\n" + intend + "]\n}";
        return result;
    }

}
