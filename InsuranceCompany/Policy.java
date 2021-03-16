package InsuranceCompany;

public class Policy {
	private long id;
	private long Number;
	private String Type;
	private double PremiumFee;
	private String PremiumMode;
	
	public Policy() {
		
	}
	
	public Policy(long id,long number,String type,double premiumFee,String premiumMode) {
		this.id = id;
		this.Number = number;
		this.Type = type;
		this.PremiumFee = premiumFee;
		this.PremiumMode = premiumMode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumber() {
		return Number;
	}

	public void setNumber(long number) {
		Number = number;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public double getPremiumFee() {
		return PremiumFee;
	}

	public void setPremiumFee(double premiumFee) {
		PremiumFee = premiumFee;
	}

	public String getPremiumMode() {
		return PremiumMode;
	}

	public void setPremiumMode(String premiumMode) {
		PremiumMode = premiumMode;
	}
	
	
}
