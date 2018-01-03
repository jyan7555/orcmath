package myStuff;

import java.util.ArrayList;

import guiTeacher.GUIApplication;
import guiTeacher.components.TextLabel;

public class SimonGameJason extends GUIApplication{
	private TextLabel label;
	private ButtonInterfaceJason[] buttonInt;
	private ProgressInterfaceJason progressInt;
	private ArrayList<MoveInterfaceJason> moveInt;
	
	int roundNumber;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;
	
	public SimonGameJason(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initScreen() {
		/*addButtons();
		for(ButtonInterfaceBen b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceX>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);*/

	}
	
	public void addButtons() {
		
	}
	/**
	 * Returns ProgressInterfaceJason
	 * @return
	 */
	public ProgressInterfaceJason getProgress() {
		return null;
	}
	
	
	public static void main(String[] arg) {
		
	}
	
	private MoveInterfaceJason randomMove() {
	    int bIndex = (int)(Math.random()*buttonInt.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*buttonInt.length);
	    }
	    return getMove(bIndex);
	}
	
	private MoveInterfaceJason getMove(int bIndex) {
	    return moveInt.get(bIndex);
	}


}
