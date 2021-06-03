package scrap.mechanic.survival.modmanager.tools.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Resource {
    private String type;
    private String name;
    private Group Group;
    

    @XmlAttribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="Group")
    public Group getGroup() {
        return Group;
    }

    public void setGroup(Group group) {
        this.Group = group;
    }
}
