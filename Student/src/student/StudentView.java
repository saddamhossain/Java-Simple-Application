/*
 * StudentView.java
 */

package student;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class StudentView extends FrameView {

    public StudentView(SingleFrameApplication app) {
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
            JFrame mainFrame = StudentApp.getApplication().getMainFrame();
            aboutBox = new StudentAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        StudentApp.getApplication().show(aboutBox);
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
        number1label = new javax.swing.JLabel();
        number2label = new javax.swing.JLabel();
        resultlabel = new javax.swing.JLabel();
        number1textfield = new javax.swing.JTextField();
        number2textfield = new javax.swing.JTextField();
        resultfield = new javax.swing.JTextField();
        addbutton = new javax.swing.JButton();
        subtractbutton = new javax.swing.JButton();
        multiplybutton = new javax.swing.JButton();
        dividebutton = new javax.swing.JButton();
        calculatebutton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        number1label.setDisplayedMnemonic('1');
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(student.StudentApp.class).getContext().getResourceMap(StudentView.class);
        number1label.setText(resourceMap.getString("number1label.text")); // NOI18N
        number1label.setName("number1label"); // NOI18N

        number2label.setDisplayedMnemonic('2');
        number2label.setText(resourceMap.getString("number2label.text")); // NOI18N
        number2label.setName("number2label"); // NOI18N

        resultlabel.setDisplayedMnemonic('R');
        resultlabel.setText(resourceMap.getString("resultlabel.text")); // NOI18N
        resultlabel.setName("resultlabel"); // NOI18N

        number1textfield.setText(resourceMap.getString("number1textfield.text")); // NOI18N
        number1textfield.setName("number1textfield"); // NOI18N

        number2textfield.setText(resourceMap.getString("number2textfield.text")); // NOI18N
        number2textfield.setName("number2textfield"); // NOI18N

        resultfield.setText(resourceMap.getString("resultfield.text")); // NOI18N
        resultfield.setName("resultfield"); // NOI18N

        addbutton.setMnemonic('A');
        addbutton.setText(resourceMap.getString("addbutton.text")); // NOI18N
        addbutton.setName("addbutton"); // NOI18N
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        subtractbutton.setMnemonic('S');
        subtractbutton.setText(resourceMap.getString("subtractbutton.text")); // NOI18N
        subtractbutton.setName("subtractbutton"); // NOI18N
        subtractbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtractbuttonActionPerformed(evt);
            }
        });

        multiplybutton.setMnemonic('M');
        multiplybutton.setText(resourceMap.getString("multiplybutton.text")); // NOI18N
        multiplybutton.setName("multiplybutton"); // NOI18N
        multiplybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplybuttonActionPerformed(evt);
            }
        });

        dividebutton.setMnemonic('D');
        dividebutton.setText(resourceMap.getString("dividebutton.text")); // NOI18N
        dividebutton.setName("dividebutton"); // NOI18N
        dividebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dividebuttonActionPerformed(evt);
            }
        });

        calculatebutton.setText(resourceMap.getString("calculatebutton.text")); // NOI18N
        calculatebutton.setName("calculatebutton"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dividebutton)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addbutton)
                            .addComponent(number2label)
                            .addComponent(number1label)
                            .addComponent(resultlabel))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(number1textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(number2textfield)
                                    .addComponent(resultfield)))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(multiplybutton)
                                    .addComponent(subtractbutton))
                                .addGap(28, 28, 28)
                                .addComponent(calculatebutton)))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number1textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number1label))
                .addGap(27, 27, 27)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number2textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number2label))
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultlabel))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addbutton)
                            .addComponent(subtractbutton))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dividebutton)
                            .addComponent(multiplybutton)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(calculatebutton)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(student.StudentApp.class).getContext().getActionMap(StudentView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setAction(actionMap.get("showAboutBox")); // NOI18N
        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
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

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        // TODO add your handling code here:
        int num1,num2,result;
        
       num1 = Integer.parseInt(number1textfield.getText());
       num2 = Integer.parseInt(number2textfield.getText());
       
       result = num1 + num2;
       
       resultfield.setText(" "+result);
       
       
       
    }//GEN-LAST:event_addbuttonActionPerformed

    private void subtractbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtractbuttonActionPerformed
        // TODO add your handling code here:
          int num1,num2,result;
         num1 = Integer.parseInt(number1textfield.getText());
       num2 = Integer.parseInt(number2textfield.getText());
       
       result = num1 - num2;
       
       resultfield.setText(" "+result);
    }//GEN-LAST:event_subtractbuttonActionPerformed

    private void dividebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dividebuttonActionPerformed
        // TODO add your handling code here:
           int num1,num2,result;
         num1 = Integer.parseInt(number1textfield.getText());
       num2 = Integer.parseInt(number2textfield.getText());
       
       result = num1 / num2;
       
       resultfield.setText(" "+result);
    }//GEN-LAST:event_dividebuttonActionPerformed

    private void multiplybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiplybuttonActionPerformed
        // TODO add your handling code here:
           int num1,num2,result;
         num1 = Integer.parseInt(number1textfield.getText());
       num2 = Integer.parseInt(number2textfield.getText());
       
       result = num1 * num2;
       
       resultfield.setText(" "+result);
    }//GEN-LAST:event_multiplybuttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private javax.swing.JButton calculatebutton;
    private javax.swing.JButton dividebutton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton multiplybutton;
    private javax.swing.JLabel number1label;
    private javax.swing.JTextField number1textfield;
    private javax.swing.JLabel number2label;
    private javax.swing.JTextField number2textfield;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField resultfield;
    private javax.swing.JLabel resultlabel;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JButton subtractbutton;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}
