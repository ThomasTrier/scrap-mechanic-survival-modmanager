package scrap.mechanic.survival.modmanager.forms;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import scrap.mechanic.survival.modmanager.tools.OpenFileDialog;
import scrap.mechanic.survival.modmanager.tools.config.ScrapToolsConfigController;

public class ModInstallerFrame extends javax.swing.JFrame {

  public enum VIEW {
    CONFIG, MODINSTALLER
  }

  private VIEW currentView = VIEW.CONFIG;

  private ScrapToolsConfigController configController;

  private Logger LOGGER = Logger.getLogger(getClass().getName());
  private Timer timer;

  public ModInstallerFrame() {
    try {
      UIManager.setLookAndFeel(new HiFiLookAndFeel());
    } catch (UnsupportedLookAndFeelException e) {
      LOGGER.warn(null, e);
    }
    initComponents();
    try {
      this.setResizable(false);
      jImagePanel_settings.setBackgroundImage(ImageIO.read(new File("./src/main/resources/titel.png")));
      jImagePanel_modinstaller.setBackgroundImage(ImageIO.read(new File("./src/main/resources/bg.png")));
      configController = new ScrapToolsConfigController();      
      jlabel_pathtoscrapfolder.setText(configController.getConfig().getPathToScrapmechanic());
      jLabel_pathtomodmanager.setText(configController.getConfig().getPathToScrapToolFolder());
      
      jScrollPane1.setOpaque(false);
      jScrollPane2.setOpaque(false);
      jScrollPane1.getViewport().setOpaque(false);
      jScrollPane2.getViewport().setOpaque(false);
      jList_known_Mods.setBackground(new Color(jList_known_Mods.getBackground().getRed(), jList_known_Mods.getBackground().getGreen(), jList_known_Mods.getBackground().getBlue(), 85));
      jList_known_Mods.addListSelectionListener((ListSelectionEvent e) -> { mainpanel.updateUI();});
      jList_installed_Mods.setBackground(new Color(jList_installed_Mods.getBackground().getRed(), jList_installed_Mods.getBackground().getGreen(), jList_installed_Mods.getBackground().getBlue(), 85));
      jList_installed_Mods.addListSelectionListener((ListSelectionEvent e) -> { mainpanel.updateUI();});
      updateView();
    } catch (IOException ignore) {
      LOGGER.warn(null, ignore);
    }
  }
  
  private void initLog(){
    File logfile = new File("debug-log.out");
    timer = new Timer(100, (ActionEvent e) -> {
      if (logfile.exists()) {
        try {
          FileReader reader = new FileReader(logfile);
//          jTextArea_logarea.read(reader, null);
        } catch (IOException ioe) {
          LOGGER.warn("Can´t read logfile");
        }
        
      }
    });
    timer.start();
  }
  
  private void showLog(){
//    jTextArea_logarea.setVisible(true);
    if(timer != null){
      timer.start();
    }else{
      initLog();
    }
  }
  
  private void hideLog(){
//    jTextArea_logarea.setVisible(false);
    if(timer != null){
      timer.stop();
    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mainpanel = new scrap.mechanic.survival.modmanager.forms.JImagePanel();
    jTabbedPane = new javax.swing.JTabbedPane();
    jImagePanel_settings = new scrap.mechanic.survival.modmanager.forms.JImagePanel();
    jLabel1 = new javax.swing.JLabel();
    jButton_ofd_pathtoscrapmechanic = new javax.swing.JButton();
    jlabel_pathtoscrapfolder = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jButton_ofd_pathtomodscrap = new javax.swing.JButton();
    jLabel_pathtomodmanager = new javax.swing.JLabel();
    jImagePanel_modinstaller = new scrap.mechanic.survival.modmanager.forms.JImagePanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jList_known_Mods = new javax.swing.JList<>();
    jScrollPane2 = new javax.swing.JScrollPane();
    jList_installed_Mods = new javax.swing.JList<>();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    mainpanel.setSize(new java.awt.Dimension(1024, 768));

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Path to \"Scrap Mechanic\" game folder:");

    jButton_ofd_pathtoscrapmechanic.setText("...");
    jButton_ofd_pathtoscrapmechanic.setOpaque(false);
    jButton_ofd_pathtoscrapmechanic.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_ofd_pathtoscrapmechanicActionPerformed(evt);
      }
    });

    jlabel_pathtoscrapfolder.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
    jlabel_pathtoscrapfolder.setForeground(new java.awt.Color(0, 0, 0));
    jlabel_pathtoscrapfolder.setText("jLabel2");

    jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Path to Mod-Manager data folder:");

    jButton_ofd_pathtomodscrap.setText("...");
    jButton_ofd_pathtomodscrap.setOpaque(false);
    jButton_ofd_pathtomodscrap.setRequestFocusEnabled(false);
    jButton_ofd_pathtomodscrap.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_ofd_pathtomodscrapActionPerformed(evt);
      }
    });

    jLabel_pathtomodmanager.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
    jLabel_pathtomodmanager.setForeground(new java.awt.Color(0, 0, 0));
    jLabel_pathtomodmanager.setText("jLabel4");

    javax.swing.GroupLayout jImagePanel_settingsLayout = new javax.swing.GroupLayout(jImagePanel_settings);
    jImagePanel_settings.setLayout(jImagePanel_settingsLayout);
    jImagePanel_settingsLayout.setHorizontalGroup(
      jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
        .addContainerGap(687, Short.MAX_VALUE)
        .addGroup(jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
            .addGroup(jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel1))
            .addGap(318, 318, 318))
          .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
            .addGroup(jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
                .addComponent(jButton_ofd_pathtoscrapmechanic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_pathtoscrapfolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
                .addComponent(jButton_ofd_pathtomodscrap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_pathtomodmanager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap())))
    );
    jImagePanel_settingsLayout.setVerticalGroup(
      jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
        .addGap(135, 135, 135)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jlabel_pathtoscrapfolder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton_ofd_pathtoscrapmechanic))
        .addGap(42, 42, 42)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton_ofd_pathtomodscrap)
          .addComponent(jLabel_pathtomodmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(519, Short.MAX_VALUE))
    );

    jTabbedPane.addTab("settings", jImagePanel_settings);

    jList_known_Mods.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(jList_known_Mods);

    jList_installed_Mods.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane2.setViewportView(jList_installed_Mods);

    javax.swing.GroupLayout jImagePanel_modinstallerLayout = new javax.swing.GroupLayout(jImagePanel_modinstaller);
    jImagePanel_modinstaller.setLayout(jImagePanel_modinstallerLayout);
    jImagePanel_modinstallerLayout.setHorizontalGroup(
      jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jImagePanel_modinstallerLayout.createSequentialGroup()
        .addGap(178, 178, 178)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(172, 172, 172))
    );
    jImagePanel_modinstallerLayout.setVerticalGroup(
      jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jImagePanel_modinstallerLayout.createSequentialGroup()
        .addGap(83, 83, 83)
        .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(298, Short.MAX_VALUE))
    );

    jTabbedPane.addTab("survival mod installer", jImagePanel_modinstaller);

    javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
    mainpanel.setLayout(mainpanelLayout);
    mainpanelLayout.setHorizontalGroup(
      mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane)
    );
    mainpanelLayout.setVerticalGroup(
      mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane)
    );

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
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ModInstallerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    File logfile = new File("debug-log.out");
        if (logfile.exists()) {
            logfile.delete();
        }
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    
    //</editor-fold>
    
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
    switch(newView){
      case CONFIG:
        if(jImagePanel_settings.isEnabled()){
          jTabbedPane.setSelectedIndex(0);
        }
        break;
      case MODINSTALLER:
        if(jImagePanel_modinstaller.isEnabled()){
          jTabbedPane.setSelectedIndex(1);
        }
        break;
      default:
        throw new AssertionError(newView.name());
      
    }
    updateView();
  }

  private void updateView() {
    if (!configController.isConfigured()) {
      jImagePanel_modinstaller.setEnabled(false);
      if (!currentView.equals(VIEW.CONFIG)) {
        changeView(VIEW.CONFIG);
      }
    } else {
      jImagePanel_modinstaller.setEnabled(false);
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
  private scrap.mechanic.survival.modmanager.forms.JImagePanel jImagePanel_modinstaller;
  private scrap.mechanic.survival.modmanager.forms.JImagePanel jImagePanel_settings;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel_pathtomodmanager;
  private javax.swing.JList<String> jList_installed_Mods;
  private javax.swing.JList<String> jList_known_Mods;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTabbedPane jTabbedPane;
  private javax.swing.JLabel jlabel_pathtoscrapfolder;
  private scrap.mechanic.survival.modmanager.forms.JImagePanel mainpanel;
  // End of variables declaration//GEN-END:variables
}
