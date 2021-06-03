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
      jImagePanel_settings.setBackgroundImage(ImageIO.read(new File("./src/main/resources/bg_beta2.jpg")));
      jImagePanel_modinstaller.setBackgroundImage(ImageIO.read(new File("./src/main/resources/bg_beta2.jpg")));
      configController = new ScrapToolsConfigController();      
      jlabel_pathtoscrapfolder.setText(configController.getConfig().getPathToScrapmechanic());
      jLabel_pathtomodmanager.setText(configController.getConfig().getPathToScrapToolFolder());
      
      jScrollPane1.setOpaque(false);
      jScrollPane2.setOpaque(false);
      jScrollPane1.getViewport().setOpaque(false);
      jScrollPane2.getViewport().setOpaque(false);
      jList_KnownMods.setBackground(new Color(jList_KnownMods.getBackground().getRed(), jList_KnownMods.getBackground().getGreen(), jList_KnownMods.getBackground().getBlue(), 85));
      jList_KnownMods.addListSelectionListener((ListSelectionEvent e) -> { mainpanel.updateUI();});
      jList_InstalledMods.setBackground(new Color(jList_KnownMods.getBackground().getRed(), jList_KnownMods.getBackground().getGreen(), jList_KnownMods.getBackground().getBlue(), 85));
      jList_InstalledMods.addListSelectionListener((ListSelectionEvent e) -> { mainpanel.updateUI();});
      hideLog();
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
          jTextArea_logarea.read(reader, null);
        } catch (IOException ioe) {
          LOGGER.warn("Can´t read logfile");
        }
        
      }
    });
    timer.start();
  }
  
  private void showLog(){
    this.setSize(this.getSize().width, 768);
    jTextArea_logarea.setVisible(true);
    jSeparator_logarea.setVisible(true);
    if(timer != null){
      timer.start();
    }else{
      initLog();
    }
  }
  
  private void hideLog(){
    jTextArea_logarea.setVisible(false);
    jSeparator_logarea.setVisible(false);
    this.setSize(this.getSize().width, 600);
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
    jList_KnownMods = new javax.swing.JList<>();
    jScrollPane2 = new javax.swing.JScrollPane();
    jList_InstalledMods = new javax.swing.JList<>();
    jLabel_label_knownmods = new javax.swing.JLabel();
    jLabel_label_installedmods = new javax.swing.JLabel();
    jSeparator_logarea = new javax.swing.JSeparator();
    jButton_addKnownMod = new javax.swing.JButton();
    jButton_subKnownMod = new javax.swing.JButton();
    jButton_mergeKnownMods = new javax.swing.JButton();
    jButton_installknownmod = new javax.swing.JButton();
    jButton_uninstallmod = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTextArea_logarea = new javax.swing.JTextArea();
    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    mainpanel.setSize(new java.awt.Dimension(1024, 768));

    jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Path to \"Scrap Mechanic\" game folder:");

    jButton_ofd_pathtoscrapmechanic.setText("...");
    jButton_ofd_pathtoscrapmechanic.setOpaque(false);
    jButton_ofd_pathtoscrapmechanic.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_ofd_pathtoscrapmechanicActionPerformed(evt);
      }
    });

    jlabel_pathtoscrapfolder.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    jlabel_pathtoscrapfolder.setForeground(new java.awt.Color(0, 0, 0));
    jlabel_pathtoscrapfolder.setText("jLabel2");

    jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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

    jLabel_pathtomodmanager.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    jLabel_pathtomodmanager.setForeground(new java.awt.Color(0, 0, 0));
    jLabel_pathtomodmanager.setText("jLabel4");

    javax.swing.GroupLayout jImagePanel_settingsLayout = new javax.swing.GroupLayout(jImagePanel_settings);
    jImagePanel_settings.setLayout(jImagePanel_settingsLayout);
    jImagePanel_settingsLayout.setHorizontalGroup(
      jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
            .addComponent(jLabel_pathtomodmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
            .addGroup(jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jlabel_pathtoscrapfolder, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ofd_pathtoscrapmechanic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ofd_pathtomodscrap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(21, 764, Short.MAX_VALUE))))
    );
    jImagePanel_settingsLayout.setVerticalGroup(
      jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton_ofd_pathtoscrapmechanic))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jlabel_pathtoscrapfolder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(27, 27, 27)
        .addGroup(jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton_ofd_pathtomodscrap))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel_pathtomodmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(642, Short.MAX_VALUE))
    );

    jTabbedPane.addTab("settings", jImagePanel_settings);

    jList_KnownMods.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(jList_KnownMods);

    jList_InstalledMods.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane2.setViewportView(jList_InstalledMods);

    jLabel_label_knownmods.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel_label_knownmods.setText("Known mods");

    jLabel_label_installedmods.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel_label_installedmods.setText("installed mods");

    jButton_addKnownMod.setText("add");
    jButton_addKnownMod.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jButton_addKnownMod.setPreferredSize(new java.awt.Dimension(28, 24));
    jButton_addKnownMod.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_addKnownModActionPerformed(evt);
      }
    });

    jButton_subKnownMod.setText("remove");
    jButton_subKnownMod.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jButton_subKnownMod.setPreferredSize(new java.awt.Dimension(28, 24));

    jButton_mergeKnownMods.setText("merge");
    jButton_mergeKnownMods.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jButton_mergeKnownMods.setPreferredSize(new java.awt.Dimension(80, 24));

    jButton_installknownmod.setText(">>");
    jButton_installknownmod.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_installknownmodActionPerformed(evt);
      }
    });

    jButton_uninstallmod.setText("<<");
    jButton_uninstallmod.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_uninstallmodActionPerformed(evt);
      }
    });

    jTextArea_logarea.setColumns(20);
    jTextArea_logarea.setRows(5);
    jScrollPane3.setViewportView(jTextArea_logarea);

    jButton1.setText("show/hide log");

    javax.swing.GroupLayout jImagePanel_modinstallerLayout = new javax.swing.GroupLayout(jImagePanel_modinstaller);
    jImagePanel_modinstaller.setLayout(jImagePanel_modinstallerLayout);
    jImagePanel_modinstallerLayout.setHorizontalGroup(
      jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jSeparator_logarea)
      .addGroup(jImagePanel_modinstallerLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane3)
          .addGroup(jImagePanel_modinstallerLayout.createSequentialGroup()
            .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel_label_knownmods, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jScrollPane1)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jImagePanel_modinstallerLayout.createSequentialGroup()
                .addComponent(jButton_subKnownMod, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton_addKnownMod, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton_mergeKnownMods, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jImagePanel_modinstallerLayout.createSequentialGroup()
                .addComponent(jButton_installknownmod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 583, Short.MAX_VALUE)
                .addComponent(jButton_uninstallmod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jScrollPane2)
                  .addComponent(jLabel_label_installedmods, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jImagePanel_modinstallerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)))))
        .addContainerGap())
    );
    jImagePanel_modinstallerLayout.setVerticalGroup(
      jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jImagePanel_modinstallerLayout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel_label_knownmods)
          .addComponent(jLabel_label_installedmods))
        .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jImagePanel_modinstallerLayout.createSequentialGroup()
            .addGap(147, 147, 147)
            .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jButton_installknownmod)
              .addComponent(jButton_uninstallmod))
            .addGap(192, 192, 192))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jImagePanel_modinstallerLayout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
        .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jImagePanel_modinstallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jButton_subKnownMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton_addKnownMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton_mergeKnownMods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jButton1))
        .addGap(153, 153, 153)
        .addComponent(jSeparator_logarea, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane.addTab("survival mod installer", jImagePanel_modinstaller);

    javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
    mainpanel.setLayout(mainpanelLayout);
    mainpanelLayout.setHorizontalGroup(
      mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE)
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

  private void jButton_addKnownModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addKnownModActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jButton_addKnownModActionPerformed

  private void jButton_uninstallmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_uninstallmodActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jButton_uninstallmodActionPerformed

  private void jButton_installknownmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_installknownmodActionPerformed
    LOGGER.warn("Blahhhh");
  }//GEN-LAST:event_jButton_installknownmodActionPerformed

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
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton_addKnownMod;
  private javax.swing.JButton jButton_installknownmod;
  private javax.swing.JButton jButton_mergeKnownMods;
  private javax.swing.JButton jButton_ofd_pathtomodscrap;
  private javax.swing.JButton jButton_ofd_pathtoscrapmechanic;
  private javax.swing.JButton jButton_subKnownMod;
  private javax.swing.JButton jButton_uninstallmod;
  private scrap.mechanic.survival.modmanager.forms.JImagePanel jImagePanel_modinstaller;
  private scrap.mechanic.survival.modmanager.forms.JImagePanel jImagePanel_settings;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel_label_installedmods;
  private javax.swing.JLabel jLabel_label_knownmods;
  private javax.swing.JLabel jLabel_pathtomodmanager;
  private javax.swing.JList<String> jList_InstalledMods;
  private javax.swing.JList<String> jList_KnownMods;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JSeparator jSeparator_logarea;
  private javax.swing.JTabbedPane jTabbedPane;
  private javax.swing.JTextArea jTextArea_logarea;
  private javax.swing.JLabel jlabel_pathtoscrapfolder;
  private scrap.mechanic.survival.modmanager.forms.JImagePanel mainpanel;
  // End of variables declaration//GEN-END:variables
}
