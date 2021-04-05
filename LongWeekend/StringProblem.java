package LongWeekend;
import java.util.Scanner;
public class StringProblem {
	public static void main(String args[]) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter the String");
		String str = get.nextLine();
		int wordCount = getWordCount(str);
		String[] words = new String[wordCount];
		words = getWords(str,wordCount);
		String[] vowelCapitals = new String[wordCount-2];
		int index = 0;
		for(int i=1;i<words.length-1;i++) {
			vowelCapitals[index] = getVowelCapitals(words[i]);
			index++;
		}
		System.out.println("Output :");
		displayArray(vowelCapitals);
		
	}
	public static void displayArray(String[] arr) {
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	public static boolean isVowel(char c) {
		if(c == 'a'||c=='e'||c == 'i'||c=='o'||c=='u') {
			return true;
		}
		return false;
	}
	
	public static String getVowelCapitals(String str) {
		String result = "";
		for(int i=0;i<str.length();i++) {
			int asciiVal = (int)str.charAt(i);
			if(isVowel(str.charAt(i))) {
				asciiVal = asciiVal -32;
			}
			result = result + (char)asciiVal;
		}
		return result;
	}
	
	public static String[] getWords(String str,int m) {
		String[] words = new String[m];
		int index = 0;
		for(int i = 0;i<str.length();i++) {
			String word = "";
			
			while(str.charAt(i)!= ' ') {
				word = word+ str.charAt(i);
				i++;
				if(i == str.length()){
					break;
				}
			}
			words[index] = word;
			index++;
		}
		return words;
	}
	public static int getWordCount(String str) {
		int result = 1;
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i) == ' ') {
				result++;
			}
		}
		return result;
	}
}
