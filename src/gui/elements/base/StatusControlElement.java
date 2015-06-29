package gui.elements.base;

import gui.DataControl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import core.Controller;

public abstract class StatusControlElement extends Element {

	private JButton button;
	
	private JLabel labelStatus;
	
	private String labelButtonOn;
	
	private String labelButtonOff;
	
	private String labelStatusOn;
	
	private String labelStatusOff;
	
	private Color colorOn = Color.BLUE;
	
	private Color colorOff = Color.RED;
	
	@Override
	public void render() {
		
		this.content.setPreferredSize(new Dimension(780, 35));
		
		JLabel label = new JLabel(this.label, JLabel.LEFT);
		label.setPreferredSize(new Dimension(300, 30));
		label.setFont(new Font("Arial", Font.BOLD, 14));
		this.content.add(label, BorderLayout.LINE_START);
		
		this.labelStatus = new JLabel("");
		this.content.add(this.labelStatus, BorderLayout.CENTER);
		
		this.button = new JButton();
		this.button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonAction();
			}
		});
		this.content.add(this.button, BorderLayout.LINE_END);
		this.updateLabels();
	}
	
	public void updateLabels() {
		if(this.valueView == 1) {
			this.labelStatus.setText(this.labelStatusOn);
			this.labelStatus.setForeground(this.colorOn);
		} else {
			this.labelStatus.setText(this.labelStatusOff);
			this.labelStatus.setForeground(this.colorOff);
		}
		
		if(this.valueControl == 1) {
			this.button.setText(this.labelButtonOff);
		} else {
			this.button.setText(this.labelButtonOn);
		}
	}
	
	public void buttonAction() {
		if(this.valueControl == 1) {
			this.valueControl = 0;
		} else {
			this.valueControl = 1;
		}
		
		this.updateLabels();
		
		Controller.getInstance().getDataControl().setValue(this.regDestCtrl, this.bitDestCtrl, this.valueControl);
	}
	
	public void setButtonLabel(String labelOn, String labelOff) {
		this.labelButtonOn = labelOn;
		this.labelButtonOff = labelOff;
	}
	
	public void setStatusLabel(String labelOn, String labelOff) {
		this.labelStatusOn = labelOn;
		this.labelStatusOff = labelOff;
	}
	
	public void setColors(Color colorOn, Color colorOff) {
		this.colorOn = colorOn;
		this.colorOff = colorOff;
	}
	
	public void updateValueData() {
		DataControl dt = Controller.getInstance().getDataControl();
		
		this.valueView = dt.getValue(this.regDestView, this.bitDestView);
		this.valueControl = dt.getValue(this.regDestCtrl, this.bitDestCtrl);
		
		this.updateLabels();
	}
}
