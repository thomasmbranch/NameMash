//Thomas Branch
//August 2022
//Objective: take two names and suggest merger names

public class NameMash {

	//import dictionary of acceptable suggestion names (common surnames and English words)
	
	public Suggestion(String newName){
		//class that contains the value of each suggested combined name and the score, based on the two input names
		public String name = newName;
		public int score = 0;

		//increase score for each shared letter
		
		//decrease score for the difference in non-shared letters
	}

	public static void main(String[] args) {
		//provide context
		System.out.println("This program will provide a ranking of combination names, based on the two input names below.");
		
		//initialize both names
		String name1;
		String name2;

		//prompt user to input both names
		
		//create a combined name & overlap name
		String comboName = name1.concat(name2);
		String overlap;
		String name2Remainder = name2;
		for (int i = 0; i < name1.length(); i++) {
		       //check if the letter it appears in (what remains of) name2
		       
		       //add it to overlap
		       //remove it from name2
		}

		//remove all words from dictionary that cannot be created by the two names combined

		//create a Suggestion object for all remaining names in the dictionary
		
		//display results, ranked: all possible results if less than N, or top N results by score

	}
}
