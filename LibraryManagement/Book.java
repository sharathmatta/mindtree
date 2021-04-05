package LibraryManagement;

public class Book {
	private long Id;
	private String Name;
	private String Publisher;
	private String Author;
	private int noOfCopies;
	
	public Book() {
		
	}
	
	public Book(long id,String name,String publisher,String author,int noOfCopies) {
		this.Id = id;
		this.Name = name;
		this.Publisher = publisher;
		this.Author = author;
		this.noOfCopies = noOfCopies;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
}
