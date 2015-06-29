package gui;

import gui.elements.ElementFactory;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class House extends JPanel {

	private JComboBox<Object> selectEnv;

	private ArrayList<Environment> environments;

	private int atualIndex;

	public House() {

		this.setPreferredSize(new Dimension(800, 700));
		this.setBorder(BorderFactory.createTitledBorder("Residência"));
		this.initPanel();
	}

	public void initPanel() {

		this.atualIndex = 0;

		this.environments = new ArrayList<>();

		this.selectEnv = new JComboBox<>();
		this.selectEnv.setPreferredSize(new Dimension(780, 30));
		this.add(selectEnv);
		this.add(new JPanel());

		this.initEnvironments();
	}

	public void initEnvironments() {

		Environment e1 = new Environment("Geral");
		e1.addElement("Alarme ", ElementFactory.ALARM, 9, 0, 8, 0);
		e1.addElement("Alarme Disparado", ElementFactory.YESNO, 9, 1);
		e1.addElement("Lâmpada área de circulação", ElementFactory.LAMP, 12, 1, 15, 1);
		this.addEnvironment(e1);

		Environment e2 = new Environment("Piscina / Área Externa");
		e2.addElement("Alarme Ligado", ElementFactory.YESNO, 9, 1);
		e2.addElement("Temperatura da piscina", ElementFactory.VIEW, 0);
		e2.addElement("Água Quente", ElementFactory.WATER, 9, 4, 8, 4);
		e2.addElement("Água Fria", ElementFactory.WATER, 9, 5, 8, 5);
		e2.addElement("Luz da Varanda", ElementFactory.LAMP, 13, 2, 16, 2);
		e2.addElement("Lâmpada 1", ElementFactory.LAMP, 13, 3, 16, 3);
		e2.addElement("Lâmpada 2", ElementFactory.LAMP, 13, 4, 16, 4);
		e2.addElement("Lâmpada 3", ElementFactory.LAMP, 13, 5, 16, 5);
		e2.addElement("Lâmpada do banheiro", ElementFactory.LAMP, 13, 0, 16, 0);
		e2.addElement("Lâmpada do depósito", ElementFactory.LAMP, 13, 1, 16, 1);
		this.addEnvironment(e2);

		Environment e3 = new Environment("Garagem");
		e3.addElement("Alarme Ligado", ElementFactory.YESNO, 9, 0);
		this.addEnvironment(e3);

		Environment e4 = new Environment("Cozinha");
		e4.addElement("Alarme Ligado", ElementFactory.YESNO, 9, 2);
		this.addEnvironment(e4);

		Environment e5 = new Environment("Sala de Estar");
		e5.addElement("Alarme Ligado", ElementFactory.YESNO, 9, 3);
		e5.addElement("Temperatura da sala", ElementFactory.VIEW, 3);
		e5.addElement("Lâmpada 1", ElementFactory.LAMP, 11, 0, 14, 0);
		e5.addElement("Lâmpada 2", ElementFactory.LAMP, 11, 1, 14, 1);
		e5.addElement("Lâmpada 3", ElementFactory.LAMP, 11, 2, 14, 2);
		this.addEnvironment(e5);

		Environment e6 = new Environment("Sala de Jogos");
		e6.addElement("Alarme Ligado", ElementFactory.YESNO, 9, 4);
		e6.addElement("Temperatura da sala", ElementFactory.VIEW, 4);
		e6.addElement("Lâmpada 1", ElementFactory.LAMP, 11, 5, 14, 5);
		e6.addElement("Lâmpada 2", ElementFactory.LAMP, 11, 6, 14, 6);
		this.addEnvironment(e6);

		Environment e7 = new Environment("Suite");
		e7.addElement("Alarme Ligado", ElementFactory.YESNO, 9, 5);
		e7.addElement("Temperatura da suite", ElementFactory.VIEW, 2);
		e7.addElement("Temperatura da banheira", ElementFactory.VIEW, 1);
		e7.addElement("Nível água da banheira", ElementFactory.VIEW, 7);
		e7.addElement("Água Quente da banheira", ElementFactory.WATER, 9, 2, 8, 1);
		e7.addElement("Água Fria da banheira", ElementFactory.WATER, 9, 3, 8, 2);
		e7.addElement("Esgotar água da banheira", ElementFactory.SEND, 8, 3);
		e7.addElement("Lâmpada 1", ElementFactory.LAMP, 12, 5, 15, 5);
		e7.addElement("Lâmpada 2", ElementFactory.LAMP, 12, 6, 15, 6);
		e7.addElement("Lâmpada 3", ElementFactory.LAMP, 12, 7, 15, 7);
		e7.addElement("Lâmpada do banheiro", ElementFactory.LAMP, 12, 4, 15, 4);
		e7.addElement("Lâmpada do closet", ElementFactory.LAMP, 12, 3, 15, 3);
		this.addEnvironment(e7);

		Environment e8 = new Environment("Dormitório 1");
		e8.addElement("Alarme Ligado", ElementFactory.YESNO, 9, 6);
		e8.addElement("Lâmpada do quarto", ElementFactory.LAMP, 11, 7, 14, 7);
		e8.addElement("Temperatura do quarto", ElementFactory.VIEW, 5);
		e8.addElement("Lâmpada do Banheiro", ElementFactory.LAMP, 12, 0, 15, 0);
		this.addEnvironment(e8);

		Environment e9 = new Environment("Dormitório 2");
		e9.addElement("Alarme Ligado", ElementFactory.YESNO, 9, 7);
		e9.addElement("Temperatura do quarto", ElementFactory.VIEW, 6);
		e8.addElement("Lâmpada do quarto", ElementFactory.LAMP, 12, 2, 15, 2);
		e9.addElement("Lâmpada do Banheiro", ElementFactory.LAMP, 12, 0, 15, 0);
		this.addEnvironment(e9);
		
		Environment e10 = new Environment("Sala de Jantar");
		e10.addElement("Lâmpada 1", ElementFactory.LAMP, 11, 3, 14, 3);
		e10.addElement("Lâmpada 2", ElementFactory.LAMP, 11, 4, 14, 4);
		this.addEnvironment(e10);
		
		this.selectEnv.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					int index = selectEnv.getSelectedIndex();
					if (index >= 0) {
						environments.get(atualIndex).close();
						environments.get(index).open();
						atualIndex = index;
					}
				}
			}
		});

		this.environments.get(this.atualIndex).open();
	}

	public void addEnvironment(Environment env) {

		this.environments.add(env);
		this.selectEnv.addItem(env.getName());
		this.add(env);

	}

	public void render() {

	}
}