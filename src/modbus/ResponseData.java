package modbus;

import core.Controller;

public class ResponseData {

	private int type;
	
	private String response;
	
	public ResponseData(String response) {

		this.response = response;
		
		if(this.response != null) {
			
			try {
				// Function modubs
				this.type = Integer.parseInt(this.response.substring(3, 5));
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendDataControl() {
		
		if(this.type == Master.FUNC_READ) {
			
			int[] data = new int[Master.TOTAL_REG];
			int start = 7;
			
			for(int i=0; i < Master.TOTAL_REG; i++) {
				data[i] = Integer.parseInt(this.response.substring(start, start + 4), 16);
				start += 4;
			}
			
			Controller.getInstance().getDataControl().setData(data);
		}
	}
}
