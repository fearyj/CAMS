package project2002;
import java.util.ArrayList;
import java.util.Scanner;

public class SuggestionControl {
	private ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
	
	public SuggestionControl(ArrayList<Suggestion> suggestion) {
		this.suggestionList = suggestion;
	}
	
	public void addSuggestion() {
		// make a new suggestion
		// get all of its attributes
		// put in the message
		// add to array
		Scanner sc = new Scanner(System.in);
		Suggestion s2 = new Suggestion();
		// how do i get its student and camp attributes?
		s2.setStatus(Status Processing);
		System.out.println("Enter the suggestion you would like to make :");
		s2.setMessage(sc.next()); // suggestion has been set
		
		
		this.suggestionList.add(s2); // add into the global array of suggestions
		
		
	}
	public void editSuggestion(int index) {
		//get all the existing suggestions
		//get all suggestions filtering using student
		//ask which one they want to edit
		//edit by doing "Enter your edited suggestion"
		for (int i=0; i<this.suggestionList.size(); i++ ) {
			if (user.getUserID() == suggestionList.get(i).getStudent()) {
				suggestionList.get(i).printSuggestion();
			}
		}
		
	}
	public void deleteSuggestion(int index) {
		//get all suggestions
		// ask which one they want to delete
		
		
	}
	public Suggestion getSuggestion(int index) {
		//using the index we iterate through and return that suggestion
		
	}
	public ArrayList<Suggestion> getSuggestion(Camp camp){
		// filter global array by camp
		return this.suggestions;
	}
	public ArrayList<Suggestion> getSuggestions(Student student){
		//filter global array by student
		return this.suggestions;
	}
}
