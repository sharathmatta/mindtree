package march10practice;
import java.util.Scanner;
public class SortedPrimes {
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args ) {
		
		System.out.println("Enter the length of assay");
		int arrayLength = get.nextInt();
		int[] arr = new int[arrayLength];
		System.out.println("Enter array elements");
		arr = get1DArray(arrayLength);
		int arr2[] = arr;
		arr = bubbleSort(arr);
		System.out.print("Sorted array :\n");
		display1DArray(arr);
		int[] primeArr = new int[arrayLength];
		primeArr = getPrimesArray(arr);
		
		System.out.println("\nArray of sorted primes :");
		for(int i = 0;i<primeArr.length;i++) {
				if(primeArr[i]!=0) {
					System.out.print(primeArr[i]+" ");
				}
			
		}
	}
	public static int[] get1DArray(int l) {
		int[] arr = new int[l];
		for(int i=0;i<l;i++) {
			arr[i] = get.nextInt();
		}
		return arr;
	}
	public static int[] getPrimesArray(int[] arr) {
		int primeCount = 0;
		int[] result = new int[arr.length];
		for(int i = 0;i<arr.length;i++) {
			if(isPrime(arr[i])) {
				result[primeCount] = arr[i];
				primeCount++;
			}
		}
		return result;
	}
	public static void display1DArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static boolean isPrime(int x) {
		if(x == 1) {
			return false;
		}
		int count = 0;
		for(int i = 1;i<x;i++) {
			
			if(x%i == 0) {
				count++;
			}
		}
		if(count<2) {
			return true;
		}
		return false;
	}
	public static int[] bubbleSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[j+1]>arr[j]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	public static int[] sort(int[] arr) {
		
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
		return arr;
	}
}
