package core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.*;

public class Communicator implements SerialPortEventListener {

	
	final static int TIMEOUT = 2000;
	
	/*
	 * Port Configuration
	 */
	private CommPortIdentifier portIdentifier;
	
	private SerialPort serialPort = null;
	
	/*
	 * Send and receive data
	 */
    private InputStream input = null;
    
    private OutputStream output = null;
    
	/*
	 * Options
	 */
	private String portName;
	
	private int baudRate;
	

	/**
	 * Set Port Name
	 * @param String port
	 */
	public void setPortName(String portName) {
		this.portName = portName;
	}
	
	/**
	 * Set Baud Rate
	 * @param baudrate
	 */
	public void setBaudRate(int baudRate) {
		this.baudRate = baudRate;
	}
	/**
	 * Connect to the selected port
	 * @return boolean
	 */
	public boolean connect()
	{
		boolean successful = false;
		
		try {

			this.portIdentifier = CommPortIdentifier.getPortIdentifier(this.portName);
			
			this.serialPort = (SerialPort) this.portIdentifier.open(this.portName, TIMEOUT);
			
			this.serialPort.setSerialPortParams(this.baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			
			successful = true;
			
			System.out.println(this.portName + " opened successfully.");
			
		} catch(PortInUseException e) {
			System.err.println(this.portName + " is in use.");
			e.printStackTrace();
		} catch(Exception e) {
			System.err.println("Failed to open " + this.portName);
			e.printStackTrace();
		}
		
		return successful;
	}
	
	/**
	 * Initialize input and output streams
	 * @return boolean
	 */
	public boolean initIOStream()
	{
		boolean successful = false;

        try {
           
            this.input = this.serialPort.getInputStream();
            this.output = this.serialPort.getOutputStream();

            successful = true;
        }
        catch (IOException e) {
        	System.err.println("I/O Streams failed to open. (" + e.toString() + ")");
        	e.printStackTrace();
        }
        
        return successful;
	}
	
	/**
	 * Disconnect the serial port
	 */
	public void disconnect()
    {
        try
        {
            this.serialPort.removeEventListener();
            this.serialPort.close();
            
            if(this.input != null)
            	this.input.close();
            
            if(this.output != null)
            	this.output.close();
            
            System.out.println("Disconnected"); 
             
        } catch (Exception e) {
        	System.err.println("Failed to close");
        	e.printStackTrace();
        }
    }
    
	public void writeData() {
	
	}

	@Override
	public void serialEvent(SerialPortEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
