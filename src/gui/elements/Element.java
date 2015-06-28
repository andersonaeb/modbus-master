package gui.elements;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class Element {

	protected int regDest;
	
	protected int bitDest;
	
	protected String label;

	protected JPanel content;
	
	protected int value;
	
	public Element() {
		this.content = new JPanel();
		this.content.setLayout(new BorderLayout());
		this.content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setAddress(int regDest, int bitDest) {
		this.regDest = regDest;
		this.bitDest = bitDest;	
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public JPanel getContent() {
		return this.content;
	}
	
	public abstract void updateValueData();
	
	public abstract void render();
}