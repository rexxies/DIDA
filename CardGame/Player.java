
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	private String name;
	private int numberOfCards = 0;
	private Card chosenCard;
	private ArrayList<Card> hand = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	
	//constructor
	public Player(String name){
		this.name = name;
	}

	
	
	//Get & set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}
	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	
	//eigen methodes
	public void addToHand(Card card ){
		this.hand.add(card);
	}
	public Card playCard(ArrayList<Card> hand, int cardToPlay){
		this.chosenCard = hand.get(cardToPlay);
		return this.chosenCard;
	}
	
	

}
