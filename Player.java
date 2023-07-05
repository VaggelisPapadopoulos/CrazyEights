//Name: Evangelos Papadopoulos AM: 5161

import java.util.Scanner;

class Player
{
	private String name;
	private Hand playersHand;
	
	public Player(String n){
		name = n;
		this.playersHand = new Hand();
	}
	
	public void draw(Table myTable){
		Card myCard = myTable.drawCard();
		playersHand.addCard(myCard);
	}
	
	public void draw(Table myTable,int c){
		for(int i = 0; i < c; i++){
			Card myCard = myTable.drawCard();
			playersHand.addCard(myCard);
		}
	}
	
	public void throwCard(Table myTable, Card myCard){
		myTable.throwCard(myCard);
		playersHand.removeCard(myCard);
	}
	
	public boolean isDone(){
		if(playersHand.isEmpty()){
			return true;
		}return false;
	}
	
	public String toString(){
		return name;
	}
	
	public Card selectCard(Table myTable){
		Scanner input = new Scanner(System.in);
		playersHand.printHand();
		Card myCard;
		while(true){
			System.out.println();
			System.out.print("Select a card to throw or -1 to pass: ");			
			int position = input.nextInt();
			if(position >= 0){
				myCard = playersHand.getCard(position);
				if(myCard.isEight()){
					System.out.println();
					System.out.print("Choose a suit between D, H, C, S: ");
					String s = input.next();
					myCard.setSuit(s);
					return myCard;
				}else if(myCard.matches(myTable.getTopCard())){
					return myCard;
				}
			}else{
				return null;
			}
		}
	}
	
	public Card computerSelectCard(Table myTable){
		playersHand.printHand();                    //this command prints the hand of the computer-player.If you do not want to display it put it in comment
		Card top = myTable.getTopCard();
		Card myCard = playersHand.findMatchingCard(top);
		return myCard;
	}
	
	public static void main(String args[]){
		Player Steve = new Player("Steve");
		Table myTable = new Table();
		Steve.draw(myTable,5);
		System.out.println("Top Card: " + myTable.getTopCard());
		Steve.selectCard(myTable);
		System.out.println();
		System.out.println(Steve.computerSelectCard(myTable));
	}
}







