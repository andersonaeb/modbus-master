package gui.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Circle extends JPanel {
	
	private Graphics2D ga;
	
	private Shape circle;
	
	private Color color;
	
	private Dimension dimension;
	
	public Circle(Color c, int w, int h) {
	
		this.color = c;
		this.dimension = new Dimension(w, h);
	}
	
	public void paint(Graphics e) {
	
        super.paint(e);
        
        Graphics2D g = (Graphics2D) e;
        g.setColor(this.color);
        g.fillOval(0, 0, (int) this.dimension.getWidth(), (int) this.dimension.getHeight());
        
        this.setSize(this.dimension);

    }
	
    public void setColor(Color color) {
    	this.color = color;
    	this.repaint();
    }
}
