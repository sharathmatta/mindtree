package march14practice;
import java.util.Scanner;
public class DynamicOddAverage {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.println("Matrix size :");
		int size = get.nextInt();
		int[][] arr = new int[size][size];
		System.out.println("Enter matrix elements :");
		arr = get2DArray(size);
		System.out.println("Matrix : ");
		display2DArray(arr);
		int primarySum = 0,primaryOddCount = 0,secSum = 0,secOddCount=0;
		for(int i=0;i<size;i++) {
			//if a[i][i] is odd add to primary sum
			if(arr[i][i]%2 != 0) {
				primarySum = primarySum + arr[i][i];
				primaryOddCount++;
			}
			//if arr[i][size-i-1] is odd add to secondar sum
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
	public static void display2DArray(int[][] arr) {
		for(int i = 0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static int[][] get2DArray(int l) {
		Scanner get = new Scanner(System.in);
		int[][] arr = new int[l][l];
		for(int i = 0;i<l;i++) {
			for(int j=0;j<l;j++) {
				arr[i][j] = get.nextInt();
			}
		}
		return arr;
	}
}
