package scrap.mechanic.survival.modmanager.tools;

import scrap.mechanic.survival.modmanager.tools.entities.Frame;
import scrap.mechanic.survival.modmanager.tools.entities.Index;
import scrap.mechanic.survival.modmanager.tools.entities.MyGUI;

public class IconMapController {
    public Index addNewIndex(MyGUI gui, String name){
        Index i = new Index();
        i.setName(name);
        Frame f = getNextFrame(gui);
        i.setFrame(f);
        gui.getResource().getGroup().getIndex().add(i);
        return i;
    }
    
    public Frame getNextFrame(MyGUI gui){
        Frame frame = new Frame();
        int maxX = 0;
        int currentY = 0;
        int currentX = 0;
        for (Index index : gui.getResource().getGroup().getIndex()) {
            if(index.getFrame().getX() > maxX){
                maxX = index.getFrame().getX();
            }
            if(index.getFrame().getY() >= currentY){
                currentX = index.getFrame().getX();
                currentY = index.getFrame().getY();
            }
        }
        if(currentX == maxX){
            currentY += 96;
            currentX = 0;
        }else{
            currentX += 96;
        }
        frame.setPoint(currentX + " " + currentY);
        return frame;
    }
}
