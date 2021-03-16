package MobilesStore;

public class Mobile {
	private int id;
	private String Model;
	private double Price;
	private String DateOfManufacture;
	
	public Mobile() {
		
	}
	
	public Mobile(int id,String model,double price,String dateOfManufacture) {
		this.id = id;
		this.Model = model;
		this.Price = price;
		this.DateOfManufacture = dateOfManufacture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getDateOfManufacture() {
		return DateOfManufacture;
	}

	public void setDateOfManufacture(String dateOfManufacture) {
		DateOfManufacture = dateOfManufacture;
	}
	
	
}
