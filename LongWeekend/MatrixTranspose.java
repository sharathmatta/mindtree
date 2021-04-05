package LongWeekend;
import java.util.Scanner;
//get no of rows and columns m,n
//get matrix of m rows and n columns
//create new matrix array of n rows and m columns ->transposeArr
//run two for loops i = 0 to M,j=0 to N
//copy original[i][j] to transposArr[j][i]
//display transposeArr
public class MatrixTranspose {
	static Scanner get = new Scanner(System.in);
	public static void main(String args[]) {
		
		System.out.println("Enter the no. of rows :");
		int M = get.nextInt();
		System.out.println("Enter the no. of columns :");
		int N = get.nextInt();
		System.out.println("Enter matrix elements :");
		int[][] arr = getMatrix(M,N);
		System.out.println("Input Matrix :");
		display2DArray(arr,M,N);
		arr = getTransposeMatrix(arr,M,N);	
		System.out.println("Transpose Matrix :");
		display2DArray(arr,N,M);
	}
	public static int[][] getTransposeMatrix(int[][] arr,int m,int n){
		int[][] transposeArr = new int[n][m];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				transposeArr[j][i] = arr[i][j];
			}
		}
		return transposeArr;
	}
	public static int[][] getMatrix(int m,int n){
		int[][] arr = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = get.nextInt();
			}
		}
		return arr;
	}
	public static void display2DArray(int[][] arr,int m,int n) {
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
