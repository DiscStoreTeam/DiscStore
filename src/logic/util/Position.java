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
			position = "Dependiente";
			break;
		default:
			break;
		}
		
		return position;
	}
	
	public static String toString(PositionValue value){
		String position = null;
		switch (value) {
		case manager:
			position = "Administrador";
			break;
		case shiftManager:
			position = "Jefe de Turno";
			break;
		case dependent:
			position = "Dependiente";
			break;
		default:
			break;
		}
		return position;
	}
	
	public static Integer toInt(PositionValue value){
		Integer position = null;
		switch (value) {
		case manager:
			position = 0;
			break;
		case shiftManager:
			position = 1;
			break;
		case dependent:
			position = 2;
			break;
		default:
			break;
		}
		return position;
	}

	//Getters & Setters
	public PositionValue getValue(){return value;}
	public void setValue(PositionValue value){this.value = value;}
}
