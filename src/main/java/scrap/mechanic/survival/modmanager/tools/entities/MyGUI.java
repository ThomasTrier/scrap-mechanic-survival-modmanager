package scrap.mechanic.survival.modmanager.tools.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MyGUI")
public class MyGUI {
    private String type;
    private String version;
    private Resource Resource;    
    
    @XmlAttribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlAttribute
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlElement(name="Resource")
    public Resource getResource() {
        return Resource;
    }

    public void setResource(Resource resource) {
        this.Resource = resource;
    }
    
}
