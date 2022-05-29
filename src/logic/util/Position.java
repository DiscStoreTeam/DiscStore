package logic.util;

public class Position {
	private PositionValue value;
	
	//Builders
	public Position(int value)
	{
		switch (value) {
		case 0:
			this.value = PositionValue.manager;
			break;
		case 1:
			this.value = PositionValue.shiftManager;
			break;
		case 2:
			this.value = PositionValue.dependent;
		default:
			break;
		}
	}

	//Getters & Setters
	public PositionValue getValue() {return value;}
	public void setValue(PositionValue value) {this.value = value;}
}
