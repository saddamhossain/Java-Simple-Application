/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animationdemo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author kmhasan
 */
public class Animator extends TimerTask {
    JPanel animationPanel;
    Color color;
    int nextX, nextY;
    int lastX, lastY;
    int dys = +1;
    int dxs = +1;
    
    public Animator(JPanel obj, Color c) {
        animationPanel = obj;
        color = c;
        lastX = 0;
        lastY = 0;
    }
    
    @Override
    public void run() {
//        animationPanel.repaint();
        
        Graphics g = animationPanel.getGraphics();
        g.setColor(animationPanel.getBackground());
        g.fillOval(lastX, lastY, 20, 20);        
        g.setColor(color);
        int dx = (int) (4 * Math.random());
        int dy = (int) (4 * Math.random());
        if (lastY + dy > animationPanel.getHeight() - 40)
            dys = -1;
        else if (lastY + dy <= 40)
            dys = +1;
        if (lastX + dx > animationPanel.getWidth() - 40)
            dxs = -1;
        else if (lastX + dx <= 40)
            dxs = +1;
        nextY = lastY + dys * dy;
        nextX = lastX + dxs * dx;
//        g.drawLine(lastX, lastY, nextX, nextY);
        g.fillOval(nextX, nextY, 20, 20);
        lastX = nextX;
        lastY = nextY;
    }
    
}
