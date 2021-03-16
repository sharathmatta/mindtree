package ProjectAllocation;
//add managers
  //get manager count
  //get managers details and add
//display menu
//task1 add new manager
  //get manager details and add
//task2 assign new project to manager
  //get manager id
  //get manager projects
  //get new projects details
  //update manager projects
//task3 delete projects
  //get projects id
  //get manager index and project index
  //delete project
  //update manager projects
//task4 print managers with more than 3 projects
//task5 sort and display
import java.util.Scanner;
public class ProjectAllocation extends Manager {
	static Scanner get = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter number of Managers :");
		int managerCount = get.nextInt();
		Manager[] managers;
		managers = new Manager[managerCount];
		
		for(int i = 0;i<managerCount;i++) {
			managers[i] = addManager();
		}
		displayManagers(managers);
		
		boolean menu = true;
		do {
			displayMenu();
			System.out.println("Enter your choice :");
			int choice  = get.nextInt();
			switch(choice) {
			case 1:
				managers = addNewManager(managers);
				displayManagers(managers);
				break;
			case 2:
				managers = assignNewProjectToManager(managers);
				displayManagers(managers);
				break;
			case 3:
				managers = deleteProject(managers);
				displayManagers(managers);
				break;
			case 4:
				managersWithMoreprojects(managers);
				break;
			case 5:
				managers = sortManagers(managers);
				displayManagers(managers);
				break;
			case 6:
				menu = false;
				break;
			default:
				break;	
				
			}
		}while(menu);
	}
	
	public static void displayMenu() {
		System.out.println("**************************************");
		System.out.println("1. Add a new manager to the company");
		System.out.println("2. Assign a new project to manager");
		System.out.println("3. Delete a project of given id");
		System.out.println("4. Print the managers having more than 3 projects");
		System.out.println("5. Sort the manager list according to the manager name");
		System.out.println("6. Exit");
		System.out.println("**************************************");
	}
	
	public static Manager addManager() {
		boolean validId = false;
		String id;
		do {
			System.out.println("Enter Manager Id :");
			get.nextLine();
			id = get.nextLine();
			validId = validateId(id,"manager");
		}while(!validId);
		System.out.println("Enter Manager Name :");
		String name  = get.nextLine();
		String department = "";
		
		boolean validChoice = false;
		do {
			System.out.println("Select department : \n 1. Digital\t2. Testing\t3. Cloud Services");
			int choice = get.nextInt();
			switch(choice) {
			case 1 : 
				department = "Digital";
				validChoice = true;
				break;
			case 2: 
				department = "Testing";
				validChoice = true;
				break;
			case 3:
				department = "Cloud Services";
				validChoice = true;
				break;
			default:
				break;
			}
		}while(!validChoice);
		Project[] projects = new Project[0];
		Manager manager = new Manager(id, name,department,projects);
		return manager;
	}
	
	public static Project addProject() {
		boolean validId = false;
		String id;
		do {
			System.out.println("Enter Project Id :");
			get.nextLine();
			 id = get.nextLine();
			validId = validateId(id,"project");
		}while(!validId);
		System.out.println("Enter Project Name :");
		String name = get.nextLine();
		boolean validDuration = false;
		int duration = 0;
		do {
			System.out.println("Enter project duration in years(<=2 years) :");
			duration = get.nextInt();
			if(duration <= 2) {
				validDuration = true;
			}
		}while(!validDuration);
		
		Project project = new Project(id,name,duration);
		return project;
		
	}
	public static boolean validateId(String id,String category) {
		
		if(category.equals("manager")) {
			if(id.charAt(0) == 'M') {
				return true;
			}
		}
		if(category.equals("project")) {
			if(id.charAt(0) == 'P' && id.charAt(1) == 'R' && id.charAt(2) == 'J') {
				return true;
			}
		}
		return false;
		
	}
	
	
	
	public static Manager[] addNewManager(Manager[] managers) {
		Manager[] updatedManagers = new Manager[managers.length + 1];
		for(int i = 0;i< managers.length;i++) {
			updatedManagers[i] = managers[i];
		}
		updatedManagers[managers.length] = addManager();
		return updatedManagers;
	}
	
	public static Manager[] assignNewProjectToManager(Manager[] managers) {
		
		if(managers.length == 0) {
			System.out.println("No managers available");
		}
		else {
			System.out.println("Enter Manager Id :");
			get.nextLine();
			String managerId = get.nextLine();
			boolean managerExists = false;
			int managerIndex = 0;
			for(int i = 0;i<managers.length;i++) {
				if(managers[i].getId().equals(managerId)) {
					managerExists = true;
					managerIndex = i;
				}
			}
			if(managerExists) {
				int projectCount = managers[managerIndex].getProjects().length;
				Project[] projects = new Project[projectCount];
				projects = managers[managerIndex].getProjects();
				Project[] updatedProjects = new Project[projects.length +1];
				for(int i = 0;i<projects.length;i++) {
					updatedProjects[i] = projects[i];
					
				}
				updatedProjects[projects.length] = addProject();
				managers[managerIndex].setProjects(updatedProjects);
				displayProjects(managers[managerIndex].getProjects());
				return managers;
			}
			else {
				System.out.println("Invalid Id");
			}
		}
		
		return managers;
	}
	
	public static Manager[] deleteProject(Manager[] managers) {
		if(managers.length == 0) {
			System.out.println("No data available");
		}
		else {
			System.out.println("Enter project id:");
			boolean projectAvailable = false;
			int managerIndex = 0;
			int projectIndex = 0;
			get.nextLine();
			String projectId = get.nextLine();
			for(int i = 0;i<managers.length;i++) {
				if(managers[i].getProjects().length > 0) {
					Project[] projects = new Project[managers[i].getProjects().length];
					projects = managers[i].getProjects();
					
					
					for(int j = 0;j<projects.length;j++) {
						if(projects[j].getId().equals(projectId)) {
							managerIndex = i;
							projectIndex = j;
							projectAvailable = true;
						}
						
					}
				}
				
			}
			if(projectAvailable) {
				Project[] projects = new Project[managers[managerIndex].getProjects().length];
				projects = managers[managerIndex].getProjects();
				Project[] updatedProjects = new Project[projects.length-1];
				int j =0;
				for(int i = 0;i<projects.length;i++) {
					if(i == projectIndex) {
						continue;
					}
					updatedProjects[j] = projects[i];
					j++;
				}
				managers[managerIndex].setProjects(updatedProjects);
			}
			else {
				System.out.println("Project does not exist");
			}
		}
		return managers;
	}
	
	
	public static void managersWithMoreprojects(Manager[] managers) {
		if(managers.length == 0) {
			System.out.println("No data available");
			
		}
		else {
			for(int i = 0;i<managers.length;i++) {
				if(managers[i].getProjects().length >3) {
					displayManager(managers[i]);
				}
			}
		}
	}
	
	public static Manager[] sortManagers(Manager[] managers) {
		if(managers.length == 0) {
			System.out.println("No data available");
		}
		else {
			for(int i = 0;i<managers.length;i++) {
				for(int j = 0;j<managers.length;j++) {
					if(managers[i].getName().compareTo(managers[j].getName())<0) {
						Manager temp = managers[i];
						managers[i] = managers[j];
						managers[j] = temp;
					}
				}
			}
		}
		return managers;
	}
	
	
	public static void displayManagers(Manager[] managers) {
		if(managers.length == 0) {
			System.out.println("No data available");
		}
		else {
			boolean managersExists = false;
			for(int i = 0;i<managers.length;i++) {
				displayManager(managers[i]);
				managersExists = true;
			}
			if(!managersExists) {
				System.out.println(" 0 Managers");
			}
		}
		
	}
	
	public static void displayManager(Manager manager) {
		System.out.println("**************************************");
		System.out.println("Id\t\t:"+manager.getId());
		System.out.println("Name\t\t:"+manager.getName());
		System.out.println("Department\t:"+manager.getDepartment());
		System.out.println("Projects:");
		displayProjects(manager.getProjects());
		System.out.println("**************************************");
		
		
	}
	
	public static void displayProjects(Project[] projects) {
		if(projects.length == 0) {
			System.out.println("No data available");
			
		}
		else {
			for(int i = 0;i<projects.length;i++) {
				displayProject(projects[i]);
			}
		}
		
	}
	
	public static void displayProject(Project project) {
		System.out.println();
		System.out.println("Id\t\t:"+project.getId());
		System.out.println("Name\t\t:"+project.getName());
		System.out.println("Duration\t:"+project.getDuration());
		
		
	}
	
	
	
	
	
	
}
