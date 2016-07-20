import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File("groene_boekje.txt");
		Scanner scanner = new Scanner(System.in);
		BufferedReader is = new BufferedReader(new FileReader(file));
		HashMap<String, Integer> alreadyChosenLetters = new HashMap<>();
		
		int random, timesGuessedWrong=0;
		boolean win=false, guessWasRight = false, loose = false;
		String line, usersGuess, tmp, chosenLetters;
		String[] groeneBoekje =null, answer, wordToGuess= {". ",". ",". ",". ",". ",". "} ;
		ArrayList<String> sixLetterWord = new ArrayList<>();

		while ((line = is.readLine()) != null ) {
			 
			groeneBoekje = line.split(" ");

			for(int i = 0; i<groeneBoekje.length; i++){
		    	if(groeneBoekje[i].length() == 6){
		    		sixLetterWord.add(groeneBoekje[i]);
		    	}//end if
		    }//end for
		}//end while
		
		//te raden woord kiezen uit lijst met 6 letter woorden. en daarna in een array gestopt. zodat elke char afzonderlijk bekeken kan worden.
		random = new Random().nextInt(sixLetterWord.size());
		tmp = sixLetterWord.get(random);
		answer = tmp.toLowerCase().split("");		// Let op moet eerst naar lowercase gemaakt worden anders krijg je een probleem met raden.
		
		System.out.println("\n" + wordToGuess[0] +wordToGuess[1]+ wordToGuess[2]+wordToGuess[3]+wordToGuess[4]+wordToGuess[5] + "\n");
		System.out.println("Geef een letter op.");
		usersGuess = scanner.next();
		
		while(!(win) || !loose){

			//Deze code is goed. werkt helemaal en is getest
			  
			  for(int i = 0; i<answer.length; i++){
				if(usersGuess.equals(answer[i])){
					wordToGuess[i]=usersGuess;
					guessWasRight = true;
				}//end if
			}//end for
			
			if(guessWasRight==false){
				alreadyChosenLetters.put(usersGuess, 1);
				timesGuessedWrong++;
			}//end if
			//zet deze letters om in een string zoals wordtoguess
			if(answer[0].equals(wordToGuess[0]) && answer[1].equals(wordToGuess[1]) && answer[2].equals(wordToGuess[2]) && 
					answer[3].equals(wordToGuess[3]) && answer[4].equals(wordToGuess[4]) && answer[5].equals(wordToGuess[5])){
				win = true;
				System.out.println("You win!!!!!");
				System.out.println("het woord was: "+ tmp);
				break;
			}
			for(String key : alreadyChosenLetters.keySet()){
				System.out.println("Gekozen letters: " + key );
			}
			
			System.out.println(wordToGuess[0] +wordToGuess[1]+ wordToGuess[2]+wordToGuess[3]+wordToGuess[4]+wordToGuess[5] + "\n");
			
			if(timesGuessedWrong == 1){
				System.out.println("_|_");
			}
			else if(timesGuessedWrong == 2){
				System.out.println(" | ");
				System.out.println("_|_");
			}
			else if(timesGuessedWrong == 3){
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println("_|_");
			}
			else if(timesGuessedWrong == 4){
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println("_|_");
			}
			else if(timesGuessedWrong == 5){
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println("_|_");
			}
			else if(timesGuessedWrong == 6){
				System.out.println("  __");
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println("_|_");
			}
			else if(timesGuessedWrong == 7){
				System.out.println("  __");
				System.out.println(" |  |");
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println("_|_");
			}
			else if(timesGuessedWrong == 8){
				System.out.println("  __");
				System.out.println(" |  |");
				System.out.println(" |  o");
				System.out.println(" | ");
				System.out.println(" | ");
				System.out.println("_|_");
			}
			else if(timesGuessedWrong == 9){
				System.out.println("  __");
				System.out.println(" |  |");
				System.out.println(" |  o");
				System.out.println(" |  | ");
				System.out.println(" | ");
				System.out.println("_|_");
			}
			else if(timesGuessedWrong == 10){
				System.out.println("  __");
				System.out.println(" |  |");
				System.out.println(" |  o");
				System.out.println(" | \\|/ ");
				System.out.println(" | ");
				System.out.println("_|_");
			}
			else if(timesGuessedWrong == 11){
				System.out.println("  __\n |  |\n |  o\n | \\|/ \n | / \\ \n_|_");
				System.out.println("You Lose....\n");
				System.out.println("Het woord was: "+ tmp);
				break;
			}
			guessWasRight = false;
			System.out.println("\nGeef een letter op.");
			usersGuess = scanner.next();	
		}//end while
	}//end main
}//end class




