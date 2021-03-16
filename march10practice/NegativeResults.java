package march10practice;
import java.util.Scanner;
public class NegativeResults {
	
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter the length of arrays");
		int arrayLength = get.nextInt();
		
		int[] arr1 = new int[arrayLength];
		int[] arr2 = new int[arrayLength];
		System.out.println("Enter Array 1 elements ");
		for(int i=0;i<arrayLength;i++) {
			arr1[i] = get.nextInt();
		}
		System.out.println("Enter Array 2 elements ");
		for(int i=0;i<arrayLength;i++) {
			arr2[i] = get.nextInt();
		}
		int[] resultArr = new int[arrayLength];
		for(int i=0;i<arrayLength;i++) {
			resultArr[i] = arr1[i] - arr2[i];
			
		}
		System.out.println("Resultant array :" );
		for(int i = 0;i<arrayLength;i++) {
			System.out.print(resultArr[i]+" ");
		}
		System.out.println("\nResultant negative array :" );
		for(int i = 0;i<arrayLength;i++) {
			if(resultArr[i]<0) {
				System.out.print(resultArr[i]+" ");
			}
		}
		
	}
	

}
