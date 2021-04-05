package march16practice;
import java.util.Scanner;
//get input string
//check no of words
//create array of length of no of words
//add words to array
//sort words based on length
//display staring elements of min length as samllest 
//display ending elements of max length as largest

public class Smallestword {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = get.nextLine();
		int wordCount ;
		//get word count
		wordCount = getWordCount(str) ;
		String[] words = new String[wordCount];
		
		words = getWords(str,wordCount);
		words = sortWords(words);
		int j=0;
		int small = words[j].length();
		System.out.println("smallest : ");
		while(small == words[j].length()) {
			System.out.println(words[j]);
			j++;
		}
		j=words.length-1;
		int large = words[j].length();
		System.out.println("largest : ");
		while(large == words[j].length()) {
			System.out.println(words[j]);
			j--;
		}
	}
	
	public static String[] sortWords(String[] words) {
		for(int i=0;i<words.length;i++) {
			for(int k=i;k<words.length;k++) {
				if(words[i].length() > words[k].length()) {
					String temp = words[i];
					words[i] = words[k];
					words[k] = temp;
				}
			}
		}
		return words;
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
