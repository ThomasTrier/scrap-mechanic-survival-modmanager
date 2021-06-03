package scrap.mechanic.survival.modmanager.forms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class JImagePanel extends JPanel {

  private Image image;

  public JImagePanel() {
    super();
  }

  public JImagePanel(boolean isDoubleBuffered) {
    super(isDoubleBuffered);
  }

  public JImagePanel(LayoutManager layout) {
    super(layout);
  }

  public JImagePanel(LayoutManager layout, boolean isDoubleBuffered) {
    super(layout, isDoubleBuffered);
  }

  public void setBackgroundImage(Image image) {
    try {
      this.image = resizeImage(image, this.getWidth() , this.getHeight());
      repaint();
    } catch (IOException ex) {
      Logger.getLogger(JImagePanel.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private Image resizeImage(Image originalImage, int targetWidth, int targetHeight) throws IOException {
    BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = resizedImage.createGraphics();
    graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
    graphics2D.dispose();
    return resizedImage;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image != null) {
      g.drawImage(image, 0, 0, this);
    }
  }

}
