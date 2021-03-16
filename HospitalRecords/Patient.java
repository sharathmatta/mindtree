package HospitalRecords;

public class Patient {
	private String Name;
	private int DaysAdmitted;
	private String Illness;
	private double BillAmount;
	private String Doctor;
	
	
	public Patient(){
		
	}
	
	public Patient(String name, int daysAdmitted, String illness,double billAmount, String doctor) {
		super();
		this.Name = name;
		this.DaysAdmitted = daysAdmitted;
		this.Illness = illness;
		this.BillAmount = billAmount;
		this.Doctor = doctor;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getDaysAdmitted() {
		return DaysAdmitted;
	}

	public void setDaysAdmitted(int daysAdmitted) {
		DaysAdmitted = daysAdmitted;
	}

	public String getIllness() {
		return Illness;
	}

	public void setIllness(String illness) {
		Illness = illness;
	}

	public double getBillAmount() {
		return BillAmount;
	}

	public void setBillAmount(double billAmount) {
		BillAmount = billAmount;
	}

	public String getDoctor() {
		return Doctor;
	}

	public void setDoctor(String doctor) {
		Doctor = doctor;
	}
	
}
