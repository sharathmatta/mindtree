package march10practice;
import java.util.Scanner;

public class ReplaceConsonant {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		//get input string
		System.out.println("Enter the sentence :");
		String str = get.nextLine();
		String result = consonantRelace(str);
		System.out.println("Output is:\n"+result);
		
		
	}
	public static boolean isVowel(char c) {
		if(c == 'a' || c=='e' || c == 'i' || c == 'o' || c== 'u') {
			return true;
		}
		return false;
	}
	public static String consonantRelace(String str) {
		int index = 0;
		String resultStr = "";
		while(index<str.length()) {
			//check if char at index is vowel
			if(isVowel(str.charAt(index))) {
				//add the vowel to result string
				resultStr = resultStr + str.charAt(index);
				int replaceIndex = index+1;
				if(replaceIndex<str.length() ) {
					//increment index while the next char is vowel
					while(replaceIndex<str.length() && (isVowel(str.charAt(replaceIndex)) || str.charAt(replaceIndex) == ' ')) {
						
						resultStr = resultStr + str.charAt(replaceIndex);						
						replaceIndex++;
					}
					//change the consonant with the help of ascii vals
					if(replaceIndex<str.length()) {
						int asciiOfReplaced = str.charAt(replaceIndex) + 1;//a 97 
						if(asciiOfReplaced == 123) {
							asciiOfReplaced = 97;
						}
						resultStr = resultStr + (char) asciiOfReplaced;
						
					}
					index = replaceIndex;
				}
				
				
			}
			//add char at index to result
			else {
				resultStr = resultStr + str.charAt(index);
			}
			index++;
		}
		return resultStr;
	}
}
