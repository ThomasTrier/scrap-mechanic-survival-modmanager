package scrap.mechanic.survival.modmanager.tools.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Index {
    private String name;
    private Frame Frame;
    

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="Frame")
    public Frame getFrame() {
        return Frame;
    }

    public void setFrame(Frame frame) {
        this.Frame = frame;
    }
}
