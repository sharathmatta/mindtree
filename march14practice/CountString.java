package march14practice;
import java.util.Scanner;
public class CountString {
	public static void main(String[] args) {
		Scanner get  = new Scanner(System.in);
		System.out.println("Input :");
		String str = toLowerCase(get.nextLine());
		System.out.println("Substring :");
		String subString = toLowerCase(get.next());
		int index = 0;
		int count = 0;
		while(index<str.length()-subString.length()+1) {
			
			if(str.charAt(index) == subString.charAt(0)) {
				if(isSubString(str,subString,index)) {
					count++;
				}
				
			}
			index++;
		}
		System.out.println(count);
	}
	public static String toLowerCase(String str) {
		String result = "";
		for(int i=0;i<str.length();i++) {
			int ascii = str.charAt(i);
			if(ascii<97) {
				ascii = ascii + 32;
			}
			if(ascii == 64) {
				result = result + ' ';
			}else {
				result = result + (char) ascii;
			}
		}
		return result;
	}
	public static boolean isSubString(String str,String subString,int index) {
		int j = 0;
		for(int i = index;i<index + subString.length();i++) {
			if(str.charAt(i) != subString.charAt(j)) {
				return false;
			}
			j++;
		}
		return true;
		
	}
}
