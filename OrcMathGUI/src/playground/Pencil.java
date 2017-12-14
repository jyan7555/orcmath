package playground;

import java.awt.Color;
import java.awt.Graphics2D;


import guiTeacher.components.Component;

public class Pencil extends Component {

	public Pencil(int x, int y, int w, int h) {
		super(40, 40, 100, 100);
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.drawRect(0, 0, getWidth(), getHeight());
	}

}
