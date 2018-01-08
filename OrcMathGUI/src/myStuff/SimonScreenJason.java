
package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJason extends ClickableScreen implements Runnable{
	private TextLabel label;
	private ButtonInterfaceJason[] buttonInt;
	private ProgressInterfaceJason progressInt;
	private ArrayList<MoveInterfaceJason> sequence;
	
	int roundNumber;
	int numberOfButtons;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;
	private Color[] colors;
	
	public SimonScreenJason(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		numberOfButtons = 5;
		colors = new Color[numberOfButtons];
		buttonInt = new ButtonInterfaceJason[numberOfButtons];
		colors[0] = Color.blue;
		colors[1] = Color.red;
		colors[2] = Color.yellow;
		colors[3] = Color.green;
		colors[4] = Color.cyan;
		app.start();
	}

	public void initScreen() {

	}
	public void addButtons() {
		for (int i=0; i < numberOfButtons; i++) {
			final ButtonInterfaceJason b= getAButton();
			b.setColor(colors[i]);
			b.setX(5*Math.cos(72*i));
			b.setY(5*Math.sin(72*i));
			b.setAction(new Action() {
				public void act() {
					if (acceptingInput) {
						Thread blink = new Thread(new Runnable(){

							public void run(){
								b.highlight();
								try {
								Thread.sleep(800);
								} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								}
								b.dim();
							}

							}
						
						);
						blink.start();
						if (b == sequence.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						}
						else {
							progressInt.gameOver();
						}
						if(sequenceIndex == sequence.size()){ 
						    Thread nextRound = new Thread(SimonScreenJason.this); 
						    nextRound.start(); 
						}
					}
				}
			});
			buttonInt[i] = b;	
		}
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
	    return null;
	}
	
	/**
	Placeholder until partner finishes implementation of ButtonInterface	
	*/
	private ButtonInterfaceJason getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	//

	@Override

	public void run(){
		label.setText("");
		nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		sequence.add(randomMove());
		progressInt.setRound(roundNumber);
		progressInt.setSequence(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceJason b = null;
		for(int i = 0; i < sequence.size(); i++) {
			if(b != null) {
				b.dim();
				b = sequence.get(i).getButton();
				b.highlight();
				int sleepTime = (10000 - (roundNumber * 100)) + 1000;
				try {
					Thread.sleep(sleepTime);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				b.dim();
			}
		}
	}

	private void changeText(String string) {
		label.setText(string);
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}

}
