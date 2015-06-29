package gui.elements.base;

import gui.DataControl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import core.Controller;

public abstract class StatusElement extends Element {
	
	private JLabel labelStatus;
	
	private String labelStatusOn;
	
	private String labelStatusOff;
	
	@Override
	public void render() {
		
		this.content.setPreferredSize(new Dimension(780, 35));
		
		JLabel label = new JLabel(this.label, JLabel.LEFT);
		label.setPreferredSize(new Dimension(300, 30));
		label.setFont(new Font("Arial", Font.BOLD, 14));
		this.content.add(label, BorderLayout.LINE_START);
		
		this.labelStatus = new JLabel("");
		this.content.add(this.labelStatus, BorderLayout.CENTER);

		this.updateLabels();
	}
	
	public void updateLabels() {
		if(this.valueView == 1) {
			this.labelStatus.setText(this.labelStatusOn);
			this.labelStatus.setForeground(Color.BLUE);
		} else {
			this.labelStatus.setText(this.labelStatusOff);
			this.labelStatus.setForeground(Color.RED);
		}
	}
	
	public void setStatusLabel(String labelOn, String labelOff) {
		this.labelStatusOn = labelOn;
		this.labelStatusOff = labelOff;
	}
	
	public void updateValueData() {
		DataControl dt = Controller.getInstance().getDataControl();
		
		this.valueView = dt.getValue(this.regDestView, this.bitDestView);
		
		this.updateLabels();
	}
}
