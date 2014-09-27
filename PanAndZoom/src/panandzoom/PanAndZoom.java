/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panandzoom;

/**
 *
 * @author RONY
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.*;


public class PanAndZoom {
        PanAndZoomCanvas canvas;
        Graphics2D g2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    new PanAndZoom();
		}
	    });
    }

    public PanAndZoom() {
	JFrame frame = new JFrame();


	JPanel tool= new JPanel();
	JPanel custom = new JPanel();

	JButton sineButton = new JButton();
	sineButton.setText("Sine");
	JButton cosButton = new JButton();
	cosButton.setText("Cosine");
	JLabel label = new JLabel();
	label.setText("y = ");
	JTextField t = new JTextField("",20);

	JButton plotButton = new JButton();
	plotButton.setText("Plot");



	tool.add(sineButton);
	tool.add(cosButton);
	custom.add(label);
	custom.add(t);
	custom.add(plotButton);



	canvas = new PanAndZoomCanvas();

	PanningHandler panner = new PanningHandler();
	canvas.addMouseListener(panner);
	canvas.addMouseMotionListener(panner);
	canvas.setBorder(BorderFactory.createLineBorder(Color.black));

	// code for handling zooming
	JSlider zoomSlider = new JSlider(JSlider.HORIZONTAL, 0, 300, 100);
	zoomSlider.setMajorTickSpacing(25);
	zoomSlider.setMinorTickSpacing(5);
	zoomSlider.setPaintTicks(true);
	zoomSlider.setPaintLabels(true);
	zoomSlider.addChangeListener(new ScaleHandler());

	// Add the components to the canvas
	frame.getContentPane().add(zoomSlider, BorderLayout.NORTH);
	frame.getContentPane().add(canvas, BorderLayout.CENTER);
	frame.getContentPane().add(tool,BorderLayout.WEST);
	frame.getContentPane().add(custom,BorderLayout.SOUTH);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setVisible(true);
    }

    class PanAndZoomCanvas extends JComponent {
	double translateX;
	double translateY;
	double scale;

	PanAndZoomCanvas() {
	    translateX = 0;
	    translateY = 0;
	    scale = 1;
	}

        @Override
	public void paintComponent(Graphics g) {
	    g2 = (Graphics2D) g;

	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

	    // save the original transform so that we can restore
	    // it later
	    AffineTransform saveTransform = g2.getTransform();

	    // blank the screen. If we do not call super.paintComponent, then
	    // we need to blank it ourselves
	    g2.setColor(Color.WHITE);
    	g2.fillRect(0, 0, getWidth(), getHeight());


	    // We need to add new transforms to the existing
	    // transform, rather than creating a new transform from scratch.
	    // If we create a transform from scratch, we will
	    // will start from the upper left of a JFrame,
	    // rather than from the upper left of our component
	    AffineTransform at = new AffineTransform(saveTransform);

	    // The zooming transformation. Notice that it will be performed
	    // after the panning transformation, zooming the panned scene,
	    // rather than the original scene
	    at.translate(getWidth()/2, getHeight()/2);
	    at.scale(scale, scale);
	    at.translate(-getWidth()/2, -getHeight()/2);

	    // The panning transformation
	    at.translate(translateX, translateY);

	    g2.setTransform(at);

	    // draw the objects
	    //g2.setColor(Color.BLACK);
	    //g2.drawRect(50, 50, 50, 50);
	    //g2.fillOval(100, 100, 100, 100);
	    //g2.drawString("Test Affine Transform", 50, 30);
//******************************************************************
//
//My Customization: Niaz code to try out
//
g2.setColor(Color.BLUE);
g2.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
g2.drawLine(getWidth()/2,0, getWidth()/2, getHeight());
g2.setColor(Color.GRAY);

//To set the axis marks,we set the font to Serif, size 11
    Font font = new Font("Serif", Font.PLAIN, 11);
    g2.setFont(font);
//Need to do the axis tick mark here
//***************************************************


//********************************** Grid *************************************************************
double xleft=-10.0,stepaxis=50,xinc=0.0;


for(xinc=xleft+stepaxis;xinc<=+250.0;xinc+=stepaxis)
{
	g2.drawLine((int)(getWidth()/2+xinc),0, (int)(getWidth()/2+xinc), getHeight());//positive x axis

	g2.drawLine((int)(getWidth()/2-xinc),0, (int)(getWidth()/2-xinc), getHeight());//negative x axis
	g2.drawLine(0, (int)(getHeight()/2-xinc), getWidth(), (int)(getHeight()/2-xinc));//positive y axis
	g2.drawLine(0, (int)(getHeight()/2+xinc), getWidth(), (int)(getHeight()/2+xinc));//negative y axis

	xleft=xinc;

}

//******************************************************************************************************

g2.setColor(Color.BLACK);
    double x1, y1, x2, y2;
    int sx1, sy1, sx2, sy2;
    int w = getWidth();
    int h = getHeight();
    x1 = -10.0;
    y1 = Math.sin(x1);
    double step = 0.001;
    for (x2 = x1 + step; x2 <= +10.0; x2 += step)
    {
        y2 = Math.sin(x2);
        sx1 = (int) (x1 * (w / 20.0)) + w / 2;
        sx2 = (int) (x2 * (w / 20.0)) + w / 2;
        sy1 = (int) (-y1 * (h / 8.0)) + h / 2;
        sy2 = (int) (-y2 * (h / 8.0)) + h / 2;

        g2.drawLine(sx1, sy1, sx2, sy2);

        x1 = x2;
        y1 = y2;
     }

//}
//******************************************************************




	    // make sure you restore the original transform or else the drawing
	    // of borders and other components might be messed up
	    g2.setTransform(saveTransform);
	}
        @Override
	public Dimension getPreferredSize() {
	    return new Dimension(500, 500);
	}
    }

    class PanningHandler implements MouseListener,
				    MouseMotionListener {
	int referenceX;
	int referenceY;

        @Override
	public void mousePressed(MouseEvent e) {
	    // capture the starting point
	    referenceX = e.getX();
	    referenceY = e.getY();
	}

        @Override
	public void mouseDragged(MouseEvent e) {

	    // the size of the pan translations
	    // are defined by the current mouse location subtracted
	    // from the reference location
	    int deltaX = e.getX() - referenceX;
	    int deltaY = e.getY() - referenceY;

	    // make the reference point be the new mouse point.
	    referenceX = e.getX();
	    referenceY = e.getY();

	    canvas.translateX += deltaX;
	    canvas.translateY += deltaY;

	    // schedule a repaint.
	    canvas.repaint();
	}

        @Override
	public void mouseClicked(MouseEvent e) {}
        @Override
	public void mouseEntered(MouseEvent e) {}
        @Override
	public void mouseExited(MouseEvent e) {}
        @Override
	public void mouseMoved(MouseEvent e) {}
        @Override
	public void mouseReleased(MouseEvent e) {}
	}

    class ScaleHandler extends JFrame implements ChangeListener {
        @Override
	public void stateChanged(ChangeEvent e) {
	    JSlider slider = (JSlider)e.getSource();
	    int zoomPercent = slider.getValue();
            
	    // make sure zoom never gets to actual 0, or else the objects will
	    // disappear and the matrix will be non-invertible.
	    canvas.scale = Math.max(0.0001, zoomPercent / 100.0);
            
            canvas.repaint();
	    
	}

        
    }
 }
