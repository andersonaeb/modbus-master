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
		
		this.setPreferredSize(new Dimension(700, 600));
		this.setBorder(BorderFactory.createTitledBorder("Residência"));

		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.initPanel();
	}
	
	public void initPanel() {
		
		this.atualIndex = 0;
		
		this.environments = new ArrayList<>();
		
		this.selectEnv = new JComboBox<>();
		this.selectEnv.setPreferredSize(new Dimension(780, 30));
		this.selectEnv.addItem("Selecione o ambiente");
		this.selectEnv.addItemListener (new ItemListener () {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					int index = selectEnv.getSelectedIndex() - 1;
					if(index >= 0) {
						environments.get(atualIndex).close();
						environments.get(index).open();
						atualIndex = index;
					}
		       }
			}
		});
		
		this.add(selectEnv);
		this.add(new JPanel());
		
		this.initEnvironments();
	}
	
	public void initEnvironments() {
		
		Environment e1 = new Environment("Piscina");
		e1.addElement("Luz da Varanda",  ElementFactory.LAMP, 13, 2);
		e1.addElement("Lâmpada 1",		 ElementFactory.LAMP, 13, 3);
		e1.addElement("Lâmpada 1", 		 ElementFactory.LAMP, 13, 4);
		e1.addElement("Lâmpada 3", 		 ElementFactory.LAMP, 13, 5);
		
		this.addEnvironment(e1);
		
		Environment e2 = new Environment("Garagem");
		this.addEnvironment(e2);
	}
	
	public void addEnvironment(Environment env) {
		
		this.environments.add(env);
		this.selectEnv.addItem(env.getName());
		this.add(env);
		
	}
	
	public void render() {
		
	}
}
