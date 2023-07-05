//Name: Evangelos Papadopoulos AM: 5161

import java.util.ArrayList;

class Table
{
	private Pile pass;
	private ArrayList<Card> playedCards = new ArrayList<Card>();
	private Card topCard;
	
	public Table(){
		pass = new Pile();
		pass.fill();
		Card temp = pass.nextCard();
		playedCards.add(temp);
	}
	
	public void throwCard(Card myCard){
		playedCards.add(myCard);
		topCard = myCard;
	}
	
	public Card drawCard(){
		if(pass.isEmpty()){
			pass.fill(playedCards);
			for(int i = playedCards.size()-1; i >= 0; i--){
				playedCards.remove(i);
			}
			playedCards.add(topCard);
			return pass.nextCard();
		}
		return pass.nextCard();
	}
	
	public Card getTopCard(){
		int temp = playedCards.size()-1;
		return playedCards.get(temp);
	}
	
	public static void main(String args []){
		Table myTable = new Table();
		for(int i = 0; i < 40; i++){
			Card temp = myTable.drawCard();
			if(i%2 == 1){
				myTable.throwCard(temp);
			}
		}
	}
}