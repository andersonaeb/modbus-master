package modbus;

import core.Communicator;

public class Master {
	
	/**
	 * Serial Communicator
	 */
	private Communicator comm;

	public Master()
	{
		this.comm = new Communicator();
	}

	/**
	 * Set Port Name
	 * @param String port
	 */
	public void setPortName(String portName) {
		this.comm.setPortName(portName);
	}
	
	/**
	 * Set Baud Rate
	 * @param baudrate
	 */
	public void setBaudRate(int baudRate) {
		this.comm.setBaudRate(baudRate);
	}
	

	/**
	 * Open connection
	 * @return boolean
	 */
	public boolean open() {
		boolean successful = false;
		
		successful = this.comm.connect();
		if(successful) {
			this.comm.initIOStream();
		}
		
		return successful;
	}
	
	/**
	 * Close connection
	 */
	public void close() {
		this.comm.disconnect();
	}
}