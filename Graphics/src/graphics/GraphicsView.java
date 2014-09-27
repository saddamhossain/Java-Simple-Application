/*
 * GraphicsView.java
 */

package graphics;

import java.awt.Color;
import java.awt.Graphics;
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
public class GraphicsView extends FrameView {

    public GraphicsView(SingleFrameApplication app) {
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
            JFrame mainFrame = GraphicsApp.getApplication().getMainFrame();
            aboutBox = new GraphicsAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        GraphicsApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        drawingpanel = new javax.swing.JPanel();
        drawlinebutton = new javax.swing.JButton();
        drawrectbutton = new javax.swing.JButton();
        fillrectbutton = new javax.swing.JButton();
        drawroundrectbutton = new javax.swing.JButton();
        fillroundrectbutton = new javax.swing.JButton();
        drawovalbutton = new javax.swing.JButton();
        fillovalbutton = new javax.swing.JButton();
        drawarcbutton = new javax.swing.JButton();
        fillarcbutton = new javax.swing.JButton();
        drawpolygonbutton = new javax.swing.JButton();
        fillpolygonbutton = new javax.swing.JButton();
        drawstringbutton = new javax.swing.JButton();
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

        mainpanel.setName("mainpanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(graphics.GraphicsApp.class).getContext().getResourceMap(GraphicsView.class);
        drawingpanel.setBackground(resourceMap.getColor("drawingpanel.background")); // NOI18N
        drawingpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        drawingpanel.setToolTipText(resourceMap.getString("drawingpanel.toolTipText")); // NOI18N
        drawingpanel.setFont(resourceMap.getFont("drawingpanel.font")); // NOI18N
        drawingpanel.setName("drawingpanel"); // NOI18N

        javax.swing.GroupLayout drawingpanelLayout = new javax.swing.GroupLayout(drawingpanel);
        drawingpanel.setLayout(drawingpanelLayout);
        drawingpanelLayout.setHorizontalGroup(
            drawingpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        drawingpanelLayout.setVerticalGroup(
            drawingpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        drawlinebutton.setText(resourceMap.getString("drawlinebutton.text")); // NOI18N
        drawlinebutton.setName("drawlinebutton"); // NOI18N
        drawlinebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawlinebuttonActionPerformed(evt);
            }
        });

        drawrectbutton.setText(resourceMap.getString("drawrectbutton.text")); // NOI18N
        drawrectbutton.setName("drawrectbutton"); // NOI18N
        drawrectbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawrectbuttonActionPerformed(evt);
            }
        });

        fillrectbutton.setText(resourceMap.getString("fillrectbutton.text")); // NOI18N
        fillrectbutton.setName("fillrectbutton"); // NOI18N
        fillrectbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillrectbuttonActionPerformed(evt);
            }
        });

        drawroundrectbutton.setText(resourceMap.getString("drawroundrectbutton.text")); // NOI18N
        drawroundrectbutton.setName("drawroundrectbutton"); // NOI18N
        drawroundrectbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawroundrectbuttonActionPerformed(evt);
            }
        });

        fillroundrectbutton.setText(resourceMap.getString("fillroundrectbutton.text")); // NOI18N
        fillroundrectbutton.setName("fillroundrectbutton"); // NOI18N
        fillroundrectbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillroundrectbuttonActionPerformed(evt);
            }
        });

        drawovalbutton.setText(resourceMap.getString("drawovalbutton.text")); // NOI18N
        drawovalbutton.setName("drawovalbutton"); // NOI18N
        drawovalbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawovalbuttonActionPerformed(evt);
            }
        });

        fillovalbutton.setText(resourceMap.getString("fillovalbutton.text")); // NOI18N
        fillovalbutton.setName("fillovalbutton"); // NOI18N
        fillovalbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillovalbuttonActionPerformed(evt);
            }
        });

        drawarcbutton.setText(resourceMap.getString("drawarcbutton.text")); // NOI18N
        drawarcbutton.setName("drawarcbutton"); // NOI18N
        drawarcbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawarcbuttonActionPerformed(evt);
            }
        });

        fillarcbutton.setText(resourceMap.getString("fillarcbutton.text")); // NOI18N
        fillarcbutton.setName("fillarcbutton"); // NOI18N
        fillarcbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillarcbuttonActionPerformed(evt);
            }
        });

        drawpolygonbutton.setText(resourceMap.getString("drawpolygonbutton.text")); // NOI18N
        drawpolygonbutton.setName("drawpolygonbutton"); // NOI18N
        drawpolygonbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawpolygonbuttonActionPerformed(evt);
            }
        });

        fillpolygonbutton.setText(resourceMap.getString("fillpolygonbutton.text")); // NOI18N
        fillpolygonbutton.setName("fillpolygonbutton"); // NOI18N
        fillpolygonbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillpolygonbuttonActionPerformed(evt);
            }
        });

        drawstringbutton.setText(resourceMap.getString("drawstringbutton.text")); // NOI18N
        drawstringbutton.setName("drawstringbutton"); // NOI18N
        drawstringbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawstringbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(drawingpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fillpolygonbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fillarcbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawarcbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fillovalbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fillroundrectbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawroundrectbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fillrectbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawrectbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawlinebutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(drawovalbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawpolygonbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(drawstringbutton)
                .addGap(69, 69, 69))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(drawingpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(drawlinebutton)
                            .addComponent(drawstringbutton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(drawrectbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fillrectbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drawroundrectbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fillroundrectbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(drawovalbutton)
                        .addGap(18, 18, 18)
                        .addComponent(fillovalbutton)
                        .addGap(18, 18, 18)
                        .addComponent(drawarcbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fillarcbutton)
                        .addGap(18, 18, 18)
                        .addComponent(drawpolygonbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fillpolygonbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(graphics.GraphicsApp.class).getContext().getActionMap(GraphicsView.class, this);
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
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 595, Short.MAX_VALUE)
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

        setComponent(mainpanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void drawlinebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawlinebuttonActionPerformed
        // TODO add your handling code here:
        Graphics g  =drawingpanel.getGraphics();
        
      g.setColor(Color.red);
      g.drawLine(0, drawingpanel.getHeight()/2, drawingpanel.getWidth(), drawingpanel.getHeight()/2);
      g.setColor(Color.BLACK);
      g.drawLine(drawingpanel.getWidth()/2, 0, drawingpanel.getWidth()/2, drawingpanel.getHeight());
      g.setColor(Color.PINK);
      g.drawLine(0, 0, drawingpanel.getWidth(),drawingpanel.getHeight());
      g.setColor(Color.blue);
      g.drawLine(drawingpanel.getWidth(), 0, 0, drawingpanel.getHeight());
      
    
        
    }//GEN-LAST:event_drawlinebuttonActionPerformed

    private void drawrectbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawrectbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        g.drawRect(100, 10,50, 50);
        g.drawRect(50, 60,50, 50);
        g.drawRect(150, 100,50, 50);
        g.drawRect(220, 200,50, 50);
        
    }//GEN-LAST:event_drawrectbuttonActionPerformed

    private void fillrectbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillrectbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        g.fillRect(300, 40,50, 50);
        g.fillRect(300, 100,50, 50);
        g.fillRect(150, 200,50, 50);
        g.fillRect(220, 300,50, 50);
    }//GEN-LAST:event_fillrectbuttonActionPerformed

    private void drawroundrectbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawroundrectbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        g.drawRoundRect(100, 200,50, 50,30,30);
        g.drawRoundRect(220, 350,50, 50,60,60);
    }//GEN-LAST:event_drawroundrectbuttonActionPerformed

    private void fillroundrectbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillroundrectbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        g.fillRoundRect(200,50,60,60,50,50);
    }//GEN-LAST:event_fillroundrectbuttonActionPerformed

    private void drawovalbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawovalbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        g.drawOval(30,30,50,50);
    }//GEN-LAST:event_drawovalbuttonActionPerformed

    private void fillovalbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillovalbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        g.fillOval(10,300,50,50);
        
    }//GEN-LAST:event_fillovalbuttonActionPerformed

    private void drawarcbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawarcbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        g.drawArc(200, 100, 100, 60, 0, 180);
        
    }//GEN-LAST:event_drawarcbuttonActionPerformed

    private void fillarcbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillarcbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        g.fillArc(300, 80,80, 80, 0, 180);
    }//GEN-LAST:event_fillarcbuttonActionPerformed

    private void drawpolygonbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawpolygonbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        
        int xpoints[] = {30,200,30,200,30};
        int ypoints[] = {30,30,200,200,30};
        int num = 5;
        
        g.drawPolygon(xpoints,ypoints,num);
    }//GEN-LAST:event_drawpolygonbuttonActionPerformed

    private void fillpolygonbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillpolygonbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        
        int xpoints[] = {40,60,200,200,40};
        int ypoints[] = {40,40,30,200,40};
        int num = 5;
        
        g.fillPolygon(xpoints,ypoints,num);
    }//GEN-LAST:event_fillpolygonbuttonActionPerformed

    private void drawstringbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawstringbuttonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawingpanel.getGraphics();
        g.drawString("Saddam Hossain Rana", 200, 200);
    }//GEN-LAST:event_drawstringbuttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton drawarcbutton;
    private javax.swing.JPanel drawingpanel;
    private javax.swing.JButton drawlinebutton;
    private javax.swing.JButton drawovalbutton;
    private javax.swing.JButton drawpolygonbutton;
    private javax.swing.JButton drawrectbutton;
    private javax.swing.JButton drawroundrectbutton;
    private javax.swing.JButton drawstringbutton;
    private javax.swing.JButton fillarcbutton;
    private javax.swing.JButton fillovalbutton;
    private javax.swing.JButton fillpolygonbutton;
    private javax.swing.JButton fillrectbutton;
    private javax.swing.JButton fillroundrectbutton;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}
