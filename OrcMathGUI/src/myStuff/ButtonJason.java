package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJason extends Button implements ButtonInterfaceJason {
	
	private boolean button = false;
	private Color color;


	public ButtonJason(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		update();
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		this.setBackground(color);
		update();
	}

	@Override
	public void highlight() {
		this.setColor(Color.WHITE);
		update();
	}

	@Override
	public void dim() {
		this.setColor(color);
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		drawShape(g, hover);
		g.setColor(getForeground());
	}

	@Override
	public void setX(double d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		
	}

}