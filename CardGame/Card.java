/*
 * Cards bestaan uit 5 soorten. 
 * De 4 algemene : harten, ruiten, schoppen en klaver. De 5e zijn Jokers.
 * elk dek kaarten in pesten heeft 2 jokers.
 * joker kaarten hebben naam: Joker, rank: 15, suit: Joker
 */


public class Card {
	//fields
	private String name, suit;	// naam: two, seven, jack, king, ace.	// suit: schoppen, ruiten, harten, klaver 
	private int rank; 	//waarde 1,2,3, 11,12,13.
	
	
	// constructors
	public Card(String name, String suit, int rank) {
		this.name = name;
		this.suit = suit;
		this.rank = rank;
	}
	public Card(){
		//default constructor
	}
	public Card(String suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	//get & set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void nameSwitch(int rank){
		
		switch (rank){
		case 1:
			this.name= "ace";
			break;
		case 2:
			this.name= "Two";
			break;
		case 3:
			this.name = "Three";
			break;
		case 4:
			this.name = "Four";
			break;
		case 5:
			this.name = "Five";
			break;
		case 6:
			this.name = "Six";
			break;
		case 7:
			this.name = "Seven";
			break;
		case 8:
			this.name = "Eight";
			break;
		case 9:
			this.name = "Nine";
			break;
		case 10:
			this.name = "Ten";
			break;
		case 11:
			this.name = "Jack";
			break;
		case 12:
			this.name = "Queen";
			break;
		case 13:
			this.name = "King";
			break;
		default:
			break;
		}
		
		
	}

}
