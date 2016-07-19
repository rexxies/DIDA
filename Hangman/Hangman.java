import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File("groene_boekje.txt");
		Scanner scanner = new Scanner(System.in);
		BufferedReader is = new BufferedReader(new FileReader(file));
		
		int random;
		boolean win=false;
		String line, usersGuess, tmp;
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
		answer = tmp.split("");
		System.out.println(tmp);
		System.out.println(answer[0]);
		
		System.out.println("Geef een letter op.");
		usersGuess = scanner.next();
		while(!win){
			for(int i = 0; i<answer.length; i++){
				if(usersGuess.equals(answer[i])){
					wordToGuess[i]=usersGuess;
				}//end if
			}//end for
			System.out.println(wordToGuess[0] +wordToGuess[1]+ wordToGuess[2]+wordToGuess[3]+wordToGuess[4]+wordToGuess[5]);
			
			if(answer[0].equals(wordToGuess[0]) && answer[1].equals(wordToGuess[1]) && answer[2].equals(wordToGuess[2]) && 
					answer[3].equals(wordToGuess[3]) && answer[4].equals(wordToGuess[4]) && answer[5].equals(wordToGuess[5])){
				win = true;
				System.out.println("You win!!!!!");
			}
			
			System.out.println("Geef een letter op.");
			usersGuess = scanner.next();
			
			
		}//end while
	}//end main
}//end class

