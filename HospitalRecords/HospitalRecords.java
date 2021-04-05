package HospitalRecords;
import java.util.Scanner;

public class HospitalRecords extends Patient {
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args) {
		boolean menu = true;
		Patient[] patients =new Patient[0];
		do {
			displayMenu();
			System.out.println("Enter Your Choice :");
			int choice  = get.nextInt();
			switch(choice) {
			case 1:
				//add patients
				  
				patients = addIncomingPatients(patients);
				System.out.println("Updated Patients Data :");
				displayPatients(patients);
				break;
			case 2:
				//delete patient and update patients
				
				patients = deleteOutgoingPatients(patients);
				System.out.println("Updated Patients Data :");
				displayPatients(patients);
				break;
			case 3:
				//display patients treated by a doctor
				  
				displayPatientsTreatedByDoctor(patients);
				break;
			case 4:
				//display patients of same illness
				  
				displayPatientOfSameIllness(patients);
				break;
			case 5:
				//display lowest billed patient
				
				displayLowestBilledPatient(patients);
				break;
			case 6:
				System.out.println("Application closed");
				menu = false;
				break;
			default:
				System.out.println("Invalid Choice");
				break;
				
			}
			
		}while(menu);
	}
	
	
	
	public static Patient addPatient() {
		//get details and add
				
		System.out.println("Enter the Patient name :");
		String name = get.next();
		System.out.println("Enter the number of Days Admitted :");
		int Days = get.nextInt();
		System.out.println("Enter the Illness name :");
		String illness = get.next();
		System.out.println("Enter the Bill Amount :");
		double billAmount = get.nextDouble();
		System.out.println("Enter the Doctor name :");
		String doctor = get.next();
		Patient patient = new Patient(name,Days,illness,billAmount,doctor);
		return patient;
	}
	
	
	
	public static void displayPatients(Patient[] patients) {
		if(patients.length == 0) {
			System.out.println("No data available");
		}
		else {
			for(int i = 0;i<patients.length;i++) {
				displayPatient(patients[i]);
			}
		}
	}
	
	
	
	public static void displayPatient(Patient patient) {
		System.out.println("*******************************************");
		System.out.println("Patient Name\t:"+patient.getName());
		System.out.println("Days Admitted\t:"+patient.getDaysAdmitted());
		System.out.println("Illness Name\t:"+patient.getIllness());
		System.out.println("Bill Amount\t:"+patient.getBillAmount());
		System.out.println("Doctor Name\t:"+patient.getDoctor());
		
		
	}
	
	
	
	public static void displayMenu() {
		System.out.println("*******************************************");
		System.out.println("1. Add Incoming Patients");
		System.out.println("2. Delete Outgoing Patients");
		System.out.println("3. Display Patients treated by particular doctor");
		System.out.println("4. Display Patients having same illness");
		System.out.println("5. Display patients name who have billed lowest");
		System.out.println("6. Exit");
		System.out.println("*******************************************");
		
	}
	
	
	
	public static Patient[] addIncomingPatients(Patient[] patients) {
		//get no of patients
		  
		System.out.println("Enter number of new patients :");
		int newPatientCount = get.nextInt();
		Patient[] updatedPatients = new Patient[patients.length + newPatientCount];
		for(int i = 0;i<patients.length;i++) {
			updatedPatients[i] = patients[i];
		}
		for(int i = patients.length ; i<patients.length + newPatientCount;i++) {
			updatedPatients[i] = addPatient(); 
		}
		return updatedPatients;
	}
	
	
	
	public static Patient[] deleteOutgoingPatients(Patient[] patients) {
		
		if(patients.length == 0) {
			System.out.println("No data available");
			return patients;
		}
		else {
			//get patient name
			  
			System.out.println("Enter the name of the patient :");
			String patientName = get.next();
			//check if patient available
			boolean patientAvailable = false;
			for(int i = 0;i<patients.length;i++) {
				if(patients[i].getName().equals(patientName)) {
					patientAvailable = true;
				}
				
			}
			
			if(patientAvailable) {
				//delete patient if available
				
				Patient[] updatedPatients = new Patient[patients.length -1];
				int j = 0;
				for(int i = 0;i<patients.length;i++) {
					if(patients[i].getName().equals(patientName)) {
						continue;
					}
					updatedPatients[j] = patients[i];
					j++;
					
				}
				return updatedPatients;
				
			}
			else {
				System.out.println("Patient Details not available");
				return patients;
				
			}
		}
		
		
		
	}
	
	
	
	
	public static void displayPatientOfSameIllness(Patient[] patients) {
		if(patients.length == 0) {
			System.out.println("No data available");
			
		}
		else {
			//get illness name
			  
			System.out.println("Enter illness name :");
			String illnessName = get.next();
			//find patients with the illness and display
			
			boolean patientsAvailable = false;
			for(int i = 0;i<patients.length;i++) {
				if(patients[i].getIllness().equals(illnessName)) {
					displayPatient(patients[i]);
					patientsAvailable = true;
				}
			}
			if(!patientsAvailable) {
				System.out.println("No patientsAvailable");
			}
		}
	}

	
	
	
	public static void displayPatientsTreatedByDoctor(Patient[] patients) {
		if(patients.length == 0) {
			System.out.println("No data available");
			
		}
		else {
			//get doctor name
			  
			System.out.println("Enter doctor name :");
			String doctorName = get.next();
			boolean patientsAvailable = false;
			for(int i = 0;i<patients.length;i++) {
				//find patients treated by doc and display
				
				if(patients[i].getDoctor().equals(doctorName)) {
					
					displayPatient(patients[i]);
					patientsAvailable = true;
				}
			}
			if(!patientsAvailable) {
				System.out.println("No patientsAvailable");
			}
		}
	}
	
	
	
	
	public static void displayLowestBilledPatient(Patient[] patients) {
		if(patients.length == 0) {
			System.out.println("No data available");
			
		}
		else {
			//find lowestbilled patient index
			int lowestBilledIndex= 0;
			for(int i = 1;i<patients.length;i++) {
				if(patients[lowestBilledIndex].getBillAmount() > patients[i].getBillAmount()) {
					lowestBilledIndex = i;
				}
			}
			displayPatient(patients[lowestBilledIndex]);
		}
		
	}

}
