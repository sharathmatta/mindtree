package StudentManager;

public class Student {
	private long id;
	private String Name;
	private int Age;
	private int Standard;
	private String Address;
	public Student() {
		super();
	}
	public Student(long id,String name,int age,int standard,String address) {
		this.id = id;
		this.Name = name;
		this.Age = age;
		this.Standard = standard;
		this.Address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getStandard() {
		return Standard;
	}
	public void setStandard(int standard) {
		Standard = standard;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
}
