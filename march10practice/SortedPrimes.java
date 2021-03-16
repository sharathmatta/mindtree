package march10practice;
import java.util.Scanner;
public class SortedPrimes {
	public static void main(String[] args ) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter the length of assay");
		int arrayLength = get.nextInt();
		int[] arr = new int[arrayLength];
		System.out.println("Enter array elements");
		for(int i=0;i<arrayLength;i++) {
			arr[i] = get.nextInt();
		}
		int arr2[] = arr;
		arr = bubbleSort(arr);
		System.out.print("Sorted array :\n");
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		int[] primeArr = new int[arrayLength];
		int primeCount = 0;
		for(int i = 0;i<arrayLength;i++) {
			if(isPrime(arr[i])) {
				primeArr[primeCount] = arr[i];
				primeCount++;
			}
		}
		System.out.println("\nArray of sorted primes :");
		for(int i = 0;i<primeCount;i++) {
			System.out.print(primeArr[i]+" ");
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
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
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
