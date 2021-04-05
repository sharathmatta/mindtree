package march23prac;
import java.util.*;
public class InsertionSort {
	public static void main(String args[]) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter array length");
		int length = get.nextInt();
		System.out.println("Enter array elements");
		int[] arr = new int[length];
		for(int i=0;i<length;i++) {
			
				arr[i] = get.nextInt();
	
		}
		for(int i=1;i<length;i++) {
			int temp = arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>temp) {
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1] = temp;
		}
		for(int i=0;i<length;i++) {
			
			System.out.print(arr[i]+"\t");

	}	
	}
}
