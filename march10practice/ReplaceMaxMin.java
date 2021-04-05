package march10practice;
import java.util.Scanner;
public class ReplaceMaxMin {
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		//getting unique elements
		arr = getUniqueArray();
		System.out.println("\nOriginal array");
		display2DArray(arr);
		arr = replaceMaxMin(arr);
		//display array after replacing
		System.out.println("\nAfter replacing max and min");
		display2DArray(arr);
		
	}
	public static void display2DArray(int[][] arr) {
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] getUniqueArray() {
		//create a 2d and 1d arrays
		//1d array for uniqueness check
		int[][] arr = new int[3][3];
		int[] uniqueCheck = new int[9];
		int uniqueCount = 0;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				boolean isNotUnique = false;
				int element;
				do {
					//consider the input as unique initially
					isNotUnique = false;
					System.out.println("Enter an Unique element");
					element= get.nextInt();
					//check if input is in unique array
					for(int k = 0;k<uniqueCount;k++) {
						
						if(element == uniqueCheck[k]) {
							//if input in unique array display error
							System.out.println("Element already exists  ");
							isNotUnique = true;
						}
					}
					//while the input is not unique run the loop
				}while(isNotUnique);
				//if the element is unique add it to 2d array
				arr[i][j] = element;
				uniqueCheck[uniqueCount] = element;
				uniqueCount++;
				
				
			}
		}
		//return 2d array
		return arr;
	}
	
	public static int[][] replaceMaxMin(int[][] arr){
		int rowIndexOfMax = 0;
		int columnIndexOfMax = 0;
		int rowIndexOfMin = 0;
		int columnIndexOfMin = 0;
		//consider element arr[0][0] as max and min
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				//get indexes of max
				if(arr[rowIndexOfMax][columnIndexOfMax] < arr[i][j]) {
					
					rowIndexOfMax = i;
					columnIndexOfMax = j;
				}
				//get indexes of min
				if(arr[rowIndexOfMin][columnIndexOfMin] > arr[i][j]) {
					
					rowIndexOfMin = i;
					columnIndexOfMin = j;
				}
			}
		}
		//swap max and min and return array
		int temp = arr[rowIndexOfMax][columnIndexOfMax];
		arr[rowIndexOfMax][columnIndexOfMax] = arr[rowIndexOfMin][columnIndexOfMin];
		arr[rowIndexOfMin][columnIndexOfMin] = temp;
		return arr;
	}
	
}
