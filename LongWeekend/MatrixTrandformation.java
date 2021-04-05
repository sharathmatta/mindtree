package LongWeekend;
import java.util.Scanner;
public class MatrixTrandformation {
	static Scanner get = new Scanner(System.in);
	public static void main(String args[]) {
		
		System.out.println("Enter no. of rows :");
		int rows = get.nextInt();
		System.out.println("Enter no. of columns :");
		int columns = get.nextInt();
		int[][] arr = new int[rows][columns];
		System.out.println("Enter the matrix elements");
		arr = get2DArray(rows,columns);
		System.out.println("Input Matrix :");
		displayMatrix(arr,rows,columns);
		arr = transformMatrix(arr,rows,columns);
		System.out.println("Matrix after transformation :");
		displayMatrix(arr,rows,columns);
		int[] a = new int[rows*columns];
		a = convertTo1DArray(arr,rows,columns);
		
		
		a = sortArray(a);
		System.out.println("\n1d array after sorting");
		for(int i=0;i<rows*columns;i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println("\nEnter the element to search");
		int x = get.nextInt();
		int result = binarySearch(a,0,a.length-1,x);
		if(result == -1) {
			System.out.println("Element is not present");
		}
		else {
			System.out.println("Element is at :"+result);
		}
	}
	public static int[] sortArray(int[] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length-i-1;j++) {
				if(a[j+1] <a[j]) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	public static int binarySearch(int[] a,int l,int r,int x) {
		if(r>=l) {
			int mid = (l+r)/2;
			//System.out.println(mid);
			if(a[mid] == x) {
				return mid;
			}
			else if(a[mid]>x) {
				return binarySearch(a,l,mid-1,x);
			}
			return binarySearch(a,mid+1,r,x);
		}
		return -1;
	}
	
	public static int[] convertTo1DArray(int[][] arr, int m,int n) {
		int[] a = new int[m*n];
		int index = 0;
		for(int i=0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				a[index] = arr[i][j];
				index++;
			}
		}
		return a;
	}
	
	public static int[][] transformMatrix(int[][] arr,int m,int n){
		for(int j=0;j<m;j++) {
			int temp = arr[0][j];
			arr[0][j] = arr[j][j];
			arr[j][j] = temp;
		}
		return arr;
	}
	public static int[][] get2DArray(int m,int n){
		int[][] arr = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = get.nextInt();
			}
		}
		return arr;
	}
	public static void displayMatrix(int[][] arr,int m,int n) {
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
