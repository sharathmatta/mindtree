package march10practice;
import java.util.Scanner;
public class SearchFruit {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.println("How many fruits ?");
		int fruitCount = get.nextInt();
		String[] fruits = new String[fruitCount];
		for(int i = 0;i<fruitCount;i++) {
			fruits[i] = get.next();
		}
		fruits = sort(fruits);
		System.out.println("Enter a fruit name :");
		String fruit = get.next();
		for(int i = 0;i<fruitCount;i++) {
			System.out.println(fruits[i]);
		}
	}
	
	public static String[] sort(String[] arr) {
		for(int i =0;i<arr.length;i++) {
			for(int j = i;j<arr.length;j++) {
				if(arr[i].compareTo(arr[j])>0) {
					String temp = arr[i];
					arr[i]=arr[j];
					arr[j] = temp;
				}

				
			}
		}
		return arr;
	}
}
