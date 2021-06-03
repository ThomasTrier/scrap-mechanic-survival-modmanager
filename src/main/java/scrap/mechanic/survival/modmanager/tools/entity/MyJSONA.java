package scrap.mechanic.survival.modmanager.tools.entity;

import org.json.JSONArray;
import org.json.JSONObject;

public class MyJSONA extends JSONArray implements MyJSON{

    private String primaryKey;
    
    public MyJSONA(){
        super();
    }
    
    public MyJSONA(String jsonstring, String primaryKey){
        super(jsonstring);
        this.primaryKey = primaryKey;
    }
    
    public MyJSONA(JSONObject o, String primaryKey){
        super(o);
        this.primaryKey = primaryKey;
    }
    
    @Override
    public String getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public String toJSONString(int intendation) {
        return super.toString(intendation);
    }
    
}
