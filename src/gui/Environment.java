package gui;

import gui.elements.ElementFactory;
import gui.elements.base.Element;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import core.Controller;

public class Environment extends JPanel {

	private String name;

	private ArrayList<Element> elements;

	public Environment(String name) {

		this.elements = new ArrayList<>();

		this.name = name;
		this.setLayout(new GridLayout(0, 1, 0, 10));
		this.setVisible(false);
	}

	/**
	 * Name of Environment
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	public void addElement(String name, int type, int regDest) {
		this.addElement(name, type, regDest, -1);
	}

	/**
	 * Update elements
	 */
	public void updateElements() {
		for(Element e : this.elements) {
			e.updateValueData();
		}
	}

	public void addElement(String name, int type, int regDestView, int bitDestView) {
		this.addElement(name, type, regDestView, bitDestView, 0, 0);
	}
	
	public void addElement(String name, int type, int regDestView, int bitDestView, int regDestCtrl, int bitDestCtrl) {

		Element e = ElementFactory.get(type);
		e.setLabel(name);
		e.setAddressView(regDestView, bitDestView);
		e.setAddressControl(regDestCtrl, bitDestCtrl);
		e.render();

		Color color;
		color = (this.elements.size() % 2 == 0) ? new Color(0xf7f7f7)
				: new Color(0xe5e5e5);
		e.getContent().setBackground(color);

		this.add(e.getContent());
		this.elements.add(e);
	}

	public void close() {

		this.setVisible(false);

		Timer timer = Controller.getInstance().getTimerEnvironment();
		if (timer != null) {
			timer.cancel();
		}
	}

	public void open() {

		this.setVisible(true);

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				updateElements();
			}
		}, 0, 2000);
		Controller.getInstance().setTimerEnvironment(timer);
	}
}