
package scrap.mechanic.survival.modmanager.tools.entities;

import javax.xml.bind.annotation.XmlAttribute;

public class Frame {
    private String point;
    

    @XmlAttribute
    public String getPoint() {
        return point;
    }
    
    public int getX(){
        return Integer.parseInt(point.split(" ")[0]);
    }
    
    public int getY(){
        return Integer.parseInt(point.split(" ")[1]);
    }
   
    public void setPoint(String point) {
        this.point = point;
    }
    
}
