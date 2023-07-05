

import java.util.ArrayList;
import java.util.HashMap;

class Hand
{
	private ArrayList<Card> hand = new ArrayList<Card>();
	private HashMap<String,Integer> cardCounter = new HashMap<String,Integer>();

	public Hand(){
		cardCounter.put("D",0);
		cardCounter.put("H",0);
		cardCounter.put("C",0);
		cardCounter.put("S",0);
	}
	
	public void addCard(Card myCard){
		if(myCard.isEight()){
			hand.add(myCard);
		}else{
			hand.add(myCard);
			String temp = myCard.getSuit();
			cardCounter.put(temp,cardCounter.get(temp)+1);
		}
	}
	
	public void removeCard(Card myCard){
		hand.remove(myCard);
		String temp = myCard.getSuit();
		cardCounter.put(temp,cardCounter.get(temp)-1);
	}
	
	public Card getCard(int i){
		return hand.get(i);
	}
	
	public void printHand(){
		for(int i = 0; i < hand.size(); i++){
			System.out.printf("%2d ",i);
		}
		System.out.println();
		for(int i = 0; i < hand.size(); i++){
			System.out.print(getCard(i) + " ");
		}
	}
	
	public boolean isEmpty(){
		if(hand.size() == 0){
			return true;
		}
		return false;
	}
	
	public String largerSuit(){
		int d = cardCounter.get("D");
		int h = cardCounter.get("H");
		int c = cardCounter.get("C");
		int s = cardCounter.get("S");
		int max;
		
		if(d >= h){
			max = d;
		}else max = h;
		
		if(max >= c){
			max = max; 
		}else max = c;
		
		if(max >= s){
			max = max;
		}else max = s;
		
		if(max == d){
			return "D";
		}else if(max == h){
			return "H";
		}else if(max == c){
			return "C";
		}else return "S";
	}
	
	public void printMap(){
		System.out.println(cardCounter);
	}
	
	public Card findMatchingCard(Card myCard){
		Card tempCard = null;
		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).matches(myCard)){
				tempCard = hand.get(i);
				return tempCard;
			}
			
		}

		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).isEight()){
				tempCard = hand.get(i);
				String s = this.largerSuit();
				tempCard.setSuit(s);
			}
		}
		return tempCard;
	}
	
	
	
	
	public static void main (String args[]){
		Hand myHand = new Hand();
		Card myCard1 = new Card("D",5);
		Card myCard2 = new Card("D",6);
		Card myCard3 = new Card("S",4);
		Card myCard4 = new Card("C",9);
		Card myCard5 = new Card("C",8);
		myHand.addCard(myCard1);
		myHand.addCard(myCard2);
		myHand.addCard(myCard3);
		myHand.addCard(myCard4);
		myHand.addCard(myCard5);
		myHand.printHand();
		System.out.println();
		myHand.printMap();
		myHand.removeCard(myCard3);
		myHand.removeCard(myCard1);
		myHand.printHand();
		System.out.println();
		myHand.printMap();
		Card myCard6 = new Card("D",6);
		myHand.findMatchingCard(myCard6);
		Card myCard7 = new Card("H",1);
		myHand.findMatchingCard(myCard7);
	}
}