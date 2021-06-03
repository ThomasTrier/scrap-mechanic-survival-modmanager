package scrap.mechanic.survival.modmanager.tools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import scrap.mechanic.survival.modmanager.tools.entities.Frame;

public class ImageController {

    public void addNewIcon(String targetMap, String sourceMap, List<Frame> sourceFrames, List<Frame> targetFrames) {
        try {
            File targetFile = new File(targetMap);
            System.err.println(targetFile.exists());
            BufferedImage targetImage = ImageIO.read(targetFile);
            if(targetImage == null){
                targetImage = new BufferedImage(240, 240, BufferedImage.TYPE_INT_RGB);
            }
            BufferedImage sourceImage = ImageIO.read(new File(sourceMap));
            BufferedImage overlay = null;
            Graphics g = null;
            for (int i = 0; i < targetFrames.size(); i++) {
                if (targetImage.getHeight() <= (targetFrames.get(i).getY() + 96)) {
                    BufferedImage resized = new BufferedImage(targetImage.getWidth(), targetImage.getHeight() + 96, BufferedImage.TYPE_INT_ARGB);
                    g = resized.getGraphics();
                    g.drawImage(targetImage, 0, 0, null);
                    g.dispose();
                    targetImage = resized;
                }
                overlay = sourceImage.getSubimage(sourceFrames.get(i).getX(), sourceFrames.get(i).getY(), 96, 96);
                g = targetImage.getGraphics();
                g.drawImage(overlay, targetFrames.get(i).getX(), targetFrames.get(i).getY(), null);
                g.dispose();

            }

            ImageIO.write(targetImage, "PNG", targetFile);

        } catch (IOException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewIcon(String targetMap, String sourceMap, Frame sourceFrame, Frame targetFrame) {
        try {
            File targetFile = new File(targetMap);
            BufferedImage targetImage = ImageIO.read(targetFile);
            BufferedImage sourceImage = ImageIO.read(new File(sourceMap));

            if (targetImage.getHeight() <= (targetFrame.getY() + 96)) {
                BufferedImage resized = new BufferedImage(targetImage.getWidth(), targetImage.getHeight() + 96, BufferedImage.TYPE_INT_ARGB);
                Graphics g = resized.getGraphics();
                g.drawImage(targetImage, 0, 0, null);
                g.dispose();
                ImageIO.write(resized, "PNG", targetFile);
                targetImage = ImageIO.read(targetFile);
            }

            BufferedImage overlay = sourceImage.getSubimage(sourceFrame.getX(), sourceFrame.getY(), 96, 96);
            Graphics g = targetImage.getGraphics();
            g.drawImage(overlay, targetFrame.getX(), targetFrame.getY(), null);
            g.dispose();
            ImageIO.write(targetImage, "PNG", targetFile);

        } catch (IOException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewIcon(String map, String icon, Frame frame) {
        try {
            File iconmap = new File(map);
            BufferedImage image = ImageIO.read(iconmap);
            if (image.getHeight() <= (frame.getY() + 96)) {
                BufferedImage resized = new BufferedImage(image.getWidth(), image.getHeight() + 96, BufferedImage.TYPE_INT_ARGB);
                Graphics g = resized.getGraphics();
                g.drawImage(image, 0, 0, null);
                g.dispose();
                ImageIO.write(resized, "PNG", iconmap);
                image = ImageIO.read(iconmap);
            }
            BufferedImage overlay = ImageIO.read(new File(icon)).getSubimage(0,0,96,96);
            Graphics g = image.getGraphics();
            g.drawImage(overlay, frame.getX(), frame.getY(), null);
            g.dispose();
            ImageIO.write(image, "PNG", iconmap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
