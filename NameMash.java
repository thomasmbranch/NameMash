//Thomas Branch
//August 2022
//Objective: take two names and suggest merger names

import java.io.*;
import java.util.*;

public class NameMash {

	//Settings
	//int sharedBonus = 2;      //bonus granted to a suggested name for using a shared letter
	//int unsharedPenalty = -1; //penalty assigned to a suggested name for using a letter only belonging to one name
	
	//Is String A a subset of String B?
	static boolean isSubset (String A, String B){
		A = A.toLowerCase();
		B = B.toLowerCase();
		boolean check = true;
		for (int i=0; i<A.length(); i++ ){
			char ltr = A.charAt(i);
			String letter = "" + ltr;
			//if B doesn't contain the letter, return false
			//if B does contain the letter, remove the letter from B to avoid double-using the same letter
			if (B.contains(letter)){
				B = B.replaceFirst(letter,"");
			} else {check = false;}
		}
		return check;
	}

	public static void main(String[] args) {
		int sharedBonus = 2;
		int unsharedPenalty = -1;

		//provide context
		System.out.println("This program will provide a ranking of combination names, based on the two input names below.");

		//prompt user to input both names
		Scanner textPrompt = new Scanner(System.in);

		System.out.print("Surname 1: ");
		String name1 = textPrompt.nextLine();

		System.out.print("Surname 2: ");
		String name2 = textPrompt.nextLine();
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

		String unshared = name1Remainder.concat(name2Remainder);

		//create dictionary of valid options
		ArrayList<String> suggestions = new ArrayList<>();
		int score;
		int maxScore = 0;

		try {
			File myObj = new File("English.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				//check if 'data' has any letters that 'comboName' doesn't have
				if (isSubset(data,comboName)){
					score = 0;
					//increase score by 'sharedBonus' for each shared letter
					//decrease score by 'unsharedPenalty' for each non-overlapping letter
					for (int i=0; i<data.length(); i++){
						char ltr = data.charAt(i);
						String letter = ""+ltr;
						if (overlap.contains(letter)){
							score += sharedBonus;
						} else {score += unsharedPenalty;}
					}
					if (score > maxScore) {
						maxScore = score;
						suggestions.clear();
						suggestions.add(data);
					} else if (score == maxScore) {
						//add suggested name to the list
						suggestions.add(data);
					} //otherwise, no change is made to maxScore or suggestions
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		//display best results
		//future improvement: display all possible results if less than N, or top N results by score
		System.out.println(suggestions);

	}
}
