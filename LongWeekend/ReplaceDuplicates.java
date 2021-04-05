package LongWeekend;
//get input string
//get word count 
//get words
//check for duplictes and replace them for each word
//sord the words
import java.util.Scanner;
public class ReplaceDuplicates {

	public static void main(String args[]) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter the input string :");
		String strInput = get.nextLine();
		int wordCount = getWordCount(strInput);
		String[] words = getWords(strInput,wordCount);
		
		for(int i = 0;i<wordCount;i++) {
			words[i] = replaceDuplicates(words[i]);
			
		}
		System.out.println("After Replace :");
		for(int i = 0;i<wordCount;i++) {
			System.out.print(words[i]+" ");
			
		}

		words = insertionSort(words);
		System.out.println("\nAfter sorting :");
		for(int i = 0;i<wordCount;i++) {
			System.out.print(words[i]+" ");
			
		}
	}
	public static String[] insertionSort(String[] strArr) {
		for(int i = 0;i<strArr.length;i++) {
			String key = strArr[i];
			int j = i-1;
			while(j>=0 && strArr[j].compareTo(key)>0) {
				strArr[j+1] = strArr[j];
				j--;
			}
			strArr[j+1] = key;
		}
		return strArr;
	}
	public static String replaceDuplicates(String str) {
		String result = "";
		char[] nonUnique = new char[str.length()];
		int index = 0;
		for(int i = 0;i<str.length();i++) {
			boolean isUnique = true;
			for(int j=i+1;j<str.length();j++) {
				if(str.charAt(i) == str.charAt(j)) {
					isUnique = false;
				}
			}
			if(!isUnique) {
				nonUnique[index] = str.charAt(i);
				index++;
			}
			
		}
		for(int i=0;i<str.length();i++) {
			boolean replace = false;
			for(int j = 0;j<nonUnique.length;j++) {
				if(nonUnique[j] == str.charAt(i)) {
					replace = true;
					break;
				}
				
			}
			if(replace) {
				int asciiOfReplaced = str.charAt(i) + 1;//a 97 
				if(asciiOfReplaced == 123) {
					asciiOfReplaced = 97;
				}
				result = result+  (char) asciiOfReplaced;
			}
			else {
				result = result + str.charAt(i);
			}
		}
		return result;
	}
	
	public static String[] getWords(String str,int l) {
		int j = 0;
		String[] words = new String[l];
		for(int i=0;i<str.length();i++) {
			String word = "";
			while(str.charAt(i)== ' ' && i!=str.length()) {
				i++;
			}
			while(str.charAt(i)!= ' ' && i!=str.length()) {
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

