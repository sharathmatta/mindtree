package ProjectAllocation;

public class Manager extends Project{
	private String Id;
	private String Name;
	private String Department;
	private Project[] projects;
	
	

	public Manager() {
		super();
	}
	
	public Manager(String id,String name,String department,Project[] projects) {
		super();
		this.Id = id;
		this.Name = name;
		this.Department = department;
		this.projects = projects;
	}

	public Project[] getProjects() {
		return projects;
	}

	public void setProjects(Project[] projects) {
		this.projects = projects;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}
}
