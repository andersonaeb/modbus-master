package core;

import modbus.Master;

public class Controller {

	private static Controller instance = null;
	
	private Master master;
	
	protected Controller() {
		
		this.master = new Master();
		
	}
	
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		
		return instance;
	}

	/**
	 * Modbus Master
	 * @return {@link Master}
	 */
	public Master getModbusMaster() {
		return this.master;
	}
}
