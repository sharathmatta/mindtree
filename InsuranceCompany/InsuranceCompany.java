package InsuranceCompany;
import java.util.Scanner;

public class InsuranceCompany extends Policy {
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args) {
		Policy[] policies = new Policy[0];
		boolean isMenu = true;
		do {
			displayMenu();
			System.out.println("Enter your choice");
			int choice = get.nextInt();
			switch(choice) {
			case 1:
				policies = addPolicies(policies);
				for(int i = 0 ;i<policies.length;i++) {
					displayPolicy(policies[i]);
				}
				break;
			case 2:
				displayPolicies(policies);
				break;
			case 3:
				sortAndDisplay(policies);
				break;
			case 4:
				policies = updatePremiumFee(policies);
				break;
			case 5:
				isMenu = false;
				System.out.println("\nApplication closed");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}while(isMenu);
	}
	
	
	public static void displayMenu() {
		System.out.println("1. Add policies");
		System.out.println("2. Display policies with selected mode and has less than required fee :");
		System.out.println("3. Sort and display policies by policy number");
		System.out.println("4. Update Premium fee details of a policy");
		System.out.println();
	}
	
	
	public static Policy[] addPolicies(Policy[] policies) {
		//get number of policies to be added 
		System.out.println("Enter number of policies to be added :");
		int newPolicyCount = get.nextInt();
		Policy[] updatedPolicies = new Policy[policies.length + newPolicyCount];
		for(int i = 0;i<policies.length;i++) {
			updatedPolicies[i] = policies[i];
		}
		for(int i=0;i<newPolicyCount;i++) {
			//get policy details
			System.out.println("Enter policy id :");
			long id = get.nextLong();
			System.out.println("Enter policy number :");
			long number = get.nextLong();
			System.out.println("Enter policy type :");
			String type = get.next();
			System.out.println("Enter Premium fee :");
			double premiumFee = get.nextDouble();
			String mode = "";
			boolean isValidChoice = false;
			do {
				System.out.println("Select mode of policy :\n1.Quaterly\t2. Halfyearly\t3. Yearly");
				int choice = get.nextInt();
				switch(choice) {
				case 1:
					mode = "Quaterly";
					isValidChoice = true;
					break;
				case 2:
					mode = "Halfyearly";
					isValidChoice = true;
					break;
				case 3:
					mode = "Yearly";
					isValidChoice = true;
					break;
				default:
					System.out.println("Invalid Choice");
					break;
					
				}
			}while(!isValidChoice);
			//create new policy with input details
			updatedPolicies[policies.length + i] = new Policy(id,number,type,premiumFee,mode);
		}
		return updatedPolicies;
	}
	
	public static Policy[] updatePremiumFee(Policy[] policies) {
		if(policies.length == 0) {
			System.out.println("No data available");
		}
		else {
			System.out.println("Enter policy number :");
			long number = get.nextLong();
			boolean isPolicyExist  = false;
			int policyIndex = 0;
			for(int i = 0;i<policies.length;i++) {
				if(policies[i].getNumber() == number) {
					
					System.out.println("Enter updated fee amount : ");
					double fee = get.nextDouble();
					policies[i].setPremiumFee(fee);
					isPolicyExist = true;
					policyIndex = i;
				}
			}
			if(isPolicyExist) {
				System.out.println("Policy fee updated");
				displayPolicy(policies[policyIndex]);
			}
			else {
				System.out.println("Policy does not exist");
			}
		}
		return policies;
	}
	
	public static void displayPolicies(Policy[] policies) {
		
		  //get mode of policy
		String mode = "";
		boolean isValidChoice = false;
		do {
			System.out.println("Select mode of policy :\n1.Quaterly\t2. Halfyearly\t3. Yearly");
			int choice = get.nextInt();
			switch(choice) {
			case 1:
				mode = "Quaterly";
				isValidChoice = true;
				break;
			case 2:
				mode = "Halfyearly";
				isValidChoice = true;
				break;
			case 3:
				mode = "Yearly";
				isValidChoice = true;
				break;
			default:
				System.out.println("Invalid Choice");
				break;
				
			}
		}while(!isValidChoice);
		
		  //get required fee amount
		System.out.println("Enter premium fee limit :");
		double premiumFee = get.nextDouble();
		boolean isPoliciesExist = false;
		for(int i = 0;i<policies.length;i++) {
			//display policies with given mode and has less than required fee amount
			if(policies[i].getPremiumMode().equals(mode) && policies[i].getPremiumFee() < premiumFee) {
				isPoliciesExist = true;
				displayPolicy(policies[i]);
			}
		}
		if(!isPoliciesExist) {
			System.out.println("No policies found");
		}
		  
	}
	public static void sortAndDisplay(Policy[] policies) {
		//sort policies
		for(int i =0;i<policies.length;i++) {
			for(int j = i;j<policies.length ;j++) {
				if(policies[i].getNumber() > policies[j].getNumber()) {
					Policy temp = policies[i];
					policies[i] = policies[j];
					policies[j] = temp;
				}
			}
		}
		//display policies
		for(int i = 0;i<policies.length;i++) {
			displayPolicy(policies[i]);
		}
	}
	public static void displayPolicy(Policy policy) {
		System.out.println();
		System.out.println("Id\t\t:"+policy.getId());
		System.out.println("Number\t\t:"+policy.getNumber());
		System.out.println("Type\t\t:"+policy.getType());
		System.out.println("Premium Fee\t:"+policy.getPremiumFee());
		System.out.println("Premium Mode\t:"+policy.getPremiumMode());
		
	}
	
}
