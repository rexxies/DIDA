import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String name;
		int amountOfPlayers, amountToDeal;
		Scanner scanner = new Scanner(System.in);
		
		//create & shuffle deck
		Deck deck = new Deck();
		
		// schudden van deck dat terugkomt van createdeck()
		deck.shuffleDeck(deck.createDeck());		//dit gaat nu goed (15 juli 14.07)
		
		
		//create players
		System.out.println("Give amount of players. 1-4");
		amountOfPlayers = scanner.nextInt();
		
		ArrayList<Player> players = new ArrayList<>();
		
		
		for(int i=0; i<amountOfPlayers; i++){
			name = "Player"+1;
			players.add(new Player(name));
		}											//Dit gaat ook nog goed. 15 juli 14.07
		
		//deal cards
		System.out.println("How many cards should be dealt?");
		amountToDeal = scanner.nextInt();			// dit gaat ook nog goed
		
		//System.out.println(deck.extraCardDeck);
		
		for(int i=0; i<amountToDeal; i++){
			for(int j=0; j<amountOfPlayers; j++){
				players.get(j).addToHand(deck.dealCard(deck)); // Dit werkt nu ook 16 juli
			}			
		}
		
		
		//Get the first card from a player's hand
		System.out.println(players.get(0).getHand().get(0).getSuit() + " " + players.get(0).getHand().get(0).getRank());
		
	
	}

}
