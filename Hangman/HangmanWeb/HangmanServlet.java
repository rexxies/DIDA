package nl.didacticum.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class Hangman
 */
@WebServlet("/HangmanServlet")
public class HangmanServlet extends HttpServlet {
	
	
	public HangmanServlet() {
        super();
        //empty constructor
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		String[] answer = (String[])session.getAttribute("answer");
		String hangman = "  __\n |  |\n |  o\n | \\|/ \n | / \\ \n_|_";	
		

		// if session is not set pick a new word
		if(answer == null){
			String line;
			String[] wordToGuess={". ",". ",". ",". ",". ",". "}, groeneBoekje = null; 
			ArrayList<String> sixLetterWords = new ArrayList();
			boolean win=false, guessWasRight = false, lose = false;;
			int timesGuessedWrong=0;
			
			HashMap<String, Integer> alreadyChosenLetters = new HashMap<>();
			
			URL boekjeUrl = new URL("http://unconnected.nl/tmp/groene_boekje.txt"); 
			BufferedReader in = new BufferedReader(new InputStreamReader(boekjeUrl.openStream()));
		
			while ((line = in.readLine()) != null ) {
				groeneBoekje = line.split(" ");
				for(int i = 0; i<groeneBoekje.length; i++){
					if(groeneBoekje[i].length() == 6){
						sixLetterWords.add(groeneBoekje[i]);
					}//end if
				}//end for
			}//end while	
			
			int random = new Random().nextInt(sixLetterWords.size());
			String tmp = sixLetterWords.get(random);
			answer = tmp.toLowerCase().split("");	//this is the complete word that has to be guessed
			
			System.out.println( answer[0] + answer[1] + answer[2] + answer[3] + answer[4] + answer[5]);
			//set answer in session scope 
			session.setAttribute("answer", answer); 
			session.setAttribute("wordToGuess", wordToGuess);
			session.setAttribute("guessWasRight", guessWasRight);
			session.setAttribute("timesGuessedWrong", timesGuessedWrong);
			session.setAttribute("hangman", hangman);
			session.setAttribute("alreadyChosenLetters", alreadyChosenLetters);
			session.setAttribute("win", win);
			session.setAttribute("lose", lose);
		}
		
		//else use the word that is saved in session. (remember to use cast!!! session saves a object
		String[] wordToGuess = (String[])session.getAttribute("wordToGuess");
		boolean guessWasRight = (boolean)session.getAttribute("guessWasRight"); 
		boolean win = (boolean)session.getAttribute("win");
		boolean lose = (boolean)session.getAttribute("lose");
		int timesGuessedWrong = (Integer)session.getAttribute("timesGuessedWrong");
		HashMap alreadyChosenLetters =(HashMap)session.getAttribute("alreadyChosenLetters"); 
		
		if(timesGuessedWrong ==10){
			lose=true;
		}
		
		if(win==true|| lose == true){
			session.invalidate();
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		// user gives a word/letter to be matched
		String userGuess = request.getParameter("userGuess");

		//check if guess is correct
		for(int i = 0; i<answer.length; i++){
			if(userGuess.equals(answer[i])){
				wordToGuess[i]=userGuess;
				alreadyChosenLetters.put(userGuess, 1);
				guessWasRight = true;
			}//end if
		}//end for
		
		 if(guessWasRight==false){
				alreadyChosenLetters.put(userGuess, 1);
				timesGuessedWrong++;				
			}//end if
		
		System.out.println("user entered: "+ userGuess + " " + answer[0] + answer[1] + answer[2] + answer[3] + answer[4] + answer[5]);
		System.out.println(wordToGuess[0]+ wordToGuess[1]+ wordToGuess[2]+ wordToGuess[3]+ wordToGuess[4]+ wordToGuess[5]);
		
		 if(answer[0].equals(wordToGuess[0]) && answer[1].equals(wordToGuess[1]) && answer[2].equals(wordToGuess[2]) && 
					answer[3].equals(wordToGuess[3]) && answer[4].equals(wordToGuess[4]) && answer[5].equals(wordToGuess[5])){
				win = true;
			}

		guessWasRight = false;
		session.setAttribute("guessWasRight", guessWasRight);
		session.setAttribute("alreadyChosenLetters", alreadyChosenLetters);
		session.setAttribute("timesGuessedWrong", timesGuessedWrong);
		session.setAttribute("win", win);
		session.setAttribute("lose", lose);
		
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
