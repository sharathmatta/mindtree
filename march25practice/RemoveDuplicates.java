package march25practice;
import java.util.Scanner;

//get input string
//check no of word
//if more than 2 words display error
//split string into two word
//create a string and add common words to the string
//loop through 2nd word compare with chars in commonwords string if not there display string
//loop through 1st word compare with chars in commonwords string if not there display string
public class RemoveDuplicates {
	public static void main(String args[]) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = get.nextLine();
		int wordCount = getWordCount(str);
	
		if(wordCount == 2) {
			String[] words = new String[] {"",""};
			words=getWords(str,2);
			displayNotCommon(words[0],words[1]);
		}
		else {
			System.out.println("enter only two words");
		}
		
		
	}
		
	
	
	public static void displayNotCommon(String str1,String str2) {
		for(int k = 0;k<str1.length();k++) {
			boolean isCommon = false;
			for(int j=0;j<str2.length();j++) {
				if(str1.charAt(k) == str2.charAt(j)) {
					isCommon = true;
				}
				
			}
			if(!isCommon) {
				System.out.print(str1.charAt(k));
			}
		}
		System.out.print("\t");
		for(int k = 0;k<str2.length();k++) {
			boolean isCommon = false;
			for(int j=0;j<str1.length();j++) {
				if(str2.charAt(k) == str1.charAt(j)) {
					isCommon = true;
				}
				
			}
			if(!isCommon) {
				System.out.print(str2.charAt(k));
			}
		}
		
	}
	public static String[] getWords(String str,int l) {
		int j = 0;
		String[] words = new String[l];
		for(int i=0;i<str.length();i++) {
			String word = "";
			while(str.charAt(i)== ' ') {
				i++;
			}
			while(str.charAt(i)!= ' ') {
				word = word + str.charAt(i);
				i++;
				if(i>=str.length()) {
					break;
				}
			}
			words[j] = word;
			j++;
		}
		return words;
	}
	
	public static int getWordCount(String str) {
		int wordCount = 1;
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i)==' ') {
				i++;
				if(i>=str.length()) {
					break;
				}
				else {
					while(str.charAt(i) == ' ') {
						i++;
						if(i >= str.length()) {
							break;
						}
					}
				}
				if(i<str.length()) {
					wordCount++;
				}
			}
		}
		return wordCount;
	}
}
