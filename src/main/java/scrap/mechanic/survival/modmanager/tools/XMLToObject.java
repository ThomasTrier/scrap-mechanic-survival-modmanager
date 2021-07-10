package scrap.mechanic.survival.modmanager.tools;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XMLToObject<T> {
    private Class<T> type;
    public XMLToObject(Class<T> t){
        type = t;
    }
    
    public T getAsObject(String filepath){
        try {
            File file = new File(filepath);
            JAXBContext jaxbContext = JAXBContext.newInstance(type.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            T t = (T) jaxbUnmarshaller.unmarshal(file);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
