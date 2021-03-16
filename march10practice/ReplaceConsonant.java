package march10practice;
import java.util.Scanner;
public class ReplaceConsonant {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter the sentence :");
		String str = get.nextLine();
		int index = 0;
		String resultStr = "";
		while(index<str.length()) {
			if(isVowel(str.charAt(index))) {
				resultStr = resultStr + str.charAt(index);
				int replaceIndex = index+1;
				if(replaceIndex<str.length() ) {
					while(replaceIndex<str.length() && (isVowel(str.charAt(replaceIndex)) || str.charAt(replaceIndex) == ' ')) {
						
						resultStr = resultStr + str.charAt(replaceIndex);						
						replaceIndex++;
					}
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
			else {
				resultStr = resultStr + str.charAt(index);
			}
			index++;
		}
		System.out.println("Output is:\n"+resultStr);
		
		
	}
	public static boolean isVowel(char c) {
		if(c == 'a' || c=='e' || c == 'i' || c == 'o' || c== 'u') {
			return true;
		}
		return false;
	}
}
