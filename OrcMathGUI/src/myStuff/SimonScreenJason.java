package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJason extends ClickableScreen implements Runnable {

	private static TextLabel label;
	private ProgressInterfaceJason progress;
	private ArrayList<MoveInterfaceJason > moveList;
	private ButtonInterfaceJason [] buttons;
	private int roundNum;
	private boolean validInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	private Color[] colors;
	
	public SimonScreenJason(int width, int height) {
		super(width, height);
		Thread app= new Thread(this);
		app.start();
	}
	public void run() {
		 label.setText("");
	     nextRound();
		
	}
	private void nextRound() {
		validInput = false;
		roundNum++;
		moveList.add(randomMove());
		progress.setRound(roundNum);
		progress.setSequence(moveList.size());
		changeText("Simon's Turn");
		label.setText("");
		playSequence();
		changeText("Your Turn");
		validInput = true;
		sequenceIndex = 0;
		
	}

	private void playSequence() {
		ButtonInterfaceJason  b = null;
		for(int i = 0; i < moveList.size(); i++) {
			if(b != null) {
				b.dim();
				b = moveList.get(i).getButton();
				b.highlight();
				
				try {
	                Thread.sleep((int)(1000*roundNum));
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
				b.dim();
			}
		}
		
		
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceJason  b:buttons) {
			viewObjects.add(b);
		}
		progress = getProgress();
		label= new TextLabel(10,30,200,200,"testing");
		moveList= new ArrayList<MoveInterfaceJason >();
		lastSelectedButton=-1;
		moveList.add(randomMove());
		moveList.add(randomMove());
		for(int i = 0; i < sequenceIndex; i++) {
			moveList.add(randomMove());
		}
		roundNum=0;
		progress.setRound(roundNum);
		viewObjects.add(progress);
		viewObjects.add(label);
	

	}
	private MoveInterfaceJason  randomMove() {
		int random= (int)(Math.random()*buttons.length);
		while(random==lastSelectedButton) {
			random=(int)(Math.random()*buttons.length);
		}
		return getMove(random);
	}
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceJason  getMove(int random) {
		return new MoveJason(buttons[random]);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/

	private ProgressInterfaceJason getProgress() {
		return new ProgressJason(100, 100, 200, 200);
	}

	private void addButtons() {
		
		colors = new Color[4];
		colors[0] = Color.RED;
		colors[1] = Color.GREEN;
		colors[2] = Color.BLUE;
		colors[3] = Color.CYAN;
		buttons= new ButtonInterfaceJason [4];
		
		for(int i=0;i<buttons.length;i++) {
			final ButtonInterfaceJason b = getAButton(100,i*50+50,50,50);
			b.setColor(colors[i]);
			b.setAction(new Action() {
				
				@Override
				public void act() {
					if(validInput) {
						Thread blink= new Thread(new Runnable() {
							
							@Override
							public void run() {
								b.highlight();
								try{
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == moveList.get(sequenceIndex).getButton()) {
		    		    	sequenceIndex++;
		    		    }
		    		    else {
		    		    	progress.gameOver();
		    		    }
		    		    if(sequenceIndex == moveList.size()){
		    		        Thread nextRound = new Thread(SimonScreenJason.this);
		    		        nextRound.start();
		    		    }
							
					}
				}
			});
			buttons[i]=b;
		}
	}
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	 * @param j 
	 * @param i 
	*/

	private ButtonInterfaceJason  getAButton(int x, int y,int w,int h) {
		return new ButtonJason(x, y, w, h, "",null);	
	}

	

	
	public static TextLabel getLabel() {
		return label;
	}
	

	private void changeText(String string) {
		label.setText(string);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
	}
	}

	

}
