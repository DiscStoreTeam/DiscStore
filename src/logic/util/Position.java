package logic.util;

public class Position {
	private PositionValue value;
	
	//Builders
	public Position(PositionValue value)
	{
		this.value = value;
	}
	
	//Methods
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String position = null;
		
		switch (value) {
		case manager:
			position = "Administrador";
			break;
		case shiftManager:
			position = "Jefe de Turno";
			break;
		case dependent:
			position = "Dependeinte";
			break;
		default:
			break;
		}
		
		return position;
	}

	//Getters & Setters
	public void setValue(PositionValue value){this.value = value;}
}
