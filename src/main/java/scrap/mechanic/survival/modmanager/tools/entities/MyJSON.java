
package scrap.mechanic.survival.modmanager.tools.entities;

public interface MyJSON {
    public String getPrimaryKey();
    public void setPrimaryKey(String primaryKey);
    public String toJSONString(int intendation);
}
