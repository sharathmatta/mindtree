package MovieManager;

public class Movie {
	private int id;
	private String Name;
	private String[] Casting;
	private int YearOfRelease;
	private int Rating;
	
	public Movie() {
		
	}
	
	public Movie(int id,String name,String[] casting,int yearOfRelease,int rating) {
		this.id = id;
		this.Name = name;
		this.Casting = casting;
		this.YearOfRelease = yearOfRelease;
		this.Rating = rating;
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

	public String[] getCasting() {
		return Casting;
	}

	public void setCasting(String[] casting) {
		Casting = casting;
	}

	public int getYearOfRelease() {
		return YearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		YearOfRelease = yearOfRelease;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}
	
	
}
