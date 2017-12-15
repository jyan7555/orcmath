package playground;


import java.awt.Color;
import java.awt.Graphics2D;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class LeagueItems extends AnimatedComponent {
	private String name;
	private int cost;
	private String imgPic;
	
	public LeagueItems(String name, int cost, String imgPic) {
		super(40, 40, 255, 255);
		
		this.imgPic = imgPic;
		this.name = name;
		this.cost = cost;
		
		addSequence("resources/sprite2.png", 150, 0, 0, 255, 255, 6);
		Thread animation = new Thread(this); 
		animation.start();
		update();
		//super.update(g);
	}


	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.RED);
		super.update(g);
		//g.fillRect(40, 40, getWidth(), getHeight());
	}
	public String toString() {
		return name + "," + cost;
	}

}