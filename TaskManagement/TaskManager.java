package TaskManagement;

//Add tasks and display-
//write a display method-
//search and display-
//get status-
//sort tasks of that status
//display tasks of that status
//updating 
//get id and status
//change status
import java.util.Scanner;

public class TaskManager extends Task {
	static Scanner get = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the no. of tasks :");
		int N = get.nextInt();
		Task[] tasks = new Task[N];
		for (int i = 0; i < N; i++) {
			tasks[i] = addTask();
		}
		displayTasks(tasks);
		boolean menu = true;
		do {
			int choice = get.nextInt();
			switch(choice) {
			case 1:
				displayTasks(tasks);
				break;
			case 2:
				searchAndDisplay(tasks);
				break;
			case 3:
				//tasks = updateTasks(tasks);
				break;
			case 4:
				menu = false;
				break;
			default:
				System.out.println("Enter Valid Choice");
				break;
				
			}
		}while(menu);
	}

	public static void displayTasks(Task[] tasks) {
		for (int i = 0; i < tasks.length; i++) {
			if(tasks[i] != null) {
				displayTask(tasks[i]);
			}

		}
	}
	public static void displayTask(Task task) {
		System.out.println("ID\t\t: " + task.getId());
		System.out.println("Description\t: " + task.getDescription());
		System.out.println("Assigned To\t: " + task.getAssignedTo());
		System.out.println("Status\t\t: " + task.getStatus());
	}

	public static Task addTask() {
		System.out.println("Enter task ID :");
		int id = get.nextInt();
		System.out.println("Enter task Description :");
		String desc = get.next();
		System.out.println("Assigned To :");
		String assignedTo = get.next();
		System.out.println("Select task Status : \n1.Open 2. In Progress 3. Completed");
		
		String status = "";
		boolean flag = true;
		do {
			int choice = get.nextInt();
			switch(choice) {
			case 1:
				status = "Open";
				flag = false;
				break;
			case 2:
				status = "In Progress";
				flag = false;
				break;
			case 3:
				status = "Completed";
				flag = false;
				break;
			default:
				
				break;
			}
		}while(flag);
		
		Task task = new Task(id,desc,assignedTo,status);
		return task;
	}
	
	
	public static void searchAndDisplay(Task[] tasks) {
		System.out.println("Select task Status : \n1.Open 2. In Progress 3. Completed");
		int choice = get.nextInt();
		String status = "";
		switch(choice) {
		case 1:
			status = "Open";
			break;
		case 2:
			status = "In Progress";
			break;
		case 3:
			status = "Completed";
			break;
		default:
			break;
		}
		Task[] searchByStatus = searchByStatus(tasks,status);
		//Task[] sorted = sort(searchByStatus);
		displayTasks(searchByStatus);
	}
	public static Task[] searchByStatus(Task[] tasks,String status) {
		Task[] updatedTasks = new Task[tasks.length];
		for(int i = 0; i<tasks.length;i++) {
			if(tasks[i].getStatus() == status) {
				updatedTasks[i] = tasks[i];
				i++;
				
			}
		}
		return updatedTasks;
	}
	
}
