package myStuff;

public class MoveJason implements MoveInterfaceJason {
	
	ButtonInterfaceJason button;
	
	public MoveJason(ButtonInterfaceJason button) {
		this.button=button;
	}

	@Override
	public ButtonInterfaceJason getButton() {
		return button;
	}

}