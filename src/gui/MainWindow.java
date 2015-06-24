package gui;

import gui.form.FormConnect;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

	private JPanel content;
	
	private Window window = null;

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
		this.content.setLayout(new BorderLayout());
		this.add(this.content);
	}
	
	/**
	 * Add elements to content
	 */
	public void addElements() {
		
		this.content.add(new FormConnect()); 
	}
}