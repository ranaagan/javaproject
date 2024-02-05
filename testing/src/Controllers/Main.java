package Controllers;

import Views.SwingWindow;

public class Main {

	public static void main(String[] args) {
		SwingWindow window = new SwingWindow();

		SwingWindowViewController controller = new SwingWindowViewController(window);
		
	}

}
