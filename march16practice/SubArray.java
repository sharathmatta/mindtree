package march16practice;
import java.util.Scanner;
public class SubArray {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter array length(should be greater than 8)");
		int arrLength = get.nextInt();
		int[] arr = new int[arrLength];
		System.out.println("Enter array elements");
		int max = 0,min=0;
		for(int i=0;i<arrLength;i++) {
			arr[i] = get.nextInt();
			if(max < arr[i]) {
				max = arr[i];
			}
			else if(min > arr[i]) {
				min = arr[i];
			}
		}
		if(arr.length > 8) {
			int[] subArr = new int[6];
			int j=0;
			for(int i =3;i<=8;i++) {
				subArr[j] = arr[i];
				j++;
			}
			for(int i = 0;i<subArr.length;i++) {
				System.out.print(subArr[i]+" ");
			}
		}else {
			System.out.println("Array length is less than 8");
		}
		
	}

}
