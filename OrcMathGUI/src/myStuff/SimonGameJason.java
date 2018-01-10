
package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameJason extends GUIApplication {
	
	static SimonGameJason game = new SimonGameJason(6000,600);

	public SimonGameJason(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenJason screen = new SimonScreenJason(600,600);
		setScreen(screen);

	}

	public static void main(String[] args) {
		Thread go= new Thread(game);
		go.start();
	}

}