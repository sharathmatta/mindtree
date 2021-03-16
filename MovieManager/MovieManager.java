package MovieManager;
import java.util.Scanner;
public class MovieManager extends Movie {
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args) {
		Movie[] movies = new Movie[0];
		boolean isMenu = true;
		do {
			displayMenu();
			System.out.println("Enter your choice :");
			int choice = get.nextInt();
			switch(choice) {
			case 1:
				movies = addMovie(movies);
				for(int i = 0;i<movies.length;i++) {
					displayMovie(movies[i]);
				}
				break;
			case 2:
				sortMovies(movies);
				break;
			case 3:
				moviesWithGreaterRating(movies);
				break;
			case 4:
				moviesOfCast(movies);
				break;
			case 5:
				movies = updateRating(movies);
				for(int i = 0;i<movies.length;i++) {
					displayMovie(movies[i]);
				}
				break;
			case 6:
				movies = deleteMovie(movies);
				for(int i = 0;i<movies.length;i++) {
					displayMovie(movies[i]);
				}
				break;
			case 7:
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
		System.out.println("1-> Add a new Movie");
		System.out.println("2-> Sort Movies based on year");
		System.out.println("3-> Display movies with rating greater than the input");
		System.out.println("4-> Display movies of a casting");
		System.out.println("5-> Update rating of a movie");
		System.out.println("6-> Delete a movie");
		System.out.println("7-> Exit");
		System.out.println();
	}
	
	public static Movie[] addMovie(Movie[] movies) {
		Movie[] updatedMovies = new Movie[movies.length + 1];
		for(int i = 0;i<movies.length;i++) {
			updatedMovies[i] = movies[i];
		}
		System.out.println("Enter movie id :");
		int id = get.nextInt();
		System.out.println("Enter movie name :");
		get.nextLine();
		String name = get.nextLine();
		System.out.println("Enter the number of cast members :");
		int castCount = get.nextInt();
		String[] cast = new String[castCount];

		get.nextLine();
		for(int i = 0;i<castCount;i++) {
			System.out.println("Enter name of cast member "+i+1);
			cast[i] = get.nextLine();
		}
		System.out.println("Enter year of release :");
		int year = get.nextInt();
		int rating = 1;
		do {
			System.out.println("Enter rating of the movie :");
			rating = get.nextInt();
			
		}while(!(rating>=1 && rating<=5));
		updatedMovies[movies.length] = new Movie(id,name,cast,year,rating);
		return updatedMovies;
	}

	public static void displayMovie(Movie movie) {
		System.out.println();
		System.out.println("Id\t\t\t:"+movie.getId());
		System.out.println("Name\t\t\t:"+movie.getName());
		System.out.println("Casting\t\t\t:");
		String[] cast = movie.getCasting();
		for(int i = 0;i<cast.length;i++) {
			System.out.println(cast[i]);
		}
		System.out.print("\n");
		System.out.println("Year of release\t\t:"+movie.getYearOfRelease());
		System.out.println("Rating\t\t\t:"+movie.getRating());
	}
	
	
	public static void sortMovies(Movie[] movies) {
		for(int i = 0;i<movies.length;i++) {
			for(int j = i;j<movies.length;j++) {
				if(movies[i].getYearOfRelease() > movies[j].getYearOfRelease()) {
					Movie temp = movies[i];
					movies[i] = movies[j];
					movies[j] = temp;
				}
				else if(movies[i].getYearOfRelease() == movies[j].getYearOfRelease()) {
					if(movies[i].getName().compareToIgnoreCase(movies[j].getName())>0) {
						Movie temp = movies[i];
						movies[i] = movies[j];
						movies[j] = temp;
					}
				}
			}
		}
		for(int i = 0;i<movies.length;i++) {
			displayMovie(movies[i]);
		}
	}
	
	
	
	
	
	public static Movie addMovie() {
		System.out.println("Enter movie id :");
		int id = get.nextInt();
		System.out.println("Enter movie name :");
		get.nextLine();
		String name = get.nextLine();
		System.out.println("Enter the number of cast members :");
		int castCount = get.nextInt();
		String[] cast = new String[castCount];

		get.nextLine();
		for(int i = 0;i<castCount;i++) {
			System.out.println("Enter name of cast member "+i+1);
			cast[i] = get.nextLine();
		}
		System.out.println("Enter year of release :");
		int year = get.nextInt();
		int rating = 1;
		do {
			System.out.println("Enter rating of the movie :");
			rating = get.nextInt();
			
		}while(!(rating>=1 || rating<=5));
		Movie movie = new Movie(id,name,cast,year,rating);
		return movie;
	}
	
	public static void moviesWithGreaterRating(Movie[] movies) {
		System.out.println("Enter required rating :");
		int rating = get.nextInt();
		for(int i = 0;i<movies.length;i++) {
			if(movies[i].getRating()>=rating) {
				displayMovie(movies[i]);
			}
		}
	}
	
	public static void moviesOfCast(Movie[] movies) {
		if(movies.length == 0) {
			System.out.println("No data available");
		}
		else {
			System.out.println("Enter the name of Cast :");
			get.nextLine();
			boolean isMoviesAvailable = false;
			String castName = get.nextLine();
			for(int i = 0;i<movies.length;i++) {
				String[] casting = movies[i].getCasting();
				for(int j = 0;j<casting.length;j++) {
					if(casting[j].equals(castName)) {
						isMoviesAvailable = true;
						displayMovie(movies[i]);
					}
				}
				
			}
			if(!isMoviesAvailable) {
				System.out.println(castName + " has no movies");
			}
		}
	}
	
	public static Movie[] updateRating(Movie[] movies) {
		if(movies.length == 0) {
			System.out.println("No data available");
			return movies;
		}
		else {
			System.out.println("Enter the movie id :");
			int id = get.nextInt();
			boolean isMovieAvailable= false;
			for(int i=0;i<movies.length;i++) {
				if(movies[i].getId() == id) {
					
					int rating = 0;
					do {
						System.out.println("Enter updated rating (1-5):");
						rating = get.nextInt();
					}while(!(rating>=1 && rating <=5));
					movies[i].setRating(rating);
					isMovieAvailable = true;
				}
			}
			if(!isMovieAvailable) {
				System.out.println("Movie not found");
			}
			return movies;
		}
	}
	
	
	public static Movie[] deleteMovie(Movie[] movies) {
		if(movies.length == 0) {
			System.out.println("No data available");
			return movies;
		}
		else {
			System.out.println("Enter movie id to delete :");
			int id = get.nextInt();
			int movieIndex = 0;
			boolean isMovieAvailable = false;
			for(int i=0;i<movies.length;i++) {
				if(movies[i].getId() == id) {
					movieIndex = i;
					isMovieAvailable = true;
				}
				
			}
			if(isMovieAvailable) {
				Movie[] updatedMovies = new Movie[movies.length - 1];
				int j = 0;
				for(int i = 0;i<movies.length;i++) {
					if(i == movieIndex) {
						continue;
					}
					updatedMovies[j] = movies[i];
					j++;
				}
				return updatedMovies;
			}
			System.out.println("Movie not found");
			return movies;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
