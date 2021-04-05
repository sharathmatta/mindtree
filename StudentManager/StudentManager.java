package StudentManager;

import java.util.Scanner;

//add students
  //get no of students
  //get details of n students
  //add students to available students
//update student details
  //get student id
  //get choice address or age
  //get updated value
  //updated value
//delete student details
  //get student id
  //delete student
//display based on details
  //get choice id name age standard
  //sort based on choice
  //display 
//exit

public class StudentManager extends Student {
	static Scanner get = new Scanner(System.in);

	public static void main(String[] args) {
		Student[] students = new Student[0];
		boolean isMenu = true;
		do {
			displayMenu();
			System.out.println("Enter your choice");
			int choice  = get.nextInt();
			
			switch(choice) {
			case 1:
				students = addStudents(students);
				displayStudents(students);
				break;
			case 2:
				students = updateStudent(students);
				displayStudents(students);
				break;
			case 3:
				students = deleteStudent(students);
				displayStudents(students);
				break;
			case 4:
				displayBasedOnDetails(students);
				break;
			case 5:
				isMenu = false;
				System.out.println("Application closed");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}while(isMenu);
	}

	public static Student[] addStudents(Student[] students) {
		System.out.println("How many new students");
		int newStudentCount = get.nextInt();
		Student[] updatedStudents = new Student[students.length + newStudentCount];
		for (int i = 0; i < students.length; i++) {
			updatedStudents[i] = students[i];
		}
		for (int i = 0; i < newStudentCount; i++) {
			System.out.println("Enter student id");
			long id = get.nextLong();
			System.out.println("Enter student name");
			get.nextLine();
			String name = get.nextLine();
			System.out.println("Enter student age");
			int age = get.nextInt();
			System.out.println("Enter student standard");
			int standard = get.nextInt();
			System.out.println("Enter student address");
			get.nextLine();
			String address = get.nextLine();
			updatedStudents[students.length + i] = new Student(id, name, age, standard, address);
		}
		return updatedStudents;

	}

	public static Student[] updateStudent(Student[] students) {
		if (students.length == 0) {
			System.out.println("No data available");
		} else {
			System.out.println("Enter student id");
			long id = get.nextLong();
			int studentIndex = 0;
			boolean isStudentExist = false;
			for (int i = 0; i < students.length; i++) {
				if (students[i].getId() == id) {
					studentIndex = i;
					isStudentExist = true;
					break;
				}
			}
			if (isStudentExist) {
				int choice = 0;
				do {
					System.out.println("What to update?\n1. Address\t2.Age");
					choice = get.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter updated address");
						get.nextLine();
						String address = get.nextLine();
						students[studentIndex].setAddress(address);
						break;
					case 2:
						System.out.println("Enter updated age");
						int age = get.nextInt();
						students[studentIndex].setAge(age);
						break;
					default:
						System.out.println("Invalid choice");
						break;

					}
				} while (choice != 1 && choice != 2);
			} else {
				System.out.println("Student not found");
			}

		}
		return students;

	}

	public static Student[] deleteStudent(Student[] students) {
		if (students.length == 0) {
			System.out.println("No data available");
			return students;
		} else {
			System.out.println("Enter student id");
			long id = get.nextLong();
			int studentIndex = 0;
			boolean isStudentExist = false;
			for (int i = 0; i < students.length; i++) {
				if (students[i].getId() == id) {
					students[i] = null;
					studentIndex = i;
					isStudentExist = true;
					break;
				}
			}
			int j = 0;
			if (isStudentExist) {
				Student[] updatedStudents = new Student[students.length - 1];
				for (int i = 0; i < students.length; i++) {
					if (i == studentIndex) {
						continue;
					}
					updatedStudents[j] = students[i];
					j++;
				}
				System.out.println("Student details deleted");
				return updatedStudents;
			}
			else {
				return students;
			}

		}
	}

	public static void displayBasedOnDetails(Student[] students) {
		if (students.length == 0) {
			System.out.println("No data available");
		} else {
			int choice = 0;
			do {
				System.out.println("Sort users by\n1. ID\t2. Name\t3. Age\t4. Standard");
				choice = get.nextInt();
				
				switch (choice) {
				case 1:
					sortById(students);
					break;
				case 2:
					sortByName(students);
					break;
				case 3:
					sortByAge(students);
					break;
				case 4:
					sortByStandard(students);
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			} while (choice < 1 || choice > 4);
		}

	}

	public static void sortById(Student[] students) {
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = 0; j < students.length - i - 1; j++) {
				if (students[j].getId() > students[j + 1].getId()) {
					Student temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}
		displayStudents(students);
	}

	public static void sortByName(Student[] students) {
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = 0; j < students.length - i - 1; j++) {
				if (students[j].getName().compareTo(students[j+1].getName())>0) {
					Student temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}
		displayStudents(students);
	}

	public static void sortByAge(Student[] students) {
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = 0; j < students.length - i - 1; j++) {
				if (students[j].getAge() > students[j + 1].getAge()) {
					Student temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}
		displayStudents(students);
	}

	public static void sortByStandard(Student[] students) {
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = 0; j < students.length - i - 1; j++) {
				if (students[j].getStandard() > students[j + 1].getStandard()) {
					Student temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}
		displayStudents(students);
	}

	public static void displayStudents(Student[] students) {
		if (students.length == 0) {
			System.out.println("No data available");
		} else {
			for (int i = 0; i < students.length; i++) {
				System.out.println();
				System.out.println("Id\t\t:"+students[i].getId());
				System.out.println("Name\t\t:"+students[i].getName());
				System.out.println("Age\t\t:"+students[i].getAge());
				System.out.println("Standard\t:"+students[i].getStandard());
				System.out.println("Address\t\t:"+students[i].getAddress());

			}
		}
	}

	public static void displayMenu() {
		System.out.println();
		System.out.println("1. Add students");
		System.out.println("2. Update student address or age");
		System.out.println("3. Delete a student");
		System.out.println("4. Sort and display students");
		System.out.println("5. Exit");
		System.out.println();

	}
}
