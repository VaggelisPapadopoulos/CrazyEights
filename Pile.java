

import java.util.ArrayList;
import java.util.Random;


class Pile
{
	private ArrayList<Card> stack = new ArrayList<Card>();
	private Random rand = new Random(); 
	
	public void fill(){
		for(int i = 0; i < 10; i++){
			Card myCard1 = new Card("D",i);
			Card myCard2 = new Card("H",i);
			Card myCard3 = new Card("C",i);
			Card myCard4 = new Card("S",i);
			stack.add(myCard1);
			stack.add(myCard2);
			stack.add(myCard3);
			stack.add(myCard4);
		}
		shuffle();
	}
	
	public void fill(ArrayList<Card> myStack){
		for(int i = 0; i < myStack.size(); i++){
			stack.add(myStack.get(i));
		}
		shuffle();
	}
	
	private void shuffle(){
		for(int i = 1; i < stack.size(); i++){
			int randomNumber = rand.nextInt(i);
			stack.add(stack.get(randomNumber));
			stack.remove(randomNumber);
		}
	}
	
	public Card nextCard(){
		int maxNumber = (stack.size()-1);
		if(maxNumber == 0){
			Card temp = stack.get(maxNumber);
			stack.remove(maxNumber);
			return temp;
		}else{
			stack.remove(maxNumber);
			return stack.get(maxNumber-1);
		}
	}
	
	public boolean isEmpty(){
		if(stack.size() == 0){
			return true;
		}
		return false;
	}
	
	public void print(){
		for(int i = 0; i < stack.size(); i++){
			System.out.print(stack.get(i) + " ");
		}
	}
	
	
	
	public static void main(String [] args){
		Pile myPile1 = new Pile();
		Pile myPile2 = new Pile();
		ArrayList<Card> myArray = new ArrayList<Card>();
		Card myCard1 = new Card("D",0);
		Card myCard2 = new Card("H",0);
		Card myCard3 = new Card("C",0);
		Card myCard4 = new Card("S",0);
		myArray.add(myCard1);
		myArray.add(myCard2);
		myArray.add(myCard3);
		myArray.add(myCard4);
		myPile1.fill();
		myPile1.print();
		System.out.println();
		myPile1.nextCard();
		myPile1.print();
		System.out.println();
		System.out.println();
		myPile2.fill(myArray);
		myPile2.print();
		System.out.println();
		System.out.println();
		myPile2.nextCard();
		myPile2.print();
		System.out.println();
	}
}