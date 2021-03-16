package InventoryManagement;
//Add products

//get product count 
//get product details and add
//display menu and get choice
//task1 add new products
// get product count
// get product details and add
//task2 update quantity of product
// get product id
// get new quantity
// update quantity
//task3 display products with less quantity
//get quantity limit
//display products with less quantity
//task4 sort and display
//task5 delete product
//get product id and delete product

import java.util.Scanner;

public class InventoryManagement extends Product {

	static Scanner get = new Scanner(System.in);

	public static void main(String[] args) {
		boolean menu = true;
		System.out.println("Enter the number of Products :");
		int productCount = get.nextInt();
		Product[] products;
		products = new Product[productCount];
		displayProducts(products);
		do {
			displayMenu();
			System.out.println("Enter Your Choice :");
			int choice = get.nextInt();
			switch (choice) {
			case 1:
				products = addNewProducts(products);
				System.out.println("Updated products Data :");
				displayProducts(products);
				break;
			case 2:
				products = updateQuantityOfProduct(products);
				System.out.println("Updated products Data :");
				displayProducts(products);
				break;
			case 3:
				displayProductsWithLessQuantity(products);
				break;
			case 4:

				sortAndDisplayByQuantity(products);
				break;
			case 5:
				products = deleteProductFromInventory(products);
				System.out.println("Updated products Data :");
				displayProducts(products);
				break;
			case 6:
				menu = false;
				break;
			default:
				break;

			}

		} while (menu);

	}

	public static Product addProduct() {
		System.out.println("Enter the Product id :");
		int id = get.nextInt();
		System.out.println("Enter the Product name :");
		String Name = get.next();
		System.out.println("Enter the Product quantity :");
		int Quantity = get.nextInt();
		System.out.println("Enter the Product price per unit :");
		double pricePerUnit = get.nextDouble();
		Product product = new Product(id, Name, Quantity, pricePerUnit);
		return product;

	}

	public static void displayProducts(Product[] products) {
		if (products.length == 0) {
			System.out.println("No data available\n");
		} else {
			for (int i = 0; i < products.length; i++) {
				displayProduct(products[i]);
			}
		}
	}

	public static void displayProduct(Product product) {
		System.out.println("*****************************************");
		System.out.println("id\t\t:" + product.getId());
		System.out.println("Name\t\t:" + product.getName());
		System.out.println("Quantity\t:" + product.getQuantity());
		System.out.println("Price per unit\t:" + product.getPricePerUnit());
		System.out.println("*****************************************");
	}

	public static void displayMenu() {
		System.out.println("*****************************************");
		System.out.println("1. Add new product in Inventory");
		System.out.println("2. Update the quantity of particular product");
		System.out.println("3. Display products where quantity less than provided");
		System.out.println("4. Display sorted products based on quantity");
		System.out.println("5. Delete a particular product from Inventory");
		System.out.println("6. Exit");
		System.out.println("*****************************************");

	}

	public static Product[] addNewProducts(Product[] products) {
		System.out.println("Enter number of products to add :");
		int newProductCount = get.nextInt();
		Product[] updatedProducts = new Product[products.length + newProductCount];
		for (int i = 0; i < products.length; i++) {
			updatedProducts[i] = products[i];
		}
		for (int i = products.length; i < products.length + newProductCount; i++) {
			updatedProducts[i] = addProduct();
		}
		return updatedProducts;
	}

	public static Product[] updateQuantityOfProduct(Product[] products) {
		if (products.length == 0) {
			System.out.println("No data available");
		} else {
			System.out.println("Enter product id : ");
			int id = get.nextInt();
			boolean productAvailable = false;
			int productIndex = 0;
			for (int i = 0; i < products.length; i++) {
				if (products[i].getId() == id) {
					productAvailable = true;
					productIndex = i;
				}
			}
			if (productAvailable) {
				System.out.println("Enter the quantity");
				int quantity = get.nextInt();
				products[productIndex].setQuantity(quantity);
			} else {
				System.out.println("No data available");
			}
		}
		return products;
	}

	public static void displayProductsWithLessQuantity(Product[] products) {
		if (products.length == 0) {
			System.out.println("No data available");
		} else {
			System.out.println("Enter the Quantity ");
			int quantityLimit = get.nextInt();
			boolean productsAvailable = false;
			System.out.println("Products with quantity less than " + quantityLimit + " are:");
			for (int i = 0; i < products.length; i++) {
				if (products[i].getQuantity() <= quantityLimit) {
					displayProduct(products[i]);
					productsAvailable = true;
				}
			}
			if (!productsAvailable) {
				System.out.println("No data available");
			}
		}
	}

	public static void sortAndDisplayByQuantity(Product[] products) {
		for (int i = 0; i < products.length; i++) {
			for (int j = 0; j < products.length; j++) {
				if (products[i].getQuantity() < products[j].getQuantity()) {
					Product temp = products[i];
					products[i] = products[j];
					products[j] = temp;
				}
			}
		}
		displayProducts(products);
	}

	public static Product[] deleteProductFromInventory(Product[] products) {
		if (products.length == 0) {
			System.out.println("No data available");
			return products;
		} else {
			System.out.println("Enter product id to delete :");
			int id = get.nextInt();
			boolean productAvailable = false;
			int productIndex = 0;
			for (int i = 0; i < products.length; i++) {
				if (products[i].getId() == id) {
					productIndex = i;
					productAvailable = true;
				}
			}
			if (productAvailable) {
				Product[] updatedProducts = new Product[products.length - 1];
				int j = 0;
				for (int i = 0; i < products.length; i++) {
					if (i == productIndex) {
						continue;
					} else {
						updatedProducts[j] = products[i];
						j++;
					}
				}
				return updatedProducts;
			} else {
				System.out.println("Product not available");
				return products;
			}
		}

	}

}
