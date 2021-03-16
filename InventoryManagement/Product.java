package InventoryManagement;

public class Product {
	private int id;
	private String Name;
	private int Quantity;
	private double pricePerUnit;

	public Product() {
		super();
	}

	public Product(int id, String name, int quantity, double priceperunit) {
		this.id = id;
		this.Name = name;
		this.Quantity = quantity;
		this.pricePerUnit = priceperunit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}
