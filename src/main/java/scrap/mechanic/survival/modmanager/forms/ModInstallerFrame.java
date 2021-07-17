package scrap.mechanic.survival.modmanager.forms;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import scrap.mechanic.survival.modmanager.tools.OpenFileDialog;
import scrap.mechanic.survival.modmanager.tools.config.ScrapToolsConfigController;
import scrap.mechanic.survival.modmanager.tools.modinstaller.SurvivalModManagementController;
import scrap.mechanic.survival.modmanager.tools.modinstaller.entity.Mod;

public class ModInstallerFrame extends javax.swing.JFrame {

  public enum VIEW {
    CONFIG, MODINSTALLER
  }

  private VIEW currentView = VIEW.CONFIG;

  private ScrapToolsConfigController configController;
  private SurvivalModManagementController survivalModManagementController;

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
      jImagePanel_settings.setBackgroundImage(ImageIO.read(new File("./src/main/resources/bg_title.png")));
      jImagePanel_modinstaller.setBackgroundImage(ImageIO.read(new File("./src/main/resources/bg_installer.png")));
      
      configController = ScrapToolsConfigController.findInstance();
      survivalModManagementController = new SurvivalModManagementController();
      
      
      jlabel_pathtoscrapfolder.setText(configController.getPathToScrapmechanic());
      jLabel_pathtomodmanager.setText(configController.getPathToScrapToolFolder());
      
      jScrollPane1.setOpaque(false);
      jScrollPane2.setOpaque(false);
      jScrollPane1.getViewport().setOpaque(false);
      jScrollPane2.getViewport().setOpaque(false);
      jList_known_Mods.setBackground(new Color(jList_known_Mods.getBackground().getRed(), jList_known_Mods.getBackground().getGreen(), jList_known_Mods.getBackground().getBlue(), 85));
      jList_known_Mods.addListSelectionListener((ListSelectionEvent e) -> { mainpanel.updateUI();});
      jList_installed_Mods.setBackground(new Color(jList_installed_Mods.getBackground().getRed(), jList_installed_Mods.getBackground().getGreen(), jList_installed_Mods.getBackground().getBlue(), 85));
      jList_installed_Mods.addListSelectionListener((ListSelectionEvent e) -> { mainpanel.updateUI();});
      
      
      initLog();
      updateView();
    } catch (IOException ignore) {
      LOGGER.warn(null, ignore);
    }
  }
  
  private void initLog(){
    File logfile = new File("debug-log.out");
    timer = new Timer(250, (ActionEvent e) -> {
      if (logfile.exists()) {
        try {
          jTextArea_Log.read(new FileReader(logfile), null);
        } catch (IOException ioe) {
          LOGGER.warn("Can´t read logfile");
        }        
      }
    });    
    LOGGER.info("Logger initialized.");
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
    jScrollPane3 = new javax.swing.JScrollPane();
    jTextArea_Log = new javax.swing.JTextArea();
    jButton_install_known_mod = new javax.swing.JButton();
    jButton_uninstall_mod = new javax.swing.JButton();
    jPanel1 = new javax.swing.JPanel();
    jButton_find_mods = new javax.swing.JButton();
    jButton_remove_known_mod = new javax.swing.JButton();
    jButton_find_workshop_mods = new javax.swing.JButton();
    jButton_restore_gamefiles = new javax.swing.JButton();
    jButton7 = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new java.awt.Dimension(1434, 876));

    mainpanel.setPreferredSize(new java.awt.Dimension(1434, 807));
    mainpanel.setSize(new java.awt.Dimension(1434, 807));

    jTabbedPane.setMinimumSize(new java.awt.Dimension(1434, 836));
    jTabbedPane.setPreferredSize(new java.awt.Dimension(1434, 836));
    jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jTabbedPaneStateChanged(evt);
      }
    });

    jImagePanel_settings.setMinimumSize(new java.awt.Dimension(1434, 807));
    jImagePanel_settings.setPreferredSize(new java.awt.Dimension(1434, 807));

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
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jImagePanel_settingsLayout.createSequentialGroup()
        .addContainerGap(490, Short.MAX_VALUE)
        .addGroup(jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(306, 306, 306))
          .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
            .addComponent(jButton_ofd_pathtoscrapmechanic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jlabel_pathtoscrapfolder, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jImagePanel_settingsLayout.createSequentialGroup()
            .addComponent(jButton_ofd_pathtomodscrap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel_pathtomodmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(362, 362, 362))
    );
    jImagePanel_settingsLayout.setVerticalGroup(
      jImagePanel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jImagePanel_settingsLayout.createSequentialGroup()
        .addContainerGap(444, Short.MAX_VALUE)
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
        .addGap(210, 210, 210))
    );

    jTabbedPane.addTab("settings", jImagePanel_settings);

    jImagePanel_modinstaller.setMinimumSize(new java.awt.Dimension(1434, 807));
    jImagePanel_modinstaller.setPreferredSize(new java.awt.Dimension(1434, 807));
    jImagePanel_modinstaller.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jList_known_Mods.setFont(new java.awt.Font("Dialog", 3, 13)); // NOI18N
    jList_known_Mods.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(jList_known_Mods);

    jImagePanel_modinstaller.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 80, 310, 450));

    jList_installed_Mods.setFont(new java.awt.Font("Dialog", 3, 13)); // NOI18N
    jList_installed_Mods.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane2.setViewportView(jList_installed_Mods);

    jImagePanel_modinstaller.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 310, 450));

    jScrollPane3.setMinimumSize(new java.awt.Dimension(1410, 196));
    jScrollPane3.setPreferredSize(new java.awt.Dimension(1395, 196));
    jScrollPane3.setRequestFocusEnabled(false);

    jTextArea_Log.setColumns(20);
    jTextArea_Log.setRows(5);
    jScrollPane3.setViewportView(jTextArea_Log);

    jImagePanel_modinstaller.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 601, -1, -1));

    jButton_install_known_mod.setText(">>>");
    jButton_install_known_mod.setToolTipText("install selected mod");
    jButton_install_known_mod.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_install_known_modActionPerformed(evt);
      }
    });
    jImagePanel_modinstaller.add(jButton_install_known_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 52, 25));

    jButton_uninstall_mod.setText("<<<");
    jButton_uninstall_mod.setToolTipText("uninstall mod");
    jButton_uninstall_mod.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_uninstall_modActionPerformed(evt);
      }
    });
    jImagePanel_modinstaller.add(jButton_uninstall_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 290, 52, 25));

    jPanel1.setBackground(new java.awt.Color(151, 151, 155));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jImagePanel_modinstaller.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 1255, -1));

    jButton_find_mods.setText("find mods");
    jButton_find_mods.setToolTipText("adding new downloaded mod to known mod list");
    jButton_find_mods.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_find_modsActionPerformed(evt);
      }
    });
    jImagePanel_modinstaller.add(jButton_find_mods, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 90, 25));

    jButton_remove_known_mod.setText("remove mods");
    jButton_remove_known_mod.setToolTipText("remove selected from known mods");
    jButton_remove_known_mod.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_remove_known_modActionPerformed(evt);
      }
    });
    jImagePanel_modinstaller.add(jButton_remove_known_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, 100, 25));

    jButton_find_workshop_mods.setText("find (steam)");
    jButton_find_workshop_mods.setToolTipText("automated search of downloaded workshop mods");
    jImagePanel_modinstaller.add(jButton_find_workshop_mods, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 540, 100, 25));

    jButton_restore_gamefiles.setText("restore gamefiles");
    jButton_restore_gamefiles.setToolTipText("restores original gamefiles from backupfolder");
    jButton_restore_gamefiles.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton_restore_gamefilesActionPerformed(evt);
      }
    });
    jImagePanel_modinstaller.add(jButton_restore_gamefiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 540, 153, 25));

    jButton7.setText("not yet needed");
    jImagePanel_modinstaller.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 540, 150, 25));

    jLabel2.setFont(new java.awt.Font("Ebrima", 3, 16)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("known mods");
    jImagePanel_modinstaller.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 300, -1));

    jLabel4.setFont(new java.awt.Font("Ebrima", 3, 16)); // NOI18N
    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setText("installed mods");
    jImagePanel_modinstaller.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 300, -1));

    jTabbedPane.addTab("survival mod installer", jImagePanel_modinstaller);

    javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
    mainpanel.setLayout(mainpanelLayout);
    mainpanelLayout.setHorizontalGroup(
      mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    mainpanelLayout.setVerticalGroup(
      mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton_ofd_pathtoscrapmechanicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ofd_pathtoscrapmechanicActionPerformed
    String path = new OpenFileDialog().openDirectoryDialog("select scrap mechanics game directory", null);
    configController.setPathToScrapmechanic(path);
    jlabel_pathtoscrapfolder.setText(configController.getPathToScrapmechanic());
    jLabel_pathtomodmanager.setText(configController.getPathToScrapToolFolder());
    updateView();
    configController.update();
  }//GEN-LAST:event_jButton_ofd_pathtoscrapmechanicActionPerformed

  private void jButton_ofd_pathtomodscrapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ofd_pathtomodscrapActionPerformed
    String path = new OpenFileDialog().openDirectoryDialog("select scrap mechanics mod manager directory", null);
    configController.setPathToScrapToolFolder(path);
    jlabel_pathtoscrapfolder.setText(configController.getPathToScrapmechanic());
    jLabel_pathtomodmanager.setText(configController.getPathToScrapToolFolder());
    updateView();
    configController.update();
  }//GEN-LAST:event_jButton_ofd_pathtomodscrapActionPerformed

  private void jButton_find_modsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_find_modsActionPerformed
    String path = new OpenFileDialog().openDirectoryDialog("select mod folder", null);
    List<Mod> newMods = survivalModManagementController.findSurvivalMods(path, null);
    showDialog(createfoundModsDialogPanel(newMods),newMods.size() + " mods found:");
  }//GEN-LAST:event_jButton_find_modsActionPerformed

  private void jButton_remove_known_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_remove_known_modActionPerformed
    survivalModManagementController.removeKnownMod(jList_known_Mods.getSelectedValue());
    updateView();
  }//GEN-LAST:event_jButton_remove_known_modActionPerformed

  private void jTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneStateChanged
    switch(jTabbedPane.getSelectedIndex()){
      case 0:{        
        if(currentView != VIEW.CONFIG)changeView(VIEW.CONFIG);
        break;
      }
      case 1:{
        if(currentView != VIEW.MODINSTALLER)changeView(VIEW.MODINSTALLER);
        break;
      }
    }
  }//GEN-LAST:event_jTabbedPaneStateChanged

  private void jButton_install_known_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_install_known_modActionPerformed
    survivalModManagementController.installMod(jList_known_Mods.getSelectedValue());
    updateView();
  }//GEN-LAST:event_jButton_install_known_modActionPerformed

  private void jButton_uninstall_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_uninstall_modActionPerformed
     throw new UnsupportedOperationException("TODO");
  }//GEN-LAST:event_jButton_uninstall_modActionPerformed

  private void jButton_restore_gamefilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_restore_gamefilesActionPerformed
    survivalModManagementController.resetGame();
    updateView();
  }//GEN-LAST:event_jButton_restore_gamefilesActionPerformed

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
    if(newView == currentView){
      return;
    }
    switch(newView){
      case CONFIG:
        if(jImagePanel_settings.isEnabled()){
          jTabbedPane.setSelectedIndex(0);
          currentView = newView;
          timer.stop();
        }
        break;
      case MODINSTALLER:
        if(jImagePanel_modinstaller.isEnabled()){
          jTabbedPane.setSelectedIndex(1);
          currentView = newView;
          timer.start();
        }
        break;
      default:
        throw new AssertionError(newView.name());
      
    }
    updateView();
  }

  private void updateView() {
    if (!configController.isConfigured()) {
      jTabbedPane.setEnabled(false);
      if (!currentView.equals(VIEW.CONFIG)) {
        changeView(VIEW.CONFIG);
      }
    } else {
      jTabbedPane.setEnabled(true);
      jList_known_Mods.setListData(survivalModManagementController.getKnownMods());
      jList_installed_Mods.setListData(survivalModManagementController.getInstalledMods());
    }
        
    mainpanel.updateUI();
    configController.update();
  }
  
  private JPanel createfoundModsDialogPanel(List<Mod> mods){
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 0.5;
    gbc.gridx = 0;
    gbc.gridy = 0;
    
    Color c = Color.red;
    for (Mod mod : mods) {
      JLabel l1 = new JLabel("Name:    " +mod.getName());
      JCheckBox l2 =new JCheckBox("install", true);
      JLabel l3 = new JLabel("Path:    " +mod.getSourcePath());
           
      panel.add(l1,gbc);      
      gbc.gridx = gbc.gridx + 1;
      panel.add(l2,gbc);
      
      gbc.gridx = 0;
      gbc.gridy = gbc.gridy + 1;
      panel.add(l3,gbc);
      gbc.gridy = gbc.gridy + 1;
      
    }
    
    JButton ok = new JButton("ok");
    JButton abort = new JButton("abort");
    gbc.gridx = 0;    
    gbc.weightx = 1;
    JPanel p = new JPanel();
    p.add(abort);
    p.add(ok);
    panel.add(p,gbc);
    return panel;
  }
  /*
  for (Mod mod : mods) {
      JPanel box = new JPanel();
      box.setBackground(c);
      c = Color.BLUE;
      GroupLayout innerGl = new GroupLayout(box);  
      innerGl.setAutoCreateGaps(true);  
      innerGl.setAutoCreateContainerGaps(true);  
      box.setLayout(innerGl);
      JLabel l1 = new JLabel("Name: " +mod.getName());
      JCheckBox l2 =new JCheckBox("install", true);
      JLabel l3 = new JLabel("Path: " +mod.getSourcePath());
      innerGl.setHorizontalGroup(innerGl.createSequentialGroup()  
              .addGroup(innerGl.createParallelGroup(LEADING).addComponent(l1).addComponent(l3))  
              .addGroup(innerGl.createParallelGroup(TRAILING).addComponent(l2)));  

      innerGl.setVerticalGroup(innerGl.createSequentialGroup()  
              .addGroup(innerGl.createParallelGroup(BASELINE).addComponent(l1).addComponent(l2))  
              .addGroup(innerGl.createParallelGroup(BASELINE).addComponent(l3)));
      panel.add(box,gbc);
      gbc.gridy = gbc.gridy + 1;
    }
  */
  
  private void showDialog(JPanel panel, String titel){
    JDialog dialog = new JDialog(this, titel, true);
    dialog.getContentPane().add(panel);
    dialog.pack();
    dialog.setVisible(true);
  }

  public VIEW getCurrentView() {
    return currentView;
  }

  public void setCurrentView(VIEW currentView) {
    this.currentView = currentView;
  }


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton7;
  private javax.swing.JButton jButton_find_mods;
  private javax.swing.JButton jButton_find_workshop_mods;
  private javax.swing.JButton jButton_install_known_mod;
  private javax.swing.JButton jButton_ofd_pathtomodscrap;
  private javax.swing.JButton jButton_ofd_pathtoscrapmechanic;
  private javax.swing.JButton jButton_remove_known_mod;
  private javax.swing.JButton jButton_restore_gamefiles;
  private javax.swing.JButton jButton_uninstall_mod;
  private scrap.mechanic.survival.modmanager.forms.JImagePanel jImagePanel_modinstaller;
  private scrap.mechanic.survival.modmanager.forms.JImagePanel jImagePanel_settings;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel_pathtomodmanager;
  private javax.swing.JList<String> jList_installed_Mods;
  private javax.swing.JList<String> jList_known_Mods;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTabbedPane jTabbedPane;
  private javax.swing.JTextArea jTextArea_Log;
  private javax.swing.JLabel jlabel_pathtoscrapfolder;
  private scrap.mechanic.survival.modmanager.forms.JImagePanel mainpanel;
  // End of variables declaration//GEN-END:variables
}
