package scrap.mechanic.survival.modmanager.tools.entity;

import org.json.JSONObject;

public class MyJSONO extends JSONObject implements MyJSON{

    private String primaryKey;
    
    public MyJSONO(){
        super();
    }
    
    public MyJSONO(String jsonstring, String primaryKey){
        super(jsonstring);
        this.primaryKey = primaryKey;
    }
    
    public MyJSONO(JSONObject o, String primaryKey){
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
