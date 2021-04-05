package march23prac;

import java.util.Scanner;

public class SortColumns {
	public static void main(String args[]) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter array length : ");
		int length = get.nextInt();
		int[][] arr = new int[length][length];
		System.out.println("Enter array elements : ");
		arr = get2DArray(length);
		System.out.println("Input matrix : ");
		display2DArray(arr);
		arr = sortColumns(arr);
		System.out.println("Colum sorted array :");
		display2DArray(arr);
	}
	
	public static int[][] sortColumns(int[][] arr){
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				for(int k=j;k<arr.length;k++) {
					if(arr[j][i] > arr[k][i]) {
						int temp = arr[j][i];
						arr[j][i] = arr[k][i];
						arr[k][i] = temp;
					}
				}
			}
		}
		return arr;
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
