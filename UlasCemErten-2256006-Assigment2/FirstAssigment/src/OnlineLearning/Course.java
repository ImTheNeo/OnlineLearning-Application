package OnlineLearning;

public class Course {
public Instructor instructor;
public String name;
public Float duration;
public Course(Instructor instructor, String name, Float duration, Boolean premium) {
	super();
	this.instructor = instructor;
	this.name = name;
	this.duration = duration;
	this.premium = premium;
}
public Boolean premium;
public Course() {
	super();
}


}
