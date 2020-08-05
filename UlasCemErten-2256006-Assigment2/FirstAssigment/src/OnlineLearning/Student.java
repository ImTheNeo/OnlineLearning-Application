package OnlineLearning;
import java.util.ArrayList;

public class Student extends Trainee implements Performance {
	
public Student(String name, String email, String password, int age, char gender, ArrayList<Course> enrolled,
			Boolean premium) {
		super(name, email, password, age, gender, enrolled, premium);
		// TODO Auto-generated constructor stub
	}
private String institution;

public String getInstitution() {
	return institution;
}

public void setInstitution(String institution) {
	this.institution = institution;
}

public float credit() {
	int cnt;
	for(cnt=0;cnt<getEnrolled().size();cnt++) {
		if(getEnrolled().get(cnt).premium==true) {
			cnt++;
		}
	}
	
	return (float) (cnt*0.8);
}
public float monthlyfee() {
	int cnt;
	for(cnt=0;cnt<getEnrolled().size();cnt++) {
		if(getEnrolled().get(cnt).premium==true) {
			cnt++;
		}
	}
	
	return (float)10*cnt-(10*cnt-credit());
}
public Student(String name, String email, String password, int age, char gender, 
		Boolean premium,String institution) {
	super(name, email, password, age, gender,  premium);
	this.institution=institution;
	// TODO Auto-generated constructor stub
}
public Student() {
	super();
}
}
