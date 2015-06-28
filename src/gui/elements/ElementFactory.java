package gui.elements;

public final class ElementFactory {
	
	public final static int LAMP = 1;
	
	public final static int VIEW_BYTE = 2;
	
	public final static int VIEW_BIT = 3;
	
	public static Element get(int type) {
		
		Element e = null;
		
		switch(type) {
			case LAMP:
				e = new LampElement();
				break;
		}
		
		return e;
	}
}
