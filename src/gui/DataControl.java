package gui;

import java.math.BigInteger;

import core.Controller;
import modbus.Master;

public class DataControl {
	
	private int[] data;
	
	public DataControl() {
		
		this.reset();
	}
	
	public void reset() {
		this.data = new int[Master.TOTAL_REG];
		
		for(int i=0; i < this.data.length; i++) {
			data[i] = 0;
		}
	}
	
	public void setData(int[] data) {
		this.data = data;
	}
	
	public void setValue(int regDest, int value) {
		Controller.getInstance().getModbusMaster().writeData(regDest, value);
	}
	
	public void setValue(int regDest, int bitDest, int value) {
		
		String binAddr = Integer.toBinaryString(this.data[regDest]);
		String binary = String.format("%08d", new BigInteger(binAddr));
		
		binary = binary.substring(0, 8-bitDest-1) + value + binary.substring(8-bitDest);
		value  = Integer.parseInt(binary, 2);
		this.data[regDest] = value;
		
		Controller.getInstance().getModbusMaster().writeData(regDest, value);
	}
	
	public int getValue(int regDest) {
		return data[regDest];
	}
	
	public int getValue(int regDest, int bitDest) {
		
		String binAddr = Integer.toBinaryString(data[regDest]);
		String binary = String.format("%08d", new BigInteger(binAddr)); 
		
		return Integer.parseInt(binary.substring(8-bitDest-1, 8-bitDest));
	}
}