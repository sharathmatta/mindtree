package march10practice;
import java.util.Scanner;
public class NegativeResults {

	static Scanner get = new Scanner(System.in);
	public static void main(String[] args) {
		//get array length
		System.out.println("Enter the length of arrays");
		int arrayLength = get.nextInt();
		//get array elements
		int[] arr1 = new int[arrayLength];
		System.out.println("Enter Array 1 elements ");
		arr1 = get1DArray(arrayLength);
		int[] arr2 = new int[arrayLength];
		System.out.println("Enter Array 2 elements ");
		arr2 = get1DArray(arrayLength);
		
		
		// get result array after substraction
		int[] resultArr = substract(arr1,arr2);
		System.out.println("Resultant array :" );
		display1DArray(resultArr);
		
		//display negative elements
		System.out.println("\nResultant negative array :" );
		displayNegatives(resultArr);
		
	}
	public static int[] get1DArray(int l) {
		int[] arr = new int[l];
		for(int i=0;i<l;i++) {
			arr[i] = get.nextInt();
		}
		return arr;
	}
	public static int[] substract(int[] arr1,int[] arr2) {
		int[] resultArr = new int[arr1.length];
		for(int i=0;i<resultArr.length;i++) {
			resultArr[i] = arr1[i] - arr2[i];
			
		}
		return resultArr;
		
	}
	public static void display1DArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void displayNegatives(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<0) {
				System.out.print(arr[i]+" ");
			}
		}
	}

}
