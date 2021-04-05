package LongWeekend;
//get input string
//run nested for loops on the string --> i=0 to str.length , j= str.length to i
//if char at i == char at j return substring between i and j
//
import java.util.Scanner;
public class LongestSubString {
	public static void main(String args[]) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = get.next();
		String result = getLongestSubstring(str);
		if(result.length()!=0) {
			System.out.println(result);
		}
		else {
			System.out.println("No valid substrings");
		}
	}
	public static String getLongestSubstring(String str) {
		String result = "";
		for(int i = 0;i<str.length();i++) {
			for(int j = str.length()-1;j>i;j--) {
				if(str.charAt(i) == str.charAt(j)) {
					i++;
					while(i<j) {
						result = result + str.charAt(i);
						i++;
					}
					return result;
				}
			}
		}
		return result;
	}

}
