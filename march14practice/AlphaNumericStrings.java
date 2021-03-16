package march14practice;
import java.util.Scanner;
public class AlphaNumericStrings {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.println("Input :");
		System.out.println("String 1 :");
		String str1 = get.next();
		System.out.println("String 2 :");
		String str2 = get.next();
		String alphaString="" ,numString = "";
		for(int i = 0;i<str1.length();i++) {
			if(str1.charAt(i)>=48 && str1.charAt(i)<=57) {
				if(isUnique(str1.charAt(i),numString)) {
					numString = numString + str1.charAt(i);
				}
			}
			else {
				if(isUnique(str1.charAt(i),alphaString)) {
					alphaString = alphaString + str1.charAt(i);
				}
			}
		}
		for(int i = 0;i<str2.length();i++) {
			if(str2.charAt(i)>=48 && str2.charAt(i)<=57) {
				if(isUnique(str2.charAt(i),numString)) {
					numString = numString + str2.charAt(i);
				}
			}
			else {
				if(isUnique(str2.charAt(i),alphaString)) {
					alphaString = alphaString + str2.charAt(i);
				}
			}
		}
		System.out.println("String 1 : "+ numString + " String 2 : "+alphaString);
	}
	public static boolean isUnique(char c, String str) {
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)== c) {
				return false;
			}
		}
		return true;
	}
}
