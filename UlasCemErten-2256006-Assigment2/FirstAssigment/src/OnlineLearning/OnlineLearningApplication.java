package OnlineLearning;
import java.util.ArrayList;

import java.util.Scanner;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
/*Student ID : 2256006
 *Name       : Ulas Cem Erten
 *Some information about  :
 *Greetings hocam as i told you to to access instituon , job and position instead of  to declare just trainee list , i decleared nonstudents and students arraylists.
 *Thats why some of my functions are void as you will.
 */
public class OnlineLearningApplication extends JFrame {
	static String sort_words=" ";
	//Button for the log In
	JButton Control=new JButton("Add,Del,and View Courses");
	JButton instruct_details=new JButton("Show Instructor Details");
	JButton display_fees=new JButton("Display_Fee");
	JButton Pre=new JButton("PRENIUM CHANGE");
	JButton log_out=new JButton("LOG_OUT");
	
	//for the landing screen button
	JButton Sign=new JButton("SIGN UP");
	JButton Log=new JButton("LOG IN");
	JButton Exit=new JButton("EXIT");
	JButton Next=new JButton("NEXT");
	JButton Enter=new JButton("ENTER");
	//for sign in screen 
	JRadioButton Male=new JRadioButton ();
	JRadioButton Female=new JRadioButton ();
	JCheckBox Student=new JCheckBox();
	JCheckBox Non_Student=new JCheckBox();
	JTextField User_Name=new JTextField("",12);
	JTextField Email=new JTextField("",12);
	JTextField Password=new JTextField("",12);
	JTextField Job=new JTextField("",12);
	JTextField Position=new JTextField("",12);
	JTextField Institution=new JTextField("",12);
	JRadioButton pre=new JRadioButton();
	//for the log in request from user
	JTextField password_input=new JTextField("",12);
	JTextField email_input=new JTextField("",12);
	JButton Move=new JButton("Enter");
	////////////////
	JTextArea enroll_detail =new JTextArea(13,13); 
	JTextArea ALL_roll_detail =new JTextArea(20,20);
	JTextField Courses_input=new JTextField("",12);
	JButton add_courses=new JButton("ADD Courses");
	JButton del_courses=new JButton("REMOVE Courses");
	JButton back_manage=new JButton("Back");
	
	
	
	///The panels //
	JPanel first=new JPanel();
	JPanel Sign_Panel=new JPanel();
	 JPanel log_in_form=new JPanel();
	JPanel login_Panel=new JPanel();
	JPanel Control_Panel=new JPanel();
	JPanel instruct_detail=new JPanel();
	//JPanel fee_details=new JPanel();
	///
	public static  CardLayout card=new CardLayout();
	public static  JPanel container=new JPanel();
	//for the move/
	//public static Trainee hold;
	public static int holdnumber;//this number is to find which member after logged in
	public static int holdcheck;// this is for the to find if member is student or non_student
	public static Student shold;// I used this sometimes after logged in to hold and make modification after logged in
	public static nonStudent nshold;// same as above line
	public static ArrayList<Instructor> instructors = new ArrayList<Instructor>(); // instructors list
	//public static ArrayList<Trainee> trainee = new ArrayList<Trainee>();// I used this in the beginning but i modified my code to access institution ,job and position if it is needed
	public static ArrayList<Student> students = new ArrayList<Student>();//students lists
	public static ArrayList<nonStudent> nonstudents = new ArrayList<nonStudent>();//non students lists
	public static ArrayList<Course> courses = new ArrayList<Course>();//courses lists
	private static Scanner input;
	private static Scanner input2;
	private static Scanner input3;
	private static Scanner input4;
	@SuppressWarnings("unlikely-arg-type")
	public static void viewallinstructors() {
		int cnt;
		sort_words=" ";
		Instructor pinst = new Instructor();
		for(cnt=0;cnt<instructors.size();cnt++) {//displaying  all the instructors
			pinst = instructors.get(cnt);
			sort_words=sort_words + " "+"Name : "+pinst.getName()+" "+"Email : "+pinst.getEmail()+" "+ "Age : "+pinst.getAge()+" "+"ID : "+pinst.getID()+" "+"Gender : "+pinst.getGender()+" " +" \n";
		}
	}
	////////////////////////////////////
	public static void deleteCourse(String cname) { 
		input = new Scanner(System.in);
		//System.out.println("enter the course name you want to delete");
		//listEnrolledCourses();
		//String cname = input.next();
		if(holdcheck==1) {
			int cnt;
			nonStudent ps = new nonStudent();
			ps=nonstudents.get(holdnumber);
			
			for(cnt=0;cnt<ps.getEnrolled().size();cnt++) {
				if(cname.equals(ps.getEnrolled().get(cnt).name)) {
					//ts.getEnrolled().get(cnt1).name
					nonstudents.get(holdnumber).delEnrolled(cnt);
					return ;// i returned here if the courses found if it is not found it will not be returned
				}
			}
			System.out.println("You are not registered for this course!");
		}
		if(holdcheck==0) {// if the user is student
			int cnt;
			Student ps = new Student();
			ps=students.get(holdnumber);
			
			for(cnt=0;cnt<ps.getEnrolled().size();cnt++) {
				if(cname.equals(ps.getEnrolled().get(cnt).name)) {
					//ts.getEnrolled().get(cnt1).name
					students.get(holdnumber).delEnrolled(cnt); 
					return ;
				}
			}
			System.out.println("You are not registered for this course!");
		}
	}
	public static void changeToPremium(boolean check) {
		input=new Scanner(System.in);
		//int check;
		if(holdcheck==0) {// if the user is student
			//System.out.println("Are you sure to Change Your Account to Premium ?\n1.Yes 0.No");
			//check=input.nextInt();
			if(check==true) {
				if(students.get(holdnumber).getPremium()==false) {
				
				students.get(holdnumber).setPremium(true);
				System.out.println("Congrulations now you are a premium member!!");
				}
				else
				System.out.println("Your Account is already Premium");
				
			}
			else
			System.out.println("Our suggestion is to change your account to premium");
			
			
		}
		if(holdcheck==1) {
			
			//System.out.println("Are you sure to Change Your Account to Premium ?\n1.Yes 0.No");
			//check=input.nextInt();
			if(check==false) {
				if(nonstudents.get(holdnumber).getPremium()==false) {
				System.out.println("Congrulations now you are a premium member!!");
				nonstudents.get(holdnumber).setPremium(true);
				
				}
				else
				System.out.println("Your Account is already Premium");
				
			}
			else
			System.out.println("Our suggestion is to change your account to premium");
		}
	}
	public static void listEnrolledCourses() {
		if(holdcheck==1) {
		int cnt;
		nonStudent ps = new nonStudent();
		ps=nonstudents.get(holdnumber);
		
		for(cnt=0;cnt<ps.getEnrolled().size();cnt++) {
			sort_words=sort_words+" "+ps.getEnrolled().get(cnt).name+"\n";
		}
		}
		if(holdcheck==0) {
			int cnt1;
			Student ts = new Student();
			ts=students.get(holdnumber);
			
			for(cnt1=0;cnt1<ts.getEnrolled().size();cnt1++) {
				sort_words=sort_words+" "+ts.getEnrolled().get(cnt1).name+"\n";
			}
			
		}
	}
	public static void addCourse(String acourse) {
		int cnt,acnt;
		input = new Scanner(System.in);
	//String acourse;
	//System.out.println("Enter the course you want to add");
		//listAllCourses();
		//acourse=input.next();
		Course ccourse = new Course();
		int checkifcourseisnotfound=0;
		for(cnt=0;cnt<courses.size();cnt++){
			ccourse = courses.get(cnt);
			if(acourse.equals(ccourse.name)){
				if(holdcheck==1) {//this is for non student
					for(acnt=0;cnt<nonstudents.get(holdnumber).getEnrolled().size();acnt++) {//to check if a course is registered
						if(acourse.equals(nonstudents.get(holdnumber).getEnrolled().get(acnt).name)) {
							System.out.print("you have already been registered for this course. ");
							return;
						}
					}
					checkifcourseisnotfound++;
					if(ccourse.premium==true&&nonstudents.get(holdnumber).getPremium()==false) {//non premium member can not register premium course it is not seen on the list but he should also not register
						System.out.print("This course is only for premium member. Wish you to see as a premium member ");
						return;
					}
					nonstudents.get(holdnumber).setEnrolled(ccourse);
				}
				else if(holdcheck==0) {//this is for student
					for(acnt=0;acnt<students.get(holdnumber).getEnrolled().size();acnt++) {//to check if a course is registered
						if(acourse.equals(students.get(holdnumber).getEnrolled().get(acnt).name)) {
							System.out.print("you have already been registered for this course. ");
							return;
						}
					}
					checkifcourseisnotfound++;
					if(ccourse.premium==true&&students.get(holdnumber).getPremium()==false) {//non premium member should not register premium course
						System.out.print("This course is only for premium member. Wish you to see as a premium member. ");
						return;
					}
					students.get(holdnumber).setEnrolled(ccourse);
				}
			}
		}
		if(checkifcourseisnotfound==0) {
			System.out.println("There is no such a course as you entered");
		}
		
	}
	public static void logout() {
		System.out.println("you logged out sucsessfully!");
		Menu();
	}
	public static void getInstructorDetails() {
		input2 = new Scanner(System.in);
		int cnt,iid;
		Instructor pinst = new Instructor();
		for(cnt=0;cnt<instructors.size();cnt++) {//displaying  all the instructors
			pinst = instructors.get(cnt);
			System.out.println("name : " + pinst.getName() +" id : "+pinst.getID()  );
		}
		System.out.print("Enter the instructors id you want to display.");
		iid = input2.nextInt();
		for(cnt=0;cnt<instructors.size();cnt++) {
			pinst = instructors.get(cnt);
			if(iid==pinst.getID()) {
				
				System.out.println("Name : "+pinst.getName()+" ");
				System.out.println("Email : "+pinst.getEmail()+" ");
				System.out.println("Age : "+pinst.getAge()+" ");
				System.out.println("ID : "+pinst.getID()+" ");
				System.out.println("Gender : "+pinst.getGender()+" ");
				return;
			}
		}
		System.out.println("Instructor's id is not found");
		
	}
	public static void signUp(String t1name,String t1email,String t1password,String t1job,String t1pos,String t1inst,int checkstudent,char t1gender,boolean t1pre){
		int cnt;
		input = new Scanner(System.in);
		
		String checkstudent1;
		
		
		int t1age=10;
		
		System.out.println("Are you student ? \n 0 : Yes \n 1 : No");
	/*	checkstudent1 = input.next();
		
		if(checkstudent1.equals("0"))
			checkstudent=0;
		if(checkstudent1.equals("1"))
			checkstudent=1;*/
		
		if(checkstudent==1) {
		/*System.out.print("enter your name : ");
		t1name = input.next();
		System.out.print("enter your email account : ");
		t1email = input.next();*/
		/*for(cnt=0;cnt<nonstudents.size();cnt++) {
			while(t1email.equals(nonstudents.get(cnt).getEmail())) {//for correct input
				System.out.println("We already have a member with this e-mail account.Please enter your mail account again.\nIf you dont have a email account just type 0 to go to menu again");
				
				t1email = input.next();
				if(t1email.equals("0")) {
					return ;
				}
					
			}
		}*/
		/*for(cnt=0;cnt<students.size();cnt++) {
			while(t1email.equals(students.get(cnt).getEmail())) {//for correct input
				System.out.println("We already have a member with this e-mail account.Please enter your mail account again.\nIf you dont have a email account just type 0 to go to menu again");
				
				t1email = input.next();
				if(t1email.equals("0")) {
					return ;
				}
					
			}
		}*/
		/*System.out.print("enter password : ");
		t1password = input.next();
		System.out.print("Are you male or female ? \n 1 : Male \n 2 : Female ");*/
		//String cgender;
		/*cgender = input.next();
		
		while(!cgender.equals("1")&&!cgender.equals("2")) {
			System.out.print("Please enter your gender again!!");
			System.out.print("Are you male or female ? \n 1 : Male \n 2 : Female ");
			cgender = input.next();
		}
		if(cgender.equals("1"))
			t1gender='m';
		if(cgender.equals("2"))
			t1gender='f';*/
		/*String cpre;
		System.out.print("Do you want to have premium account ? \n 1 : Yes \n 2 : No ");
		cpre = input.next();*/
		
		/*while(!cpre.equals("1")&&!cpre.equals("2")) {
			System.out.print("Please enter your premium option again!!");
			System.out.print("Do you want to have premium account ? \n 1 : Yes \n 2 : No ");
			cpre = input.next();
		}
		if(cpre.equals("1"))
			t1pre=true;
		if(cpre.equals("2"))
			t1pre=false;*/
		/*System.out.print("Enter your age please:");
		t1age =input.nextInt();
		System.out.print("Enter your job please:");
		t1job =input.next();
		System.out.print("Enter your position please:");
		t1pos =input.next();*/
			System.out.print("=========Non=======: ");
		nonStudent nt1 = new nonStudent(t1name,t1email,t1password,t1age,t1gender,t1pre,t1job,t1pos);
		nonstudents.add(nt1);
		
		
		//Trainee(String name, String email, String password, int age, char gender, Boolean premium)
		}
		if(checkstudent==0) {
			/*System.out.print("enter your name : ");
			t1name = input.next();
			System.out.print("enter your email account : ");
			t1email = input.next();
			for(cnt=0;cnt<nonstudents.size();cnt++) {
				while(t1email.equals(nonstudents.get(cnt).getEmail())) {
					System.out.println("We already have a member with this e-mail account.Please enter your mail account again.\nIf you dont have a email account just type 0 to go to menu again");
					
					t1email = input.next();
					if(t1email.equals("0")) {
						return ;
					}
						
				}
			}
			for(cnt=0;cnt<students.size();cnt++) {
				while(t1email.equals(students.get(cnt).getEmail())) {
					System.out.println("We already have a member with this e-mail account.Please enter your mail account again.\nIf you dont have a email account just type 0 to go to menu again");
					
					t1email = input.next();
					if(t1email.equals("0")) {
						return ;
					}
						
				}
			}
			System.out.print("enter password : ");
			t1password = input.next();
			System.out.print("Are you male or female ? \n 1 : Male \n 2 : Female ");
			String cgender;
			cgender = input.next();
			
			while(!cgender.equals("1")&&!cgender.equals("2")) {
				System.out.print("Please enter your gender again!!");
				System.out.print("Are you male or female ? \n 1 : Male \n 2 : Female ");
				cgender = input.next();
			}
			if(cgender.equals("1"))
				t1gender='m';
			if(cgender.equals("2"))
				t1gender='f';
			String cpre;
			System.out.print("Do you want to have premium account ? \n 1 : Yes \n 2 : No ");
			cpre = input.next();
			
			while(!cpre.equals("1")&&!cpre.equals("2")) {
				System.out.print("Please enter your premium option again!!");
				System.out.print("Do you want to have premium account ? \n 1 : Yes \n 2 : No ");
				cpre = input.next();
			}
			if(cpre.equals("1"))
				t1pre=true;
			if(cpre.equals("2"))
				t1pre=false;
			System.out.print("Enter your age please:");
			t1age =input.nextInt();
			System.out.print("Enter your Institution please: ");
			t1inst =input.next();*/
		
			Student st1 = new Student(t1name,t1email,t1password,t1age,t1gender,t1pre,t1inst);
			students.add(st1);
		}
		}
		//Trainee t1 = new Trainee (t1name,t1email,t1password,t1age,t1gender,t1pre);
		
		//return t1;
	
	public static void listAllCourses() {
		if(holdcheck==1) {
		if(nshold.getPremium()==true) {
			int cnt;
			Course pcourse = new Course();
			for(cnt=0;cnt<courses.size();cnt++) {
				pcourse = courses.get(cnt);
				sort_words=sort_words+"  "+"course name : " + pcourse.name +" course duration : "+ pcourse.duration + " instructor's name : " + pcourse.instructor.getName()+"\n";
			}
			
		}
		else {
			int cnt;
			Course pcourse = new Course();
			for(cnt=0;cnt<courses.size();cnt++) {
				pcourse = courses.get(cnt);
				if(pcourse.premium==false)
					sort_words=sort_words+"  "+"course name : " + pcourse.name +" course duration : "+ pcourse.duration + " instructor's name : " + pcourse.instructor.getName()+"\n";
			}
			
		}
		}
		if(holdcheck==0) {
		if(students.get(holdnumber).getPremium()==true) {
			int cnt;
			Course pcourse = new Course();
			for(cnt=0;cnt<courses.size();cnt++) {
				pcourse = courses.get(cnt);
				sort_words=sort_words+"  "+"course name : " + pcourse.name +" course duration : "+ pcourse.duration + " instructor's name : " + pcourse.instructor.getName()+"\n" ;
			}
			
		}
		else {
			int cnt;
			Course pcourse = new Course();
			for(cnt=0;cnt<courses.size();cnt++) {
				pcourse = courses.get(cnt);
				if(pcourse.premium==false)
					sort_words=sort_words+"course name : " + pcourse.name +" course duration : "+ pcourse.duration + " instructor's name : " + pcourse.instructor.getName()+"\n" ;
			}
			
		}
		}
	}
	
	public static String displayFee() {
		if(holdcheck==0)
		return String.valueOf(students.get(holdnumber).monthlyfee());
		else {
		return String.valueOf(nonstudents.get(holdnumber).monthlyfee());	
		}
	}
	public static void Menu() {
		input3 = new Scanner(System.in);
		String i ;
		System.out.print("Welcome to the Online Learning Platform\n");
		System.out.print("Please choose an operation :\n1.SignUp\n2.Login\n3.exit");
		i= input3.next();
		if(i.equals("3"))
			System.exit(0);
		while(!i.equals("3")) {
		
		if(i.equals("3"))
		System.exit(0);
		if(i.equals("2")) {
		
		
			if(login("rty","454")) {
				System.out.print("Authentication is successful!");
				String k;
				
				
				
				while(true) {
					System.out.print("Please choose an operation : \n1.Add Course\n2.Delete Course \n3.Get Instructor Details\n4.Change Your Account To Premium\n5.List All Courses\n6.List Enrolled Courses\n7.Display Fee\n8.Log Out  ");
					k= input3.next();
					if(k.equals("8")) {
						logout();
						
					}
					else if(k.equals("1")) {
						//addCourse();	
				}
					else if(k.equals("2")) {
						
						//deleteCourse();
					}
					else if(k.equals("3")) {
						getInstructorDetails();					}
					else if(k.equals("4")) {
						//changeToPremium();
					}
					else if(k.equals("5")) {
						listAllCourses();	
					}
					else if(k.equals("6")) {
						listEnrolledCourses();
						
					}
					else if(k.equals("7")) {
						displayFee();
					}
					else {
						System.out.println("Please choose a valid option!");
						
						
					}
					
					
					
					
				}
					
			}
			else {
				
			}
		}
		if(i.equals("1")) {
			//signUp();
		}
		System.out.print("Please choose an operation :\n1.SignUp\n2.Login\n3.exit");
		i= input3.next();
	}
	}
	public static boolean login(String t1email,String t1password){
		input4 = new Scanner(System.in);
		int cnt;
		nonStudent Ttra = new nonStudent();
		Student STtra = new Student();
		/*System.out.println("Enter your email account please:");
		String t1email = input4.nextLine();*/
		for(cnt=0;cnt<nonstudents.size();cnt++) {
		Ttra = nonstudents.get(cnt);
		if(t1email.equals(Ttra.getEmail())) {
			//System.out.println("Enter your password please:");
			//String t1password = input4.nextLine();
			if(t1password.equals(Ttra.getPassword())){//if mail is in non student list
				holdnumber=cnt;
				holdcheck=1;
				nshold=Ttra;
				return true;
			}
			else {
					System.out.println("Password and ID are not matching");
					return false;
				}
					
				
				
			}
		}
		for(cnt=0;cnt<students.size();cnt++) {
			STtra = students.get(cnt);
			if(t1email.equals(STtra.getEmail())) {//if mail is in student list
				//System.out.println("Enter your password please:");
				//String t1password = input4.nextLine();
				if(t1password.equals(STtra.getPassword())){
					holdnumber=cnt;
					holdcheck=0;
					shold=STtra;
					return true;
				}
				else {
						System.out.println("Password and ID are not matching");
						return false;
					}
						
					
					
				}
			}
			
			
			
			
		System.out.println("Your email is not  found");
		return false;
		
	}
	public static void initializethevalues() {//this function is for generating random courses and instructors
		int cnt;
		for(cnt = 0 ; cnt < 10 ; cnt++) {
			int random = (int)(Math.random() * 2 + 0);
			char g;
			if(random==0) {
				g='m';
			}
			else
			g='f';
			Instructor tins = new Instructor("ins"+ cnt,"ins" + cnt +"@gmail.com","pass"+cnt,30+cnt,g,100+cnt);
			instructors.add(tins);
		}
		for(cnt = 0 ; cnt < 10 ; cnt++) {
			int random = (int)(Math.random() * 2 + 0);
			boolean b;
			if(random==0) {
				b=true;
			}
			else
			b=false;
			Course tcourse = new Course(instructors.get(cnt),"course"+cnt,(float) 40,b);
			courses.add(tcourse);
		}
	}
	

	

	public static void main(String[] args) {
		initializethevalues();
		OnlineLearningApplication start_point=new OnlineLearningApplication();
		start_point.add(container);
		start_point.setVisible(true);
		Menu();	
	}
	/*The Class constructor for the J_frame*/
	
	public  OnlineLearningApplication() {
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Application Registration");
		//FOR the listener for sign up 
		/////////////////
	
		Control_Panel.add(new JLabel("Enrolled Courses:"));
		Control_Panel.add(enroll_detail);
		Control_Panel.add(new JLabel("All Courses:"));
		Control_Panel.add(ALL_roll_detail);
		Control_Panel.add(new JLabel("Enter Course Name"));
		Control_Panel.add(Courses_input);
		Control_Panel.add(add_courses);
		Control_Panel.add( del_courses);
		Control_Panel.add(back_manage);
		////////////////
		container.setLayout(card);
		first.setLayout(new BorderLayout());
		first.add(Sign,BorderLayout.NORTH);
		first.add(Log,BorderLayout.CENTER);
		first.add(Exit,BorderLayout.SOUTH);
	    container.add(first,"2");
		container.add(Sign_Panel,"3");
		container.add(log_in_form,"4");
		container.add(login_Panel,"5");
		container.add(Control_Panel,"6");
		container.add(instruct_detail,"7");
		//container.add(fee_details,"8");
		
		
		card.show(container,"1");//for the exchange of layers
		//this.add(first);
		click To_click=new click();
		Move_to_Screen new_Screen=new Move_to_Screen();
		Sign.addActionListener(To_click);
		Log.addActionListener(To_click);
		 Exit.addActionListener(To_click);
		ButtonGroup operation=new ButtonGroup();
		operation.add(Male);
		operation.add(Female);
		
		
		log_in_form.add(new JLabel("Email :"));
		log_in_form.add(email_input);
		log_in_form.add(new JLabel("Password :"));
		log_in_form.add(password_input);
		log_in_form.add(Move);
		Move_TO_LOG GO_Next_Screen =new Move_TO_LOG ();
		Move.addActionListener(GO_Next_Screen);
		
		/////////////
		Display_andcontrol_log_in plan23=new Display_andcontrol_log_in();
		add_courses.addActionListener(plan23);
		del_courses.addActionListener(plan23);
		back_manage.addActionListener(plan23);
		
		
		////////////
		
		Sign_Panel.add(new JLabel("Name :"));
		Sign_Panel.add(User_Name);
		Sign_Panel.add(new JLabel("Male :"));
		Sign_Panel.add(Male);
		Sign_Panel.add(new JLabel("Female :"));
		Sign_Panel.add(Female);
		Sign_Panel.add(new JLabel("STUDENT :"));
		Sign_Panel.add(Student);
		Sign_Panel.add(new JLabel("NON_STUDENT :"));
		Sign_Panel.add(Non_Student);
		Sign_Panel.add(new JLabel("EMAIL :"));
		Sign_Panel.add(Email);
		Sign_Panel.add(new JLabel("PASSWORD :"));
		Sign_Panel.add(Password);
		Sign_Panel.add(new JLabel("INSTITUTION :"));
		Sign_Panel.add(Institution);
		Sign_Panel.add(new JLabel("JOB :"));
		Sign_Panel.add(Job);
		Sign_Panel.add(new JLabel("POSITION :"));
		Sign_Panel.add(Position);
		Sign_Panel.add(new JLabel("PREMIUM :"));
		Sign_Panel.add(pre);
		Sign_Panel.add(Enter);
		Male.setSelected(true);
		Enter.addActionListener(new_Screen);
		
		//for log in//
		/*JButton Control=new JButton("Add,Del,and View Courses");
		JButton instruct_details=new JButton("Show Instructor Details");
		JButton display_fees=new JButton("Display_Fee");
		JCheckBox Pre=new JCheckBox();
		JButton log_out=new JButton();
		login_Panel
		panel.add(jb1, BorderLayout.NORTH);
panel.add(jb2, BorderLayout.SOUTH);
panel.add(jb3, BorderLayout.WEST);
panel.add(jb4, BorderLayout.EAST);
panel.add(jb5, BorderLayout.CENTER);*/ 
		
		login_Panel.setLayout(new BorderLayout());
		login_Panel.add( Control, BorderLayout.NORTH);
		login_Panel.add( instruct_details,BorderLayout.CENTER);
		login_Panel.add( display_fees, BorderLayout.WEST);
		login_Panel.add( Pre, BorderLayout.EAST);
		login_Panel.add( log_out,BorderLayout.SOUTH);
		Control_profile control_pro=new Control_profile();
		Control.addActionListener(control_pro);
		instruct_details.addActionListener(control_pro);
		display_fees.addActionListener(control_pro);
		Pre.addActionListener(control_pro);
		log_out.addActionListener(control_pro);
		
		
   
		
		this.show(true);
	}
	public class Display_andcontrol_log_in implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent enable) {
			// TODO Auto-generated method stub
			if(enable.getSource()==add_courses) {
				sort_words=" " ;
				addCourse(Courses_input.getText());
				listEnrolledCourses();
				enroll_detail.setText(sort_words);
				
			}
		 if (enable.getSource()==del_courses){
				sort_words=" " ;
				 deleteCourse(Courses_input.getText());
				 enroll_detail.setText(" ");
				 listEnrolledCourses();
					enroll_detail.setText(sort_words);
			}
		 if (enable.getSource()==back_manage) {
			 card.show(container,""+5);
			 Courses_input.setText(null);
		 }
		 
		}
		
	}
	public class Control_profile  implements  ActionListener{

		@Override
		public void actionPerformed(ActionEvent enable) {
			// TODO Auto-generated method stub
			if (enable.getSource()==Control) {
				card.show(container,""+6);
				sort_words=" ";
				listEnrolledCourses();
				enroll_detail.setText(sort_words);
				sort_words=" ";
				listAllCourses();
				ALL_roll_detail.setText(sort_words);
				
			}
			if (enable.getSource()==instruct_detail) {
				
				card.show(container,""+7);
			}
			if (enable.getSource()==display_fees) {//display_fees
				
				 JOptionPane.showMessageDialog( OnlineLearningApplication.this,displayFee(),"Your Fees",JOptionPane.INFORMATION_MESSAGE);
				 

			}
			if (enable.getSource()==instruct_details) {
				viewallinstructors();
				 JOptionPane.showMessageDialog( OnlineLearningApplication.this,sort_words,"Progress",JOptionPane.INFORMATION_MESSAGE);
				
			}
			if (enable.getSource()==log_out) {
				card.show(container,""+2);
			}
			if (enable.getSource()==Pre) {
				changeToPremium(true);
				JOptionPane.showMessageDialog( OnlineLearningApplication.this,"Your have can now register all Courses","Progress",JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
		
	}
	public class Move_TO_LOG implements  ActionListener{
boolean check_log=false;
		@Override
		public void actionPerformed(ActionEvent enable) {
			// TODO Auto-generated method stub
			if (enable.getSource()==Move) {
				check_log=login(email_input.getText(),password_input.getText());
				if (check_log) {
				card.show(container,""+5);
				email_input.setText(null);
				password_input.setText(null);
				}
				else {
					 JOptionPane.showMessageDialog( OnlineLearningApplication.this,"Wrong match ","WRONG",JOptionPane.ERROR_MESSAGE);
					 card.show(container,""+2);
					 email_input.setText(null);
						password_input.setText(null);
				}
			}
			
		}
		
	}
	public class click  implements ActionListener{
		
	

	@Override
	public void actionPerformed(ActionEvent enable) {
		// TODO Auto-generated method stub
		if (enable.getSource()==Sign) {
			card.show(container,""+3);
		}
		if(enable.getSource()==Log) {
			card.show(container,""+4);
		}
		if(enable.getSource()== Exit) {
			System.exit(0);
		}
		
	}
	}
	public class Move_to_Screen  implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent enable) {
			char hold_gender='M';
			// TODO Auto-generated method stub
			if (enable.getSource()==Enter){
			if (Student.isSelected() && Non_Student.isSelected()) {
				 JOptionPane.showMessageDialog( OnlineLearningApplication.this,"You can not be a Student and Also Non Student ","WRONG",JOptionPane.ERROR_MESSAGE);

			}
			else if (Student.isSelected()) {
				if(Female.isSelected()) {
					hold_gender='F';
				}
				else
					hold_gender='M';
				
					if (!Job.getText().isEmpty() || !Position.getText().isEmpty() ) {
						 JOptionPane.showMessageDialog( OnlineLearningApplication.this,"---You can  be a Student with Institution or  Non Student with Job and POsition","WRONG",JOptionPane.ERROR_MESSAGE);

					}
					//String t1name,String t1email,String t1password,String t1job,String t1pos,String t1inst,int checkstudent,char t1gender,boolean t1pre
					else {
						
						signUp(User_Name.getText(),Email.getText(),Password.getText(),Job.getText(),Position.getText(),Institution.getText(),0,hold_gender,pre.isSelected());
						 JOptionPane.showMessageDialog( OnlineLearningApplication.this,"You have REGISTERED","PASS",JOptionPane.INFORMATION_MESSAGE);
						 card.show(container,""+2);	
						 User_Name.setText(null);
						 Email.setText(null);
						 Password.setText(null);
						 Job.setText(null);
						 Position.setText(null);
						 Institution.setText(null);
						 }
					
				
			}else if (Non_Student.isSelected()){
				if(Female.isSelected()) {
					hold_gender='F';
				}
				else
					hold_gender='M';
				
					if (!Institution.getText().isEmpty() ) {
						 JOptionPane.showMessageDialog( OnlineLearningApplication.this,"---You can  be a Student with Institution or  Non Student with Job and POsition","WRONG",JOptionPane.ERROR_MESSAGE);

					}
					//String t1name,String t1email,String t1password,String t1job,String t1pos,String t1inst,int checkstudent,char t1gender,boolean t1pre
					else {
						
						signUp(User_Name.getText(),Email.getText(),Password.getText(),Job.getText(),Position.getText(),Institution.getText(),1,hold_gender,pre.isSelected());
					 JOptionPane.showMessageDialog( OnlineLearningApplication.this,"You have REGISTERED","PASS",JOptionPane.INFORMATION_MESSAGE);
					 card.show(container,""+2);
					 User_Name.setText(null);
					 Email.setText(null);
					 Password.setText(null);
					 Job.setText(null);
					 Position.setText(null);
					 Institution.setText(null);
					 
					 }
					

				
			}
			}
			
		}
		}
	
	

}
