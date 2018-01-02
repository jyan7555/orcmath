package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.*;

public class CustomButton extends Button {
	
	private String str1;
	private String str2;
	private Color color;
	

	public CustomButton(int x, int y) {
		super(x, y, 70, 50, "", null);
		// TODO Auto-generated constructor stub
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setColor(Color.black);
		g.drawString(str1, 50,50);
		g.drawString(str2, 50, 50);
		g.drawRect(50, 50, 100, 100);
	}
	
	public void updateString1(String string) {
		
	}

	public void updateString2(String string) {
		
	}

	public void setIconColor(Color color) {
		
	}
}
