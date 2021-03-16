package march14practice;
import java.util.Scanner;
public class DynamicOddAverage {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.println("Matrix size :");
		int size = get.nextInt();
		int[][] arr = new int[size][size];
		System.out.println("Enter matrix elements :");
		for(int i = 0;i<size;i++) {
			for(int j=0;j<size;j++) {
				arr[i][j] = get.nextInt();
			}
		}
		System.out.println("Matrix : ");
		for(int i = 0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		int primarySum = 0,primaryOddCount = 0,secSum = 0,secOddCount=0;
		for(int i=0;i<size;i++) {
			if(arr[i][i]%2 != 0) {
				primarySum = primarySum + arr[i][i];
				primaryOddCount++;
			}
			if(arr[i][size-i-1]%2 !=0) {
				secSum = secSum +arr[i][size-i-1];
				secOddCount++;
			}
		}
		if(primaryOddCount!=0) {
			System.out.println("Primary diagonal odd numbers average : "+primarySum/primaryOddCount);
		}
		else {
			System.out.println("No odd numbers in primary diagonal");
		}
		if(secOddCount!=0) {
			System.out.println("Secondary diagonal odd numbers average : "+secSum/secOddCount);
		}
		else {
			System.out.println("No odd numbers in secondary diagonal");
		}
	}
}
