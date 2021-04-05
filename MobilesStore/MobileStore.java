package MobilesStore;
import java.util.Scanner;
//add mobile
  //get movie details and add to existing movies
//sort and display mobiles
//update price of mobile
  //get mobile id
  //get updated price
  //update price of movie 
//delete mobile
  //get mobile id
  //if mobile available delte mobile and update mobiles
public class MobileStore extends Mobile {
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args) {
		Mobile[] mobiles = new Mobile[0];
		boolean isMenu = true;
		do {
			displayMenu();
			System.out.println("Enter your choice :");
			int choice = get.nextInt();
			switch(choice) {
			case 1:
				mobiles = addMobile(mobiles);
				displayMobiles(mobiles);
				break;
			case 2:
				sortAndDisplayMobiles(mobiles);
				break;
			case 3:
				mobiles = updatePrice(mobiles);
				displayMobiles(mobiles);
				break;
			case 4:
				mobiles = deleteMobile(mobiles);
				break;
			case 5:
				System.out.println("Application closed");
				isMenu = false;
				break;
			default:
				System.out.println("Invalid Choice");
				break;
				
			}
			
		}while(isMenu);
	}
	
	public static void displayMenu() {
		System.out.println();
		System.out.println("1-> Add a new mobile");
		System.out.println("2-> Sort and Display mobiles");
		System.out.println("3-> Update price of mobile");
		System.out.println("4-> Delete a Mobile");
		System.out.println("5-> Exit");
		System.out.println();
	}
	
	public static Mobile[] addMobile(Mobile[] mobiles) {
		Mobile[] updatedMobiles = new Mobile[mobiles.length + 1];
		for(int i = 0;i<mobiles.length;i++) {
			updatedMobiles[i] = mobiles[i];
		}
		System.out.println("Enter Mobile id :");
		int id = get.nextInt();
		System.out.println("Enter model of the Mobile :");
		get.nextLine();
		String model = get.nextLine();
		System.out.println("Enter the price of the mobile :");
		double price = get.nextDouble();
		System.out.println("Enter Date of Manufacture (DD/MM/YYYY) :");
		get.nextLine();
		String dateOfManufacture = get.nextLine();
		Mobile mobile = new Mobile(id,model,price,dateOfManufacture);
		updatedMobiles[mobiles.length] = mobile;
		return updatedMobiles;
	}
	
	public static void sortAndDisplayMobiles(Mobile[] mobiles) {
		for(int i = 0;i<mobiles.length;i++) {
			for(int j = i;j<mobiles.length;j++) {
				if(mobiles[i].getModel().compareTo(mobiles[j].getModel())>0) {
					Mobile temp = mobiles[i];
					mobiles[i] = mobiles[j];
					mobiles[j] = temp;
				}
			}
		}
		displayMobiles(mobiles);
	}
	
	
	public static Mobile[] updatePrice(Mobile[] mobiles) {
		if(mobiles.length == 0) {
			System.out.println("No data available");
			return mobiles;
		}else {
			System.out.println("Enter the mobile id :");
			int id = get.nextInt();
			boolean isMobileExists = false;
			int mobileIndex = 0;
			for(int i = 0;i<mobiles.length;i++) {
				if(mobiles[i].getId() == id) {
					mobileIndex = i;
					isMobileExists = true;
					break;
				}
			}
			if(isMobileExists) {
				System.out.println("Enter updated price :");
				double updatedPrice = get.nextDouble();
				mobiles[mobileIndex].setPrice(updatedPrice);
			}
			return mobiles;
		}
	}
	
	
	public static Mobile[] deleteMobile(Mobile[] mobiles) {
		if(mobiles.length == 0) {
			System.out.println("No data available");
			return mobiles;
		}
		else {
			System.out.println("Enter the mobile id :");
			int id = get.nextInt();
			boolean mobileExists = false;
			int mobileIndex = 0;
			for(int i = 0;i<mobiles.length;i++) {
				if(id == mobiles[i].getId()) {
					mobileExists = true;
					mobileIndex = i;
					break;
				}
			}
			if(mobileExists) {
				Mobile[] updatedMobiles = new Mobile[mobiles.length-1];
				int j = 0;
				for(int i = 0;i<mobiles.length;i++) {
					if(i == mobileIndex) {
						continue;
					}
					updatedMobiles[j] = mobiles[i];
					j++;
				}
				return updatedMobiles;
			}
			else {
				return mobiles;
			}
		}
		
	}
	
	public static void displayMobiles(Mobile[] mobiles) {
		if(mobiles.length == 0) {
			System.out.println("No data available");
		}
		else {
			for(int i = 0;i<mobiles.length;i++) {
				displayMobile(mobiles[i]);
			}
		}
	}
	
	
	public static void displayMobile(Mobile mobile) {
		System.out.println();
		System.out.println("Id\t\t\t:"+mobile.getId());
		System.out.println("Model\t\t\t:"+mobile.getModel());
		System.out.println("Price\t\t\t:"+mobile.getPrice());
		System.out.println("Date of Manufacture\t:"+mobile.getDateOfManufacture());
	}

}



