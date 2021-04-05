package LongWeekend;
//get arraylength
//get array elements
//get user input
//sort array
//if input is greater than last element in sorted array no result
//else start from index zero compare with array elements when input > arr[index]
//print arr[index] and break the loop

import java.util.Scanner;
public class SecondMax {
	static Scanner get = new Scanner(System.in);
	public static void main(String args[]) {
		
		System.out.print("Enter the array length");
		int arrayLength = get.nextInt();
		System.out.print("Enter the array elements");
		int[] arr = get1DArray(arrayLength);
		System.out.println("user input :");
		int inputNum = get.nextInt();
		arr = bubbleSort(arr);
		
		displayResult(arr,inputNum);
		
	}
	public static int[] get1DArray(int l) {
		int[] arr = new int[l];
		for(int i=0;i<l;i++) {
			arr[i] = get.nextInt();
		}
		return arr;
	}
	public static int[] bubbleSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j+1]<arr[j]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	public static void displayResult(int[] arr,int x) {
		int i = 0;
		if(x<arr[arr.length-1]) {
			for( i = 0;i<arr.length;i++) {
				if(arr[i]>x) {
					System.out.println("Output:"+arr[i]);
					break;
				}
			}
		}
		else {
			System.out.println("All elements are less than input");
		}
		
	}
}

