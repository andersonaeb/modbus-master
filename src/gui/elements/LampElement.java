package gui.elements;

import gui.elements.base.StatusControlElement;

public class LampElement extends StatusControlElement {

	public LampElement() {
		this.setButtonLabel("Ligar", "Desligar");
		this.setStatusLabel("Acesa", "Apagada");
	}
}