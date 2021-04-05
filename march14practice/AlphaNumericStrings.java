package march14practice;
import java.util.Scanner;
public class AlphaNumericStrings {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.println("Input :");
		//get 2 strings
		System.out.println("String 1 :");
		String str1 = get.next();
		System.out.println("String 2 :");
		String str2 = get.next();
		String[] results = new String[2];
		//get aplabhetical and numeric strings
		results = getAlphaAndNum(str1,str2);
		System.out.println("String 1 : "+ results[0] + " String 2 : "+results[1]);
	}
	public static String[] getAlphaAndNum(String str1,String str2) {
		String alphaString="" ,numString = "";
		//for first string
		for(int i = 0;i<str1.length();i++) {
			if(str1.charAt(i)>=48 && str1.charAt(i)<=57) {
				if(isUnique(str1.charAt(i),numString)) {
					//if unique and number add to num string
					numString = numString + str1.charAt(i);
				}
			}
			else {
				if(isUnique(str1.charAt(i),alphaString)) {
					//if unique and alphabet add to alpha string
					alphaString = alphaString + str1.charAt(i);
				}
			}
		}
		//second
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
		String[] result = new String[] {alphaString,numString};
		return result;
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
