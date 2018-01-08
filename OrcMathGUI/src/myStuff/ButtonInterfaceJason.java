package myStuff;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceJason extends Clickable {
	void setColor(Color color);
	void setX(double d);
	void setY(double y);
	void setAction(Action a);
	void dim();
	void highlight();
}
