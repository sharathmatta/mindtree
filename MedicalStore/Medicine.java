package MedicalStore;

public class Medicine {
	private String Name;
	private int quantity;
	private float price;
	public Medicine() {
		
	}
	public Medicine(String Name,int quantity, float price) {
		super();
		this.Name = Name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
