package modbus;

import gui.DataControl;
import core.Communicator;
import core.Controller;

public class Master {
	
	public final static int SLAVE_ADDR = 0x3A;
	
	public final static int FUNC_WRITE = 0x06;
	
	public final static int FUNC_READ = 0x03;
	
	public final static int TOTAL_REG = 17;
	
	/**
	 * Serial Communicator
	 */
	private Communicator comm;

	private Thread readDataThread;
	
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
		
		if(this.comm.connect() == true) {
			if(this.comm.initIOStream()) {
				
				this.comm.initListener();
				
				this.start();
				
				successful = true;
			}
		}
		
		return successful;
	}
	
	/**
	 * Close connection
	 */
	public void close() {
		if(this.comm.getConnected()) {
			
			try {
				
				this.comm.disconnect();
			
				this.readDataThread.interrupt();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
 
	/**
	 * Generate checksum to LRC ASCII
	 * @param checksum
	 * @return
	 */
	private int[] buildChecksum(int[] checksum) {
		
		int sum = 0;
		int[] result = new int[2];

		for(int i=0; i < checksum.length; i++) {
			sum += checksum[i];
		}

		sum = 0xFF - sum + 1;
		
		result[0] = sum / 16;
		result[1] = sum % 16;

		return result;
	}
	
	public String buildMessage(int register, int data, int funct) {
		
		String message = ":";
		
		int checksum[] = new int[6];
		
		String strRegister = String.format("%04X", register);
		String strData = String.format("%04X", data);
		
		// Slave Address
		message += Integer.toHexString(SLAVE_ADDR);
		checksum[0] = SLAVE_ADDR;
		
		// Function
		message += String.format("%02X", funct);
		checksum[1] = funct;
		
		// Register Address
		message += strRegister;
		checksum[2] = Integer.parseInt(strRegister.substring(0, 2), 16);
		checksum[3] = Integer.parseInt(strRegister.substring(2, 4), 16);
		
		// Data(06) Quantity(03)
		message += strData;
		checksum[4] = Integer.parseInt(strData.substring(0, 2), 16);
		checksum[5] = Integer.parseInt(strData.substring(2, 4), 16);
		
		int[] c = this.buildChecksum(checksum);
		
		// Checksum
		message += Integer.toHexString(c[0]);
		message += Integer.toHexString(c[1]);
		
		// CR-LF
		message += "\r\n";
		
		return message.toUpperCase();
	}
	
	/**
	 * Write data in modbus slave
	 * @param register
	 * @param data
	 */
	public void writeData(int register, int data) {
		
		String message = this.buildMessage(register, data, FUNC_WRITE);
		System.out.println(message);
		
		this.comm.writeData(message);
	}

	/**
	 * Read from modbus slave
	 * @param startRegister
	 * @param size
	 */
	public void readData(int startRegister, int size) {
		
		String message = this.buildMessage(startRegister, size, FUNC_READ);
		//System.out.println(message);
		
		this.comm.writeData(message);
	}
	
	/**
	 * Get response serial read
	 * @return
	 */
	public String getDataReceived() {
		return this.comm.getResponse();
	}
	
	public void run(String f) {
		
		String a[] = f.split(" ");
		int reg = Integer.parseInt(a[0]);
		int bit = Integer.parseInt(a[1]);
		
		DataControl dc = Controller.getInstance().getDataControl();
		
		if(bit != -1) {
			System.out.println(dc.getValue(reg, bit));
		} else {
			System.out.println(dc.getValue(reg));
		}
	}
	
	public void start() {
		
		this.readDataThread = new Thread(new ReadDataThread());
		this.readDataThread.start();
		
	}
}