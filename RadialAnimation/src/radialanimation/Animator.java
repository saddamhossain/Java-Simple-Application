/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radialanimation;

import java.awt.Graphics;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author kmhasan
 */
class Animator extends TimerTask {
    JPanel drawingPanel;
    int centerX, centerY;
    double radius;
    double theta;
    
    public Animator(JPanel panel) {
        drawingPanel = panel;
        radius = 50;
        theta = 0.0;
        centerY = drawingPanel.getHeight()/2;
        centerX = drawingPanel.getWidth()/2;
    }
    
    @Override
    public void run() {
        Graphics g = drawingPanel.getGraphics();
        int nextX = centerX + (int) (radius * Math.cos(theta));
        int nextY = centerY + (int) (radius * Math.sin(theta));
        System.out.println(theta + " " + nextX + " " + nextY);
        g.drawLine(centerX, centerY, nextX, nextY);
        theta = theta + 0.5;
    }
    
}
