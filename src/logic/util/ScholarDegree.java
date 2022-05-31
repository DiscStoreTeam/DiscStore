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

	public Integer toInt()
	{
		Integer degree = null;

		switch (value) {
		case basic:
			degree = 0;
			break;
		case halfSuperior:
			degree = 1;
			break;
		case superior:
			degree = 2;
			break;
		default:
			break;
		}

		return degree;
	}

	//Getters & Setters
	public ScholarDegreeValue getValue(){return value;}
	public void setValue(ScholarDegreeValue value) {this.value = value;}
}
