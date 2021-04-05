package LibraryManagement;

//task1 add book and display all books
	//get book details and add to existing books
	//display all books
//search and display book name with even characters replaced 
	//get book name
	//if book available replace even positioned characters and display
//sort book by its author
//update no. of copies of a book by its id
	//get book id
	//if book available get book index
	//get updated no of copies
	//set no of copies of book at index to user input
//exit
import java.util.Scanner;
public class LibraryManagement extends Book {
	static Scanner get = new Scanner(System.in);
	public static void main(String args[]) {
		Book[] books = new Book[0];
		boolean isMenu = true;
		do {
			displayMenu();
			
			int choice = get.nextInt();
			switch(choice){
			case 1:
				books = addBooks(books);
				displayBooks(books);
				break;
			case 2:
				searchBookByName(books);
				break;
			case 3:
				books  = sortBooks(books);
				displayBooks(books);
				break;
			case 4:
				books = updateNoOfCopies(books);
				displayBooks(books);
				break;
			case 5:
				books = deleteBook(books);
				displayBooks(books);
				break;
				
			case 6:
				System.out.println("Application closed");
				isMenu = false;
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			}while(isMenu);
	}
	
	
	public static Book[] deleteBook(Book[] books) {
		Book[] updatedBooks = new Book[books.length-1];
		System.out.println("Enter the id of the book to delete :");
		long id = get.nextLong();
		for(int i=0;i<books.length;i++) {
			if(books[i].getId() == id) {
				books[i] = null;
				continue;
			}
			
		}
		int updatedIndex = 0;
		for(int i = 0;i<books.length;i++) {
			if(books[i] != null) {
				updatedBooks[updatedIndex] = books[i];
				updatedIndex++;
			}
		}
		return updatedBooks;
	}
	
	
	public static void displayMenu() {
		System.out.println("Enter your choice :");
		System.out.println("1. Add Book and display all books");
		System.out.println("2. Search book by name");
		System.out.println("3. Sort books by its author");
		System.out.println("4. Update no. of copies of a book");
		System.out.println("5. Delete a book");
		System.out.println("6. Exit");
		System.out.println();
		
	}
	
	public static void displayBooks(Book[] books) {
		if(books.length == 0) {
			System.out.println("No data available");
		}
		else {
			for(int i = 0;i<books.length;i++) {
				System.out.println("Id\t\t:"+books[i].getId());
				System.out.println("Name\t\t:"+books[i].getName());
				System.out.println("Publisher\t:"+books[i].getPublisher());
				System.out.println("Author\t\t:"+books[i].getAuthor());
				System.out.println("No of Copies\t:"+books[i].getNoOfCopies());
				System.out.println("-------------------------------");
			}
		}
	}

	public static Book[] addBooks(Book[] books) {
		Book[] updatedBooks = new Book[books.length+1];
		for(int i = 0;i<books.length;i++) {
			updatedBooks[i] = books[i];
		}
		System.out.println("Enter book id");
		long id = get.nextLong();
		System.out.println("Enter book name");
		get.nextLine();
		String name = get.nextLine();
		System.out.println("Enter book publisher");
		String publisher = get.nextLine();
		System.out.println("Enter book author");
		String author  = get.nextLine();
		System.out.println("Enter no of copies");
		int noOfCopies = get.nextInt();
		updatedBooks[books.length] = new Book(id,name,publisher,author,noOfCopies);
		return updatedBooks;
	}
	
	public static Book[] sortBooks(Book[] books) {
//		for(int i = 1;i<books.length;i++) {
//			Book key = books[i];
//			int j = i-1;
//			while(j>=0 && books[j].getAuthor().compareTo(key.getAuthor())>0) {
//				books[j+1] = books[j];
//				j--;
//			}
//			books[j+1] = key;
//		}
		
		for(int i=0;i<books.length;i++) {
			for(int j=0;j<books.length-i-1;j++) {
				if(books[j].getAuthor().compareTo(books[j+1].getAuthor())<0) {
					Book temp = books[j];
					books[j] = books[j+1];
					books[j+1] = temp;
				}
			}
		}
		
		return books;
	}
	public static Book[] updateNoOfCopies(Book[] books) {
		if(books.length == 0) {
			System.out.println("No data available");
			
		}
		else {
			System.out.println("Enter id of the book :");
			long id  = get.nextLong();
			for(int i = 0;i<books.length;i++) {
				if(books[i].getId() == id) {
					System.out.println("Enter updated no of copies");
					int noOfCopies = get.nextInt();
					books[i].setNoOfCopies(noOfCopies);
					break;
				}
			}
		}
		
		return books;
	}

	public static void searchBookByName(Book[] books) {
		if(books.length == 0) {
			System.out.println("No data available");
		}
		else {
			System.out.println("Enter the book name");
			get.nextLine();
			String name = get.nextLine();
			for(int i = 0;i<books.length;i++) {
				if(books[i].getName().compareTo(name) == 0) {
					String replacedName = getReplacedName(name);
					System.out.println("Id\t\t:"+books[i].getId());
					System.out.println("Name\t\t:"+replacedName);
					System.out.println("Publisher\t:"+books[i].getPublisher());
					System.out.println("Author\t\t:"+books[i].getAuthor());
					System.out.println("No of Copies\t:"+books[i].getNoOfCopies());
					System.out.println("-------------------------------");
					break;
				}
			}
		}
	}
	public static String getReplacedName(String str) {
		String result = "";
		int i = 0;
		while(i<str.length()) {
			int asciiVal = (int)str.charAt(i);
			if(i%2 != 0) {
				if(asciiVal >=97 && asciiVal <122) {
					asciiVal = asciiVal -31;
				}
				else if(asciiVal == 122) {
					asciiVal = 65;
				}
			}
			result = result + (char)asciiVal;
			i++;
		}
		return result;
	}
	
}
