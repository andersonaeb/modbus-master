package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import core.Controller;
import gui.DataControl;
import gui.elements.base.Element;

public class SendElement extends Element {

	private JButton button;
	
	@Override
	public void render() {
		
		this.content.setPreferredSize(new Dimension(780, 35));
		
		JLabel label = new JLabel(this.label, JLabel.LEFT);
		label.setPreferredSize(new Dimension(300, 30));
		label.setFont(new Font("Arial", Font.BOLD, 14));
		this.content.add(label, BorderLayout.LINE_START);
		
		this.button = new JButton("Enviar");
		this.button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonAction();
			}
		});
		this.content.add(this.button, BorderLayout.LINE_END);
	}
	
	public void buttonAction() {
		Controller.getInstance().getDataControl().setValue(this.regDestView, this.bitDestView, 1);
	}
	
	public void updateValueData() {}
}
