package gui.form;

import gui.graphics.Circle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import modbus.Master;
import core.Controller;

public class FormConnect extends JPanel {

	private JComboBox jcPort;
	
	private JTextField tfBaudRate;

	private JButton btConnect;
	
	private JButton btDisconnect;
	
	private Circle status;

	public FormConnect() {
		
		this.setPreferredSize(new Dimension(800, 80));
		this.setBorder(BorderFactory.createTitledBorder("Configurações"));

		this.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 15));
		this.init();
	}
	
	
	public void init() {
		
		/*
		 * Status
		 */
		this.status = new Circle(Color.RED, 20, 20);
		this.status.setBorder(BorderFactory.createEmptyBorder(8, 20, 0, 0));
		this.add(this.status);

		/*
		 * Port
		 */
		String[] items = {"COM1", "COM2"};
		this.jcPort = new JComboBox<>(items);
		this.jcPort.setEditable(false);
		this.add(new Label("Porta: ", JLabel.LEFT));
		this.add(this.jcPort);
		
		
		/*
		 * Baudrate
		 */
		this.tfBaudRate = new JTextField("9600", 10);
		this.add(new Label("Taxa de transmissão: "));
		this.add(this.tfBaudRate);
		
		/*
		 * Buttons
		 */
		this.btConnect = new JButton("Conectar");
		this.btConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connectAction();
			}
		});
		this.add(this.btConnect);
		
		this.btDisconnect = new JButton("Desconectar");
		this.btDisconnect.setEnabled(false);
		this.btDisconnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				disconnectAction();
			}
		});
		this.add(this.btDisconnect);
	}
	
	public void connectAction() {
		
		Master master = Controller.getInstance().getModbusMaster();
		
		master.setPortName((String) this.jcPort.getSelectedItem());
		master.setBaudRate(Integer.parseInt(this.tfBaudRate.getText()));
		
		if(master.open()) {		
			this.status.setColor(new Color(45,176,57));
			this.jcPort.setEnabled(false);
			this.tfBaudRate.setEditable(false);
			this.btConnect.setEnabled(false);
			this.btDisconnect.setEnabled(true);
		}
	}
	
	public void disconnectAction() {
	
		Master master = Controller.getInstance().getModbusMaster();
		master.close();
	
		this.status.setColor(Color.RED);
		this.jcPort.setEnabled(true);
		this.tfBaudRate.setEditable(true);
		this.btConnect.setEnabled(true);
		this.btDisconnect.setEnabled(false);
	}
}