//Thomas Branch
//August 2022
//Objective: take two names and suggest merger names

import java.io.*;
import java.util.*;

public class NameMash {

	//import dictionary of acceptable suggestion names (common surnames and English words)
	/*
	public Suggestion(String newName){
		//class that contains the value of each suggested combined name and the score, based on the two input names
		public String name = newName;
		public int score = 0;

		//increase score for each shared letter
		
		//decrease score for the difference in non-shared letters
	}
*/
	public static void main(String[] args) {
		//provide context
		System.out.println("This program will provide a ranking of combination names, based on the two input names below.");

		//prompt user to input both names
		Scanner myObj = new Scanner(System.in);

		System.out.print("Surname 1: ");
		String name1 = myObj.nextLine();

		System.out.print("Surname 2: ");
		String name2 = myObj.nextLine();
		//I know repeating code (except for numerical increment) isn't best practice. Oh well.

		System.out.println(name1+" and "+name2+", please wait while recommendations are generated.");
	
		//create a combined name & overlap name
		name1 = name1.toLowerCase();
		name2 = name2.toLowerCase();
		String comboName = name1.concat(name2);
		String overlap = "";
		String name1Remainder = "";
		String name2Remainder = name2;
		for (int i = 0; i < name1.length(); i++) {
			char ltr = name1.charAt(i);
			String letter = "" + ltr;
		       //check if the letter it appears in (what remains of) name2
		       if (name2Remainder.contains(letter)){
			       //add it to overlap
			       overlap = overlap.concat(letter);
			       //remove it from name2
			       name2Remainder = name2Remainder.replaceFirst(letter,"");
			} else {
				name1Remainder = name1Remainder.concat(letter);
			}
		}

		//testing the above logic
		/*
		System.out.println("Name 1:      "+name1);
		System.out.println("Name 2:      "+name2);
		System.out.println("Overlap:     "+overlap);
		System.out.println("Remainder 1: "+name1Remainder);
		System.out.println("Remainder 2: "+name2Remainder);
		*/

		//remove all words from dictionary that cannot be created by the two names combined

		//create a Suggestion object for all remaining names in the dictionary
		
		//display results, ranked: all possible results if less than N, or top N results by score

	}
}
