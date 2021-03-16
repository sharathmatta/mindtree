package march14practice;
import java.util.Scanner;
public class DiagonalOddAverage {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		int[][] arr = new int[3][3];
		System.out.println("Input matrix :");
		for(int i = 0;i<3;i++) {
			for(int j=0;j<3;j++) {
				arr[i][j] = get.nextInt();
			}
		}
		System.out.println("Matrix : ");
		for(int i = 0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		int primarySum = 0,secSum = 0;
		int primaryOddCount = 0,secOddCount = 0;
		if(arr[0][0]%2 != 0) {
			primarySum = primarySum + arr[0][0];
			primaryOddCount++;
		}
		if(arr[1][1]%2 != 0) {
			primarySum = primarySum + arr[1][1];
			secSum = secSum + arr[1][1];
			secOddCount++;
			primaryOddCount++;
		}
		if(arr[2][2]%2 != 0) {
			primarySum = primarySum + arr[2][2];
			primaryOddCount++;
		}
		if(arr[0][2]%2 != 0) {
			secSum = secSum + arr[0][2];
			secOddCount++;
		}
		if(arr[2][0]%2 != 0) {
			secSum = secSum + arr[2][0];
			secOddCount++;
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
