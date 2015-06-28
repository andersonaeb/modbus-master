package modbus;

import core.Controller;

public class ReadDataThread implements Runnable {

	public void run() {
		try {
			while (true) {
				this.readData();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			
		}
	}
	
	public void readData() {
		Master master = Controller.getInstance().getModbusMaster();
		master.readData(0, Master.TOTAL_REG);
		
		ResponseData response = new ResponseData(master.getDataReceived());
		response.sendDataControl();
	}
}
