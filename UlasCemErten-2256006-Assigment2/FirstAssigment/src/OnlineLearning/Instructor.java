package OnlineLearning;

public class Instructor extends Person {
	public int ID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Instructor(String name, String email, String password, int age, char gender, int iD) {
		super(name, email, password, age, gender);
		ID = iD;
	}

	public Instructor() {
		super();
	}
	
	
	
}
