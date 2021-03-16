package MedicalStore;
import java.util.Scanner;

public class Customer extends Medicine {
	static Scanner get = new Scanner(System.in);
	private int Id;
	private String Name;
	private int Age;
	private double totalPrice;
	private Medicine[] Meds;
	

	public Customer(int Id,String Name, int Age ) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.Age = Age;
		this.Meds = addMedicines();
		
	}
	

	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
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


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Medicine[] getMeds() {
		return Meds;
	}


	public void setMeds(Medicine[] meds) {
		Meds = meds;
	}

	
	
	public static Medicine[] addMedicines() {
		System.out.println("Enter how many medicines did Customer buy : ");
		int N = get.nextInt();
		Medicine[] Meds = new Medicine[N];
		for(int i = 0;i<N;i++) {
			Meds[i] = addMedicine();
		}
		return Meds;
		
	}
	public void addNewMedicine() {
		System.out.println("Enter how many medicines did Customer buy : ");
		int N = get.nextInt();
		Medicine[] newMeds = new Medicine[N];
		for(int i = 0;i<N;i++) {
			newMeds[i] = addMedicine();
		}
		Medicine[] updatedMeds = new Medicine[N + Meds.length];
		for(int i = 0;i<Meds.length;i++) {
			updatedMeds[i] = Meds[i];
		}
		for(int i = 0;i<N;i++) {
			updatedMeds[Meds.length+i] = newMeds[i];
		}
		setMeds(updatedMeds);
	}
	
	
	public static Medicine addMedicine() {
		System.out.println("Enter Medicine Name : ");
		String Name = get.next();
		System.out.println("Enter Quantity : ");
		int quantity  = get.nextInt();
		System.out.println("Enter Price per medicine : ");
		int price = get.nextInt();
		return new Medicine(Name,quantity,price);
	}
	
	
	public void display() {
		System.out.println("Id\t: "+Id );
		System.out.println("Name\t: "+Name);
		System.out.println("Age\t: "+Age);
		System.out.println("Medicines Bought : ");
		displayMedicines();
		
	}
	
	
	public void displayMedicines() {
		System.out.println("Name\tQuantity\tPrice per unit");
		for(int i = 0;i<this.Meds.length;i++) {
			System.out.println(Meds[i].getName() + "\t" + Meds[i].getQuantity()+"\t\t" +Meds[i].getPrice() );
		}
	}
	
	
	public void displayBill() {
		
		totalPrice = calculateBill();
		display();
		System.out.println("TotalPrice\t: " + totalPrice);
	}
	
	
	public double calculateBill() {
		double cost = 0;
		for(int i = 0;i<this.Meds.length;i++) {
			cost = cost + Meds[i].getPrice() * Meds[i].getQuantity();
		}
		return cost;
	}
	
	
	public  void deleteMedcine() {
		
	}
	
	
	
	public  void addDiscount() {
		System.out.println("here");
		 totalPrice = totalPrice *0.8;
	}
	
}
