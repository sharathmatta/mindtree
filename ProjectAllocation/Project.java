package ProjectAllocation;

public class Project {
	private String Id;
	private String Name;
	private int Duration;
	
	public Project() {
		super();
	}
	
	public Project(String id,String name,int duration) {
		super();
		this.Id = id;
		this.Name = name;
		this.Duration = duration;
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

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}
}
