package guiPlayer;

import java.util.List;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen{
	
	private static final long serialVersionUID = 258186143576427947L;
	private TextField text;
	
	public CatalogScreen(int width, int height) {
		super(width,height);
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text = new TextField(40,40,200,30, "Text goes here", "Description");
		viewObjects.add(text);
	}
	
	

}
