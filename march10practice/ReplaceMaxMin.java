package march10practice;
import java.util.Scanner;
public class ReplaceMaxMin {
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		arr = getUniqueArray();
		System.out.println("\nOriginal array");
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		arr = replaceMaxMin(arr);
		System.out.println("\nAfter replacing max and min");
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] getUniqueArray() {
		int[][] arr = new int[3][3];
		int[] uniqueCheck = new int[9];
		int uniqueCount = 0;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				boolean isNotUnique = false;
				int element;
				do {
					isNotUnique = false;
					System.out.println("Enter an Unique element");
					element= get.nextInt();
					for(int k = 0;k<uniqueCount;k++) {
						
						if(element == uniqueCheck[k]) {
							
							System.out.println("Element already exists  ");
							isNotUnique = true;
						}
					}
				}while(isNotUnique);
				arr[i][j] = element;
				uniqueCheck[uniqueCount] = element;
				uniqueCount++;
				
				
			}
		}
		return arr;
	}
	
	public static int[][] replaceMaxMin(int[][] arr){
		int rowIndexOfMax = 0;
		int columnIndexOfMax = 0;
		int rowIndexOfMin = 0;
		int columnIndexOfMin = 0;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(arr[rowIndexOfMax][columnIndexOfMax] < arr[i][j]) {
					
					rowIndexOfMax = i;
					columnIndexOfMax = j;
				}
				if(arr[rowIndexOfMin][columnIndexOfMin] > arr[i][j]) {
					
					rowIndexOfMin = i;
					columnIndexOfMin = j;
				}
			}
		}
		int temp = arr[rowIndexOfMax][columnIndexOfMax];
		arr[rowIndexOfMax][columnIndexOfMax] = arr[rowIndexOfMin][columnIndexOfMin];
		arr[rowIndexOfMin][columnIndexOfMin] = temp;
		return arr;
	}
	
}
