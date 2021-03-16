package MedicalStore;

import java.util.Scanner;

public class Store {
	static Scanner get = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter no. of Customers : ");
		int N = get.nextInt();

		
		Customer[] Customers = new Customer[N];
		for (int i = 0; i < N; i++) {
			Customers[i] = addCustomer();
		}
		
		
		
		boolean flag = true;
		do {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				Customers = addNewMedToCustomer(Customers);
				break;
			case 2:
				displayBill(Customers);
				break;
			case 3:
				Customers = addDiscount(Customers);
				break;
			case 4:
				sortCustomers(Customers);
			case 5:
				Customers = deleteMedForCustomer(Customers);
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Enter a valid choice");
				break;
			}
		} while (flag);
		displayCustomers(Customers);
	}

	
	
	public static Customer addCustomer() {

		System.out.println("Enter Customer Id : ");
		int id = get.nextInt();
		System.out.println("Enter Customer Name : ");
		String Name = get.next();
		System.out.println("Enter Customer Age : ");
		int Age = get.nextInt();
		return new Customer(id, Name, Age);
	}

	
	
	public static int displayMenu() {
		System.out.println("*************************************************");
		System.out.println("1. Add medicine bought by a particular customer.");
		System.out.println("2. Display bill of a Customer");
		System.out.println("3. Add discount for Senior citizen");
		System.out.println("4. Sort and diplay Customers based on age");
		System.out.println("5. Delete particular Medicine for a particular Customer");
		System.out.println("6. Exit");
		System.out.println("*************************************************");
		int choice = get.nextInt();
		return choice;
	}

	
	public static Customer[] addNewMedToCustomer(Customer[] Customers) {
		System.out.println("Enter Id of customer you want to Update : ");
		int id = get.nextInt();
		for (int i = 0; i < Customers.length; i++) {
			if (Customers[i].getId() == id) {
				 Customers[i].addNewMedicine();
				break;
			}
			if (i == Customers.length - 1) {
				System.out.println("Invalid ID");
			}
		}
		return Customers;
	}

	
	public static void displayBill(Customer[] Customers) {
		System.out.println("Enter Id of customer : ");
		int id = get.nextInt();
		for (int i = 0; i < Customers.length; i++) {
			if (Customers[i].getId() == id) {
				 Customers[i].displayBill();
				break;
			}
			else if (i == Customers.length - 1) {
				System.out.println("Invalid ID");
			}
		}
	}
	
	public static Customer[] addDiscount(Customer[] Customers) {
		System.out.println("Enter Age limit for senior citizens : ");
		int ageLimit = get.nextInt();
		for(int i=0;i<Customers.length;i++) {
			if(Customers[i].getAge() >= ageLimit) {
				Customers[i].addDiscount();
			}
			
		}
		return Customers;
	}
	
	
	public static void sortCustomers(Customer[] Customers) {
		
	}
	
	public static Customer[] deleteMedForCustomer(Customer[] Customers) {
		System.out.println("Enter Id of Customer you want to update : ");
		int id = get.nextInt();
		for(int i=0;i<Customers.length;i++) {
			if(Customers[i].getId() == id) {
				 Customers[i].deleteMedcine();
				break;
			}
			else if (i == Customers.length - 1) {
				System.out.println("Invalid ID");
			}
		}
		return Customers;
	}
	
	public static void displayCustomers(Customer[] Customers) {
		for (int i = 0; i < Customers.length; i++) {
			Customers[i].display();
		}
	}

}
