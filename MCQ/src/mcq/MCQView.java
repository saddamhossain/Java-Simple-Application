/*
 * MCQView.java
 */

package mcq;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.RandomAccessFile;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public class MCQView extends FrameView {

    public MCQView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = MCQApp.getApplication().getMainFrame();
            aboutBox = new MCQAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        MCQApp.getApplication().show(aboutBox);
    }

    @Action
    public void loadQuestion() {
        RandomAccessFile input = null;
        try {
            JFileChooser jfc;
            File file;
            
            jfc = new JFileChooser();
            jfc.showOpenDialog(this.getFrame());

            file = jfc.getSelectedFile();
            input = new RandomAccessFile(file, "r");
            String question, option;
            
            question = input.readLine(); question1.setText(question);
            option = input.readLine(); option11.setText(option);
            option = input.readLine(); option12.setText(option);
            option = input.readLine(); option13.setText(option);
            option = input.readLine(); option14.setText(option);
            
            question = input.readLine(); question2Label.setText(question);
            option = input.readLine(); option21.setText(option);
            option = input.readLine(); option22.setText(option);
            option = input.readLine(); option23.setText(option);
            option = input.readLine(); option24.setText(option);
        
            question = input.readLine(); question3Label.setText(question);
            option = input.readLine(); option31.setText(option);
            option = input.readLine(); option32.setText(option);
            option = input.readLine(); option33.setText(option);
            option = input.readLine(); option34.setText(option);

            question = input.readLine(); question4Label.setText(question);
            option = input.readLine(); option41.setText(option);
            option = input.readLine(); option42.setText(option);
            option = input.readLine(); option43.setText(option);
            option = input.readLine(); option44.setText(option);
        
            statusMessageLabel.setText("Read 4 questions and 16 options from 'question.txt'");
        } catch (NullPointerException nfe) {
            JOptionPane.showMessageDialog(this.getFrame(), 
                "You must select an input file", 
                "Input file missing", 
                JOptionPane.ERROR_MESSAGE);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this.getFrame(), 
                    "Could not find 'question.txt'", 
                    "File not found", 
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MCQView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MCQView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        question1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        marksField = new javax.swing.JTextField();
        option11 = new javax.swing.JRadioButton();
        option12 = new javax.swing.JRadioButton();
        option13 = new javax.swing.JRadioButton();
        option14 = new javax.swing.JRadioButton();
        question2Label = new javax.swing.JLabel();
        question2 = new javax.swing.JLabel();
        option21 = new javax.swing.JRadioButton();
        option22 = new javax.swing.JRadioButton();
        option23 = new javax.swing.JRadioButton();
        option24 = new javax.swing.JRadioButton();
        option34 = new javax.swing.JRadioButton();
        question3Label = new javax.swing.JLabel();
        option33 = new javax.swing.JRadioButton();
        option32 = new javax.swing.JRadioButton();
        option31 = new javax.swing.JRadioButton();
        question3 = new javax.swing.JLabel();
        option44 = new javax.swing.JRadioButton();
        question4Label = new javax.swing.JLabel();
        option43 = new javax.swing.JRadioButton();
        option42 = new javax.swing.JRadioButton();
        option41 = new javax.swing.JRadioButton();
        question4 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        question1group = new javax.swing.ButtonGroup();
        question2group = new javax.swing.ButtonGroup();
        question3group = new javax.swing.ButtonGroup();
        question4group = new javax.swing.ButtonGroup();

        mainPanel.setMaximumSize(new java.awt.Dimension(200, 200));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(200, 200));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(mcq.MCQApp.class).getContext().getResourceMap(MCQView.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        question1.setText(resourceMap.getString("question1.text")); // NOI18N
        question1.setName("question1"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        marksField.setText(resourceMap.getString("marksField.text")); // NOI18N
        marksField.setName("marksField"); // NOI18N

        question1group.add(option11);
        option11.setText(resourceMap.getString("option11.text")); // NOI18N
        option11.setName("option11"); // NOI18N

        question1group.add(option12);
        option12.setText(resourceMap.getString("option12.text")); // NOI18N
        option12.setName("option12"); // NOI18N

        question1group.add(option13);
        option13.setText(resourceMap.getString("option13.text")); // NOI18N
        option13.setName("option13"); // NOI18N

        question1group.add(option14);
        option14.setText(resourceMap.getString("option14.text")); // NOI18N
        option14.setName("option14"); // NOI18N

        question2Label.setText(resourceMap.getString("question2Label.text")); // NOI18N
        question2Label.setName("question2Label"); // NOI18N

        question2.setText(resourceMap.getString("question2.text")); // NOI18N
        question2.setName("question2"); // NOI18N

        question2group.add(option21);
        option21.setText(resourceMap.getString("option21.text")); // NOI18N
        option21.setName("option21"); // NOI18N

        question2group.add(option22);
        option22.setText(resourceMap.getString("option22.text")); // NOI18N
        option22.setName("option22"); // NOI18N

        question2group.add(option23);
        option23.setText(resourceMap.getString("option23.text")); // NOI18N
        option23.setName("option23"); // NOI18N

        question2group.add(option24);
        option24.setText(resourceMap.getString("option24.text")); // NOI18N
        option24.setName("option24"); // NOI18N

        question3group.add(option34);
        option34.setText(resourceMap.getString("option34.text")); // NOI18N
        option34.setName("option34"); // NOI18N

        question3Label.setText(resourceMap.getString("question3Label.text")); // NOI18N
        question3Label.setName("question3Label"); // NOI18N

        question3group.add(option33);
        option33.setText(resourceMap.getString("option33.text")); // NOI18N
        option33.setName("option33"); // NOI18N

        question3group.add(option32);
        option32.setText(resourceMap.getString("option32.text")); // NOI18N
        option32.setName("option32"); // NOI18N

        question3group.add(option31);
        option31.setText(resourceMap.getString("option31.text")); // NOI18N
        option31.setName("option31"); // NOI18N

        question3.setText(resourceMap.getString("question3.text")); // NOI18N
        question3.setName("question3"); // NOI18N

        question4group.add(option44);
        option44.setText(resourceMap.getString("option44.text")); // NOI18N
        option44.setName("option44"); // NOI18N

        question4Label.setText(resourceMap.getString("question4Label.text")); // NOI18N
        question4Label.setName("question4Label"); // NOI18N

        question4group.add(option43);
        option43.setText(resourceMap.getString("option43.text")); // NOI18N
        option43.setName("option43"); // NOI18N

        question4group.add(option42);
        option42.setText(resourceMap.getString("option42.text")); // NOI18N
        option42.setName("option42"); // NOI18N

        question4group.add(option41);
        option41.setText(resourceMap.getString("option41.text")); // NOI18N
        option41.setName("option41"); // NOI18N

        question4.setText(resourceMap.getString("question4.text")); // NOI18N
        question4.setName("question4"); // NOI18N

        submitButton.setText(resourceMap.getString("submitButton.text")); // NOI18N
        submitButton.setName("submitButton"); // NOI18N
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(question2Label)
                    .addComponent(question2)
                    .addComponent(option21)
                    .addComponent(option22)
                    .addComponent(option23)
                    .addComponent(option24)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(marksField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(question1)
                    .addComponent(option11)
                    .addComponent(option12)
                    .addComponent(option13)
                    .addComponent(option14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(question3Label)
                    .addComponent(question3)
                    .addComponent(option31)
                    .addComponent(option32)
                    .addComponent(option33)
                    .addComponent(option34)
                    .addComponent(question4Label)
                    .addComponent(question4)
                    .addComponent(option41)
                    .addComponent(option42)
                    .addComponent(option43)
                    .addComponent(option44)
                    .addComponent(submitButton))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(marksField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(question3Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(question3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option34)
                        .addGap(18, 18, 18)
                        .addComponent(question4Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(question4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option44))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(question1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option14)
                        .addGap(18, 18, 18)
                        .addComponent(question2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(question2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(option24)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(mcq.MCQApp.class).getContext().getActionMap(MCQView.class, this);
        jMenuItem1.setAction(actionMap.get("loadQuestion")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        fileMenu.add(jMenuItem1);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setMaximumSize(new java.awt.Dimension(200, 31));
        statusPanel.setName("statusPanel"); // NOI18N
        statusPanel.setPreferredSize(new java.awt.Dimension(200, 31));

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
// TODO add your handling code here:
    question1.setText("4 + 2 = ?");
    option11.setText("3");
    option12.setText("4");
    option13.setText("6");
    option14.setText("21");
}//GEN-LAST:event_submitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField marksField;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JRadioButton option11;
    private javax.swing.JRadioButton option12;
    private javax.swing.JRadioButton option13;
    private javax.swing.JRadioButton option14;
    private javax.swing.JRadioButton option21;
    private javax.swing.JRadioButton option22;
    private javax.swing.JRadioButton option23;
    private javax.swing.JRadioButton option24;
    private javax.swing.JRadioButton option31;
    private javax.swing.JRadioButton option32;
    private javax.swing.JRadioButton option33;
    private javax.swing.JRadioButton option34;
    private javax.swing.JRadioButton option41;
    private javax.swing.JRadioButton option42;
    private javax.swing.JRadioButton option43;
    private javax.swing.JRadioButton option44;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel question1;
    private javax.swing.ButtonGroup question1group;
    private javax.swing.JLabel question2;
    private javax.swing.JLabel question2Label;
    private javax.swing.ButtonGroup question2group;
    private javax.swing.JLabel question3;
    private javax.swing.JLabel question3Label;
    private javax.swing.ButtonGroup question3group;
    private javax.swing.JLabel question4;
    private javax.swing.JLabel question4Label;
    private javax.swing.ButtonGroup question4group;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}
