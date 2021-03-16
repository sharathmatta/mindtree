package HospitalRecords;
import java.util.Scanner;
public class HospitalRecords extends Patient {
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args) {
		boolean menu = true;
		System.out.println("Enter the number of Patients :");
		int patientCount = get.nextInt();
		Patient[] patients ;
		patients = new Patient[patientCount];
		for(int i = 0;i<patientCount;i++) {
			patients[i] = addPatient();
		}
		displayPatients(patients);
		do {
			displayMenu();
			System.out.println("Enter Your Choice :");
			int choice  = get.nextInt();
			switch(choice) {
			case 1:
				patients = addIncomingPatients(patients);
				System.out.println("Updated Patients Data :");
				displayPatients(patients);
				break;
			case 2:
				patients = deleteOutgoingPatients(patients);
				System.out.println("Updated Patients Data :");
				displayPatients(patients);
				break;
			case 3:
				displayPatientsTreatedByDoctor(patients);
				break;
			case 4:
				
				displayPatientOfSameIllness(patients);
				break;
			case 5:
				displayLowestBilledPatient(patients);
				break;
			case 6:
				menu = false;
				break;
			default:
				break;
				
			}
			
		}while(menu);
	}
	
	public static Patient addPatient() {
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
			System.out.println("Enter the name of the patient :");
			String patientName = get.next();
			
			boolean patientAvailable = false;
			for(int i = 0;i<patients.length;i++) {
				if(patients[i].getName().equals(patientName)) {
					patientAvailable = true;
				}
				
			}
			
			if(patientAvailable) {
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
			System.out.println("Enter illness name :");
			String illnessName = get.next();
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
			System.out.println("Enter doctor name :");
			String doctorName = get.next();
			boolean patientsAvailable = false;
			for(int i = 0;i<patients.length;i++) {
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
