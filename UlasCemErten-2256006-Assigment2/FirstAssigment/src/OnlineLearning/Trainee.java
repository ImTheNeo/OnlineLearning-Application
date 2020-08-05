package OnlineLearning;
import java.util.ArrayList;
//for this class there are just constructors , getters and setters for enrolling course
public class Trainee extends Person {
private ArrayList<Course> enrolled = new ArrayList<Course>();
public ArrayList<Course> getEnrolled() {
	return enrolled;
}

public void setEnrolled(Course a) {
	enrolled.add(a);
}

public void delEnrolled(int cnt) {
	enrolled.remove(cnt);
}

private Boolean premium;

public Boolean getPremium() {
	return premium;
}

public void setPremium(Boolean premium) {
	this.premium = premium;
}

public Trainee(String name, String email, String password, int age, char gender, ArrayList<Course> enrolled,
		Boolean premium) {
	super(name, email, password, age, gender);
	this.enrolled = enrolled;
	this.premium = premium;
}
public Trainee(String name, String email, String password, int age, char gender, 
		Boolean premium) {
	super(name, email, password, age, gender);
		this.premium = premium;
}
public Trainee() {
	super();
}

	
}
