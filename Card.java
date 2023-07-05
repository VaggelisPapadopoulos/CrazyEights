//Name: Evangelos Papadopoulos AM: 5161

class Card
{
	private String suit;
	private int number;
	
	public Card(String s, int n){
		suit = s;
		number = n;
		
	}
	
	public String getSuit(){
		return suit;
	}
	
	public void setSuit(String p){
		suit = p;
	}
	
	public String toString(){
		return number+suit;
	}
	
	public boolean isEight(){
		if(number == 8)
		{
			return true;
		}
		return false;
	}
	
	public boolean matches(Card other){
		if(this.number == other.number || this.suit.equals(other.suit))
		{
			return true;
		}else{
			return false;
		}
	}
}