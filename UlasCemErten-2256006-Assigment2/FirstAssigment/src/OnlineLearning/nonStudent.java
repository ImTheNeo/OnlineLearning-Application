package OnlineLearning;
import java.util.ArrayList;

public class nonStudent extends Trainee implements Performance {
public nonStudent(String name, String email, String password, int age, char gender, ArrayList<Course> enrolled,
			Boolean premium) {
		super(name, email, password, age, gender, enrolled, premium);
		// TODO Auto-generated constructor stub
	}
private String job;
private String position;
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}

public nonStudent(String name, String email, String password, int age, char gender, 
		Boolean premium,String job,String position) {
	super(name, email, password, age, gender,  premium);
	this.job=job;
	this.position=position;
	// TODO Auto-generated constructor stub
}
public float credit() {
	int cnt;
	for(cnt=0;cnt<getEnrolled().size();cnt++) {
		if(getEnrolled().get(cnt).premium==true) {//finding number of premimum courses
			cnt++;
		}
	}
	
	return (float) (cnt*0.4);
}
public float monthlyfee() {
	int cnt;
	for(cnt=0;cnt<getEnrolled().size();cnt++) {// i again calculated i could just call credit again
		if(getEnrolled().get(cnt).premium==true) {
			cnt++;
		}
	}
	
	return (float)2*(10*cnt-(10*cnt-credit()));
}
public nonStudent() {
	super();
}

}
