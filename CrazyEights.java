//Name: Evangelos Papadopoulos AM: 5161

class CrazyEights
{
	private Table myTable;
	private Player[] playerArray;
	private int playerCount;
	
	public CrazyEights(int p){
		this.playerCount = p;
		Player human = new Player("Human");;
		this.playerArray = new Player[p];
		this.playerArray[0] = human;
		for(int i = 1; i < playerArray.length; i++){
			Player computer = new Player("Computer" + i);
			this.playerArray[i] = computer;
		}
	}
	
	public void play(){
		this.myTable = new Table();
		for(int i = 0; i < playerArray.length; i++){
			playerArray[i].draw(this.myTable,5);
		}
		boolean isOver = false;
		Card myCard;
		while(true){
			for(int i = 0; i < playerArray.length; i++){
				Player myPlayer = playerArray[i];
				System.out.println();
				System.out.println(myPlayer + "'s turn: ");
				System.out.println();
				System.out.println("Table top card: " + myTable.getTopCard());
				if(i == 0){
					myCard = myPlayer.selectCard(this.myTable);
				}else{
					myCard = myPlayer.computerSelectCard(this.myTable);
				}
				
				if(myCard == null){
					myPlayer.draw(this.myTable);
					System.out.println();
					System.out.println(myPlayer + " drew a card");
				}else{
					myPlayer.throwCard(this.myTable, myCard);
					System.out.println();
					System.out.print(myPlayer + " threw card: " + myCard);
					System.out.println();
					if(myPlayer.isDone()){
						System.out.println();
						System.out.println(myPlayer + " is the winner!");
						isOver = true;
						break;
					}
				}
			}
			if(isOver){
				break;
			}
			
		}
	}
}