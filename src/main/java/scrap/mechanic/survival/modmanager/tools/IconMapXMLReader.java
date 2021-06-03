package scrap.mechanic.survival.modmanager.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import scrap.mechanic.survival.modmanager.tools.entities.MyGUI;

public class IconMapXMLReader {

    public MyGUI readIconMap(String filepath) {
        try {
            File file = new File(filepath);
            JAXBContext jaxbContext = JAXBContext.newInstance(MyGUI.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MyGUI gui = (MyGUI) jaxbUnmarshaller.unmarshal(file);
            return gui;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeIconMap(MyGUI gui, String filepath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MyGUI.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            OutputStream os = new FileOutputStream(filepath);
            jaxbMarshaller.marshal(gui, os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
