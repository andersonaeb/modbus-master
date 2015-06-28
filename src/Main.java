import core.Controller;
import gui.MainWindow;

public class Main {

	public static void main(String[] args) {

		final MainWindow mainWindow = new MainWindow();
		
		mainWindow.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	Controller.getInstance().close();
		    }
		});
	}
}