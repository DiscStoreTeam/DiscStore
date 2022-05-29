package logic.util;

public class ScholarDegree {
	private ScholarDegreeValue value;
	
	//Builders
	public ScholarDegree(int value)
	{
		switch (value) {
		case 0:
			this.value = ScholarDegreeValue.basic;
			break;
		case 1:
			this.value = ScholarDegreeValue.halfSuperior;
			break;
		case 2:
			this.value = ScholarDegreeValue.superior;
		default:
			break;
		}
	}

	//Getters & Setters
	public ScholarDegreeValue getValue() {return value;}
	public void setValue(ScholarDegreeValue value) {this.value = value;}
}
