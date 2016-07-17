
import java.util.ArrayList;
import java.util.Random;


public class Deck {
	
	Card card, cardToDeal;
	ArrayList<Card> carddeck, extraCardDeck, deck;
	//Card[] carddeck, extraCardDeck;
	
	
	public Deck(ArrayList<Card> carddeck){
		this.carddeck = carddeck;
	}
	public Deck(){
		//default constructor
	}
	
	public ArrayList<Card> shuffleDeck(ArrayList<Card> carddeck){
		//hier wordt een random stapel gemaakt (een geschudde stapel)
		ArrayList<Card> extraCardDeck = new ArrayList<>();
		
		for(int i=0;i<carddeck.size();i++){
			int idx = new Random().nextInt(carddeck.size());
			extraCardDeck.add(carddeck.get(idx));
		}
		
		for(int i=0; i<extraCardDeck.size(); i++){
			System.out.println(extraCardDeck.get(i).getRank() + " of " + extraCardDeck.get(i).getSuit());
			//System.out.println(deck.extraCardDeck[i].getRank() + " of " + deck.extraCardDeck[i].getSuit());
		}
		this.extraCardDeck=extraCardDeck;
		return this.extraCardDeck;
	}
	
	public ArrayList<Card> createDeck(){
		
		int i,j=1;
		
		ArrayList<Card> carddeck = new ArrayList<>();
		
		this.carddeck = carddeck;
				
		for(i = 0 ; i<13 ; i++){
			if(j>13){
				j=1;
			}
			carddeck.add(new Card("hearts", j));
			j++;
		}
		for(i=13; i<26 ; i++){
			if(j>13){
				j=1;
			}
			carddeck.add(new Card("spades", j));
			j++;
		}
		for(i=26; i < 39 ; i++){
			if(j>13){
				j=1;
			}
			carddeck.add(new Card("diamonds", j));
			j++;
		}
		for(i=39; i<52  ; i++){
			if(j>13){
				j=1;
			}
			carddeck.add(new Card("clover", j));
			j++;
		}
		
		Deck deck = new Deck(carddeck);
		
			for(i=0; i<carddeck.size(); i++){
				System.out.println(deck.carddeck.get(i).getRank() + " of " + deck.carddeck.get(i).getSuit());
			}
			return carddeck;
	}
	
	
	
	public Card dealCard(Deck deck){
		cardToDeal = deck.extraCardDeck.get(0);
		extraCardDeck.remove(0);
		
		return cardToDeal;
	}
	

}
