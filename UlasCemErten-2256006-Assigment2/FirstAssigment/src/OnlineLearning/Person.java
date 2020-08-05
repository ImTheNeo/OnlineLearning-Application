package OnlineLearning;

public abstract class Person {
 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public Person(String name, String email, String password, int age, char gender) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}
	public Person() {
		super();
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
private String name;
 private String email;
 private String password;
 private int age;
 private char gender;
 
}
