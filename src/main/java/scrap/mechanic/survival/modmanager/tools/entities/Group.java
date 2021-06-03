package scrap.mechanic.survival.modmanager.tools.entities;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Group {
    private String name;
    private String texture;
    private String size;
    private List<Index> Index;
    
    
    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    @XmlAttribute
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @XmlElement(name="Index")
    public List<Index> getIndex() {
        return Index;
    }

    public void setIndex(List<Index> index) {
        this.Index = index;
    }

   

}
