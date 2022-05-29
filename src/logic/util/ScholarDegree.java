package logic.util;

public class ScholarDegree {
	private ScholarDegreeValue value;
	
	//Builders
	public ScholarDegree(ScholarDegreeValue value)
	{
		this.value = value;
	}
	
	//Methods
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String degree = null;
		
		switch (value) {
		case basic:
			degree = "Básico";
			break;
		case halfSuperior:
			degree = "Medio Superior";
			break;
		case superior:
			degree = "Superior";
			break;
		default:
			break;
		}
		
		return degree;
	}

	//Getters & Setters
	public void setValue(ScholarDegreeValue value) {this.value = value;}
}
