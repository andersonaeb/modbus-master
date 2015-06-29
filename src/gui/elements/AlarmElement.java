package gui.elements;

import gui.elements.base.StatusControlElement;

public class AlarmElement extends StatusControlElement {

	public AlarmElement() {
		this.setButtonLabel("Ligar", "Desligar");
		this.setStatusLabel("Ligado", "Desligado");
	}
}