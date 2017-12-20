package guiPlayer;

import guiTeacher.components.*;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester{
	
	private static final long serialVersionUID = 258186143576427947L;
	private TextField name;
	private TextField price;
	private TextArea newText;
	private Button addButton;
	private FileOpenButton openButton;
	private CatalogMaker catalog;
	
	public CatalogScreen(int width, int height) {
		super(width,height);
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		newText = new TextArea(50,50,200,30,"Here");
		name = new TextField(100,50,200,30, "", "Name");
		price = new TextField(300,50,200,30, "", "Cost");
		price.setInputType(TextField.INPUT_TYPE_NUMERIC);
		addButton = new Button(300,50,75,75, "add", new Action() {
			
			@Override
			public void act() {
				addClicked();
			}
		});
		openButton = new FileOpenButton(50,250,75,75,null,this);
		viewObjects.add(name);
		viewObjects.add(price);
		viewObjects.add(newText);
		viewObjects.add(addButton);
	}
	protected void addClicked() {
		LeagueItems p = new LeagueItems(name.getText(),Integer.parseInt(price.getText()));
		newText.setText(p.name);
		catalog.add(p);
		name.setText("");
		price.setText("");
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
