package TaskManagement;

public class Task {
	
	private int id;
	private String Description;
	private String AssignedTo;
	private String Status;
	
	public Task() {
		
	}
	public Task(int id, String description,String assignedTo, String status) {
		this.id = id;
		this.Description = description;
		this.AssignedTo = assignedTo;
		this.Status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAssignedTo() {
		return AssignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		AssignedTo = assignedTo;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
		

}
