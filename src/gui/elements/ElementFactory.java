package gui.elements;

import gui.elements.base.Element;

public final class ElementFactory {

	public final static int LAMP = 1;

	public final static int WATER = 2;

	public final static int VIEW = 3;

	public final static int ALARM = 4;

	public final static int YESNO = 5;
	
	public final static int SEND = 6;

	public static Element get(int type) {

		Element e = null;

		switch (type) {
		case LAMP:
			e = new LampElement();
			break;
		case WATER:
			e = new WaterElement();
			break;
		case VIEW:
			e = new ViewElement();
			break;
		case ALARM:
			e = new AlarmElement();
			break;
		case YESNO:
			e = new YesNoElement();
			break;
		case SEND:
			e = new SendElement();
			break;
		}

		return e;
	}
}
