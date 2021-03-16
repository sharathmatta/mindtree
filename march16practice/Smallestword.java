package march16practice;
import java.util.Scanner;
public class Smallestword {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = get.nextLine();
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
		String[] words = new String[wordCount];
		int j = 0;
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
		for(int i=0;i<wordCount;i++) {
			for(int k=i;k<wordCount;k++) {
				if(words[i].length() > words[k].length()) {
					String temp = words[i];
					words[i] = words[k];
					words[k] = temp;
				}
			}
		}
		j=0;
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
}
