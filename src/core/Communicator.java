package core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.TooManyListenersException;

import gnu.io.*;

public class Communicator implements SerialPortEventListener {

	
	final static int TIMEOUT = 2000;
	
	final static int NEW_LINE_ASCII = 10;
	
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
    
    private String response = null;
    
	/*
	 * Options
	 */
	private String portName;
	
	private int baudRate;
	
	private boolean connected = false;
	

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
			
			this.connected = true;
			
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
	 * Event listener for the serial port that knows when data is received
	 */
    public void initListener()
    {
        try
        {
            this.serialPort.addEventListener(this);
            this.serialPort.notifyOnDataAvailable(true);
        }
        catch (TooManyListenersException e)
        {
        	e.printStackTrace();
        }
    }
	
    /**
     * Get status connection
     * @return
     */
    public boolean getConnected() {
    	return this.connected;
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
   
	/**
	 * Write serial data
	 * @param data
	 */
	public void writeData(String data) {
		try {
			this.output.write(data.getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Processing on the data it reads
	 */
    public void serialEvent(SerialPortEvent evt) {

        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE)
        {
        	byte[] buffer = new byte[1024];
        	int data, size;
        	String response;
            
            try
            {
            	size = 0;
                while ((data = input.read()) > -1) {
                    
                	if (data == '\n') break;
                    buffer[size++] = (byte) data;
                }
                
                response = new String(buffer, 0, size);
                this.response = response;
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Get response from serial port
     * @return
     */
    public String getResponse() {
    	return this.response;
    }
}