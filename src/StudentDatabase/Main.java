package StudentDatabase;


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// numbers of student to add
		Scanner sc = new Scanner(System.in);

		System.out.print("Number of student to add: ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println();
		Student[] students = new Student[n];
		for (int i = 0 ;i < students.length; i++){
			students[i] = new Student(sc);
			students[i].payment();
		}


	}
}

