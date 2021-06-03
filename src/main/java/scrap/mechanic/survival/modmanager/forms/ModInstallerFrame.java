package scrap.mechanic.survival.modmanager.forms;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import scrap.mechanic.survival.modmanager.tools.OpenFileDialog;
import scrap.mechanic.survival.modmanager.tools.config.ScrapToolsConfigController;

public class ModInstallerFrame extends javax.swing.JFrame {

  public enum VIEW {
    CONFIG, MODINSTALLER
  }

  private VIEW currentView = VIEW.CONFIG;

  private ScrapToolsConfigController configController;

  private Logger logger = Logger.getLogger(getClass().getName());

  public ModInstallerFrame() {
    try {
      UIManager.setLookAndFeel(new HiFiLookAndFeel());
    } catch (UnsupportedLookAndFeelException e) {
      logger.log(Level.SEVERE, null, e);
    }
    initComponents();
    try {
      mainpanel.setBackgroundImage(ImageIO.read(new File("./src/main/resources/bg_beta1.jpg")));
      configController = new ScrapToolsConfigController();
      jlabel_pathtoscrapfolder.setText(configController.getConfig().getPathToScrapmechanic());
      jLabel_pathtomodmanager.setText(configController.getConfig().getPathToScrapToolFolder());
      updateView();
    } catch (Exception ignore) {

    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTabbedPane1 = new javax.swing.JTabbedPane();
    mainpanel = new scrap.mechanic.survival.modmanager.forms.JImagePanel();
    jlabel_label_pathtoscrapfolder = new javax.swing.JLabel();
    jlabel_pathtoscrapfolder = new javax.swing.JLabel();
    jLabel_label_pathtomodmanager = new javax.swing.JLabel();
    jLabel_pathtomodmanager = new javax.swing.JLabel();
    jButton_ofd_pathtoscrapmechanic = new javax.swing.JButton();
    jButton_ofd_pathtomodscrap = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu_modinstaller = new javax.swing.JMenu();
    jMenuItem_modinstaller = new javax.swing.JMenuItem();
    jMenu_settings = new javax.swing.JMenu();
    jMenuItem_editsettings = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    mainpanel.setSize(new java.awt.Dimension(1024, 768));

    jlabel_label_pathtoscrapfolder.setText("Path to \"Scrap Mechanic\" game folder:");

    jlabel_pathtoscrapfolder.setText("jLabel2");

    jLabel_label_pathtomodmanager.setText("Path to Mod-Manager data folder:");

    jLabel_pathtomodmanager.setText("jLabel4");

    jButton_ofd_pathtoscrapmechanic.setText("...");
    jButton_ofd_pathtoscrapmechanic.setOpaque(false);
    jButton_ofd_pathtoscrapmechanic.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_ofd_pathtoscrapmechanicActionPerformed(evt);
      }
    });

    jButton_ofd_pathtomodscrap.setText("...");
    jButton_ofd_pathtomodscrap.setOpaque(false);
    jButton_ofd_pathtomodscrap.setRequestFocusEnabled(false);
    jButton_ofd_pathtomodscrap.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_ofd_pathtomodscrapActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
    mainpanel.setLayout(mainpanelLayout);
    mainpanelLayout.setHorizontalGroup(
      mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainpanelLayout.createSequentialGroup()
        .addGap(54, 54, 54)
        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(mainpanelLayout.createSequentialGroup()
            .addComponent(jlabel_label_pathtoscrapfolder)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton_ofd_pathtoscrapmechanic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jlabel_pathtoscrapfolder, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel_pathtomodmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(mainpanelLayout.createSequentialGroup()
            .addComponent(jLabel_label_pathtomodmanager)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton_ofd_pathtomodscrap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    mainpanelLayout.setVerticalGroup(
      mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
        .addContainerGap(752, Short.MAX_VALUE)
        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(mainpanelLayout.createSequentialGroup()
            .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel_label_pathtomodmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton_ofd_pathtomodscrap))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel_pathtomodmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(mainpanelLayout.createSequentialGroup()
            .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jlabel_label_pathtoscrapfolder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton_ofd_pathtoscrapmechanic))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jlabel_pathtoscrapfolder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(23, 23, 23))
    );

    jMenu_modinstaller.setText("tools");

    jMenuItem_modinstaller.setText("survival mod installer");
    jMenuItem_modinstaller.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem_modinstallerActionPerformed(evt);
      }
    });
    jMenu_modinstaller.add(jMenuItem_modinstaller);

    jMenuBar1.add(jMenu_modinstaller);

    jMenu_settings.setText("settings");

    jMenuItem_editsettings.setText("open settings");
    jMenuItem_editsettings.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem_editsettingsActionPerformed(evt);
      }
    });
    jMenu_settings.add(jMenuItem_editsettings);

    jMenuBar1.add(jMenu_settings);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItem_modinstallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_modinstallerActionPerformed
    changeView(VIEW.MODINSTALLER);
  }//GEN-LAST:event_jMenuItem_modinstallerActionPerformed

  private void jMenuItem_editsettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_editsettingsActionPerformed
    changeView(VIEW.CONFIG);
  }//GEN-LAST:event_jMenuItem_editsettingsActionPerformed

  private void jButton_ofd_pathtoscrapmechanicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ofd_pathtoscrapmechanicActionPerformed
    String path = new OpenFileDialog().openDirectoryDialog("select scrap mechanics game directory", null);
    configController.getConfig().setPathToScrapmechanic(path);
    jlabel_pathtoscrapfolder.setText(configController.getConfig().getPathToScrapmechanic());
    jLabel_pathtomodmanager.setText(configController.getConfig().getPathToScrapToolFolder());
    updateView();
  }//GEN-LAST:event_jButton_ofd_pathtoscrapmechanicActionPerformed

  private void jButton_ofd_pathtomodscrapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ofd_pathtomodscrapActionPerformed
    String path = new OpenFileDialog().openDirectoryDialog("select scrap mechanics mod manager directory", null);
    configController.getConfig().setPathToScrapToolFolder(path);
    jlabel_pathtoscrapfolder.setText(configController.getConfig().getPathToScrapmechanic());
    jLabel_pathtomodmanager.setText(configController.getConfig().getPathToScrapToolFolder());
    updateView();
  }//GEN-LAST:event_jButton_ofd_pathtomodscrapActionPerformed

  public static void main(String args[]) {
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(ModInstallerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ModInstallerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ModInstallerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ModInstallerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ModInstallerFrame().setVisible(true);
      }
    });
  }

  public ScrapToolsConfigController getConfigController() {
    return configController;
  }

  public void setConfigController(ScrapToolsConfigController configController) {
    this.configController = configController;
  }

  public void changeView(VIEW newView) {
    this.currentView = newView;
    updateView();
  }

  private void updateView() {
    if (!configController.isConfigured()) {
      jMenuItem_modinstaller.setEnabled(false);
      if (!currentView.equals(VIEW.CONFIG)) {
        changeView(VIEW.CONFIG);
      }
    } else {
      jMenuItem_modinstaller.setEnabled(true);
    }
    
    switch(currentView){
      case CONFIG:
      {
        jLabel_label_pathtomodmanager.setVisible(true);
        jlabel_label_pathtoscrapfolder.setVisible(true);
        jLabel_pathtomodmanager.setVisible(true);
        jlabel_pathtoscrapfolder.setVisible(true);
        jButton_ofd_pathtomodscrap.setVisible(true);
        jButton_ofd_pathtoscrapmechanic.setVisible(true);
        break;
      }
      case MODINSTALLER:
      {
        jLabel_label_pathtomodmanager.setVisible(false);
        jlabel_label_pathtoscrapfolder.setVisible(false);
        jLabel_pathtomodmanager.setVisible(false);
        jlabel_pathtoscrapfolder.setVisible(false);
        jButton_ofd_pathtomodscrap.setVisible(false);
        jButton_ofd_pathtoscrapmechanic.setVisible(false);
        break;
      }
      default:
        throw new AssertionError(currentView.name());      
    } 
    
    
    mainpanel.updateUI();
    configController.update();
  }

  public VIEW getCurrentView() {
    return currentView;
  }

  public void setCurrentView(VIEW currentView) {
    this.currentView = currentView;
  }


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton_ofd_pathtomodscrap;
  private javax.swing.JButton jButton_ofd_pathtoscrapmechanic;
  private javax.swing.JLabel jLabel_label_pathtomodmanager;
  private javax.swing.JLabel jLabel_pathtomodmanager;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem_editsettings;
  private javax.swing.JMenuItem jMenuItem_modinstaller;
  private javax.swing.JMenu jMenu_modinstaller;
  private javax.swing.JMenu jMenu_settings;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JLabel jlabel_label_pathtoscrapfolder;
  private javax.swing.JLabel jlabel_pathtoscrapfolder;
  private scrap.mechanic.survival.modmanager.forms.JImagePanel mainpanel;
  // End of variables declaration//GEN-END:variables
}
