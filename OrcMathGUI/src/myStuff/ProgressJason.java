package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import com.itextpdf.text.Font;

import guiTeacher.components.Component;

public class ProgressJason extends Component implements ProgressInterfaceJason {
	private int roundNum;
	private int sequenceNum;
	private boolean lose;
	
	
	public ProgressJason(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void gameOver() {
		lose = true;
		update();

	}

	@Override 
	public void update(Graphics2D g) {
		clear();
		if(lose) {
			g.setColor(Color.RED);
			g.fillRect(300, 0, 200, 100);
			g.setColor(Color.black);
			g.drawString("Round: "+roundNum,10,55);
			g.drawString("Current Sequence Length: "+sequenceNum,5,100);
			g.drawString("You lost!",5,150);
		}else {
			g.setColor(Color.GREEN);
			g.fillRect(300, 0, 200, 100);
			g.setColor(Color.black);
			g.drawString("Round: "+roundNum,5,55);
			g.drawString("Current Sequence Length: "+sequenceNum,5,100);
		}

	}


	@Override
	public void setRound(int x) {
		roundNum = x;
	}

	@Override
	public void setSequence(int x) {
		sequenceNum = x;
	}




}