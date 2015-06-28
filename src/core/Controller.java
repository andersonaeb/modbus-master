package core;

import java.util.Timer;

import gui.DataControl;
import modbus.Master;

public class Controller {

	private static Controller instance = null;
	
	private Master master;
	
	private DataControl data;
	
	private Timer timerEnvironment;
	
	protected Controller() {
		
		this.master = new Master();
		
		this.data = new DataControl();
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
	
	/**
	 * Data Control
	 * @return {@link DataControl}
	 */
	public DataControl getDataControl() {
		return this.data;
	}
	
	/**
	 * Timer Environment
	 * @return {@link Timer}
	 */
	public Timer getTimerEnvironment() {
		return this.timerEnvironment;
	}
	
	/**
	 * Set Timer Environment
	 * @return {@link Timer}
	 */
	public void setTimerEnvironment(Timer timer) {
		this.timerEnvironment = timer;
	}
	
	/**
	 * Close Application
	 */
	public void close() {
		
		if(this.master != null) {
			this.master.close();
		}
		
		if(this.timerEnvironment != null) {
			this.timerEnvironment.cancel();
		}
		
	}
}
