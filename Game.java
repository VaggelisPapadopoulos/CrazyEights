//Name: Evangelos Papadopoulos AM: 5161

import java.util.Scanner;

class Game
{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.print("Give the number of players: ");
		int numberOfPlayers = input.nextInt();
		CrazyEights game = new CrazyEights(numberOfPlayers);
		game.play();
	}
}