package gui.elements.base;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class Element {

	protected int regDestView;
	
	protected int bitDestView;
	
	protected int regDestCtrl;
	
	protected int bitDestCtrl;
	
	protected String label;

	protected JPanel content;
	
	protected int valueView;
	
	protected int valueControl;
	
	public Element() {
		this.content = new JPanel();
		this.content.setLayout(new BorderLayout());
		this.content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setAddressView(int regDest, int bitDest) {
		this.regDestView = regDest;
		this.bitDestView = bitDest;	
	}
	
	public void setAddressControl(int regDest, int bitDest) {
		this.regDestCtrl = regDest;
		this.bitDestCtrl = bitDest;	
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