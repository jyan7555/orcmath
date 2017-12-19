package guiPlayer;

import guiPlayer.Sampler.SampleScreen;
import guiTeacher.GUIApplication;

class CatalogMakerGUI extends GUIApplication{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) {
		Sampler sample = new Sampler(800, 550);
		Thread go = new Thread(sample);
		go.start();
	}
		
	public CatalogMakerGUI(int height, int width) {
		super(height,width);
		setVisible(true);
	}


	@Override
	public void initScreen() {
		CatalogScreen screen = new CatalogScreen(getWidth(),getHeight());
		setScreen(screen);
	}

}
