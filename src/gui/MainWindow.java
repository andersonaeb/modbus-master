package gui;

import gui.form.FormConnect;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.Controller;

public class MainWindow extends JFrame {

	private JPanel content;
	
	private Window window = null;
	
	private JTextField f;

	public MainWindow() {
	
		/*
		 * Configuration
		 */
		this.setTitle("ModBus Ascii 81N");
		this.setSize(new Dimension(800, 600));
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);  

		this.initContent();
		
		this.addElements();
		
		this.pack();

	}
	
	/**
	 * Content panel of the elements
	 */
	public void initContent() {
		this.content = new JPanel();
		this.content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.PAGE_AXIS));
		this.add(this.content);
	}
	
	/**
	 * Add elements to content
	 */
	public void addElements() {
		
		this.content.add(new FormConnect());
		
		this.content.add(new House());
		
		JPanel p = new JPanel();
		
		this.f = new JTextField("0 1", 30);
		p.add(this.f);
		
		JButton b = new JButton("Conectar");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().getModbusMaster().run(f.getText());
			}
		});
		p.add(b);
		this.content.add(p);
		
	}
}