package StudentDatabase;


import java.io.InterruptedIOException;
import java.util.*;
/*
*YOUR APPLICATION SHOULD DO THE FOLLOWING TASK:
* Ask the user how many new students will be added to the database
* The user should be prompted to enter the name and year for each student
* The student should have a 5-digit unique ID, with batch , count , 1st char of first name , first char of last name , course id
* A student can enroll in the following courses:
   #History 101
   #Mathematics 102
   #English 103
   #Chemistry 104
   #Computer Science 105
* Each course costs $600 to enroll
* The student should be able to view their balance and pay the tuition
* To see the status of the student, we should see their name, ID, courses enrolled, and balance
* */

public class Student {
	private String FirstName  ;
	private String LastName    ;
	private String gradeYear ;
	private String StudentID    ;

	private String course ;
	private int  balance  = 0   ;
	private static int costOfcourse = 600;
	private static int batch = 24;
	private static int  count = 1000;
	private static HashMap<Integer , String> hashMap = new HashMap<>();
	private int CourseID;
	static {
		hashMap.put(101, "History 101");
		hashMap.put(102, "Mathematics 102");
		hashMap.put(103, "English 103");
		hashMap.put(104, "Chemistry 104");
		hashMap.put(105, "Computer_Science 105");
	}

	public String capitalizeFirstLetter(String name){
		if(name == null  || name.isEmpty()){
			return name ;
		}
		return name.substring(0,1).toUpperCase()+name.substring(1);
	}
	public Student(Scanner scanner) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter First name: ");
		this.FirstName = sc.nextLine();
		char firstChar = Character.toUpperCase(FirstName.charAt(0));
		String firstname = firstChar+FirstName.substring(1);
		System.out.print("Enter Last name: ");
		this.LastName = sc.nextLine();
		String newLastName = capitalizeFirstLetter(LastName);
		System.out.print("1-first\n2- Second\n3 -Third\n4 -fourth\nEnter Grade year: ");
		int year = sc.nextInt();
		if (year == 1){
			this.gradeYear = "First";
		} else if (year == 2) {
			this.gradeYear = "Second";
		} else if (year == 3) {
			this.gradeYear = "Third";
		}else if (year == 4){
			this.gradeYear = "Fourth";
		}else {
			System.out.println("Unknown");
		}
		System.out.println("101-History\n102 - Mathematics\103-English\n104-Chemistry\n105-Computer_Science ");
		int CourseID = sc.nextInt();
		String courseWithId=hashMap.get(CourseID);
		if (courseWithId!=null){
			this.course =  courseWithId.split(" ")[0];
		}else {
			this.course = "Unknown";
		}

		System.out.println("First Name: "+firstname);
		System.out.println("Last Name: "+newLastName);
		System.out.println("Grade year: "+gradeYear);
		System.out.println("Course:   "+ course);

		setStudentID();
	}

	/* unique ID should contain
	 *  batch , count , 1st char of first name , first char of last name , course id
	 *
	 * */
	private void setStudentID(){
		count++;
		String strBatch = Integer.toString(batch);
		char firstnameLetter = FirstName.charAt(0);
		char lastNameLetter = LastName.charAt(0);
		String strCount = Integer.toString(count);
		String ci = Integer.toString(CourseID);

		StudentID = strBatch+firstnameLetter+lastNameLetter+strCount+CourseID;
		System.out.println("Student ID: "+StudentID);
	}
	// View Balance;
	public void viewBalance(){
		System.out.println("Your balance is "+"\u20B9"+costOfcourse);
	}
	public void payment(){
		viewBalance();
		Scanner sc = new Scanner(System.in);
		System.out.print("How much you want to pay: \u20B9");
		int payment = sc.nextInt();
		if (payment> costOfcourse){
			System.out.println("Not applicable");
		} else if (payment<10) {
			System.out.println("Pay more to make payment!");
		} else {
			int tutionBalance = costOfcourse - payment;
			costOfcourse = tutionBalance;
			System.out.println("Thankyou for the payment of \u20B9"+payment);
			viewBalance();
		}
	}
}
