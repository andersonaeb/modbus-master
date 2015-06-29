package gui.elements;

import gui.DataControl;
import gui.elements.base.Element;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import core.Controller;

public class ViewElement extends Element {
	
	private JLabel labelValue;
	
	@Override
	public void render() {
		
		this.content.setPreferredSize(new Dimension(780, 35));
		
		JLabel label = new JLabel(this.label, JLabel.LEFT);
		label.setPreferredSize(new Dimension(300, 30));
		label.setFont(new Font("Arial", Font.BOLD, 14));
		this.content.add(label, BorderLayout.LINE_START);
		
		this.labelValue = new JLabel("");
		this.content.add(this.labelValue, BorderLayout.CENTER);

		this.updateLabels();
	}
	
	public void updateLabels() {
		this.labelValue.setText(String.valueOf(this.valueView));
	}

	public void updateValueData() {
		DataControl dt = Controller.getInstance().getDataControl();
		
		this.valueView = dt.getValue(this.regDestView);
		
		this.updateLabels();
	}
}
