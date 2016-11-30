package reusing;

public class Chess extends BoardGame{
	public static void main(String[] args) {
		Chess chess = new Chess();
	}
	public Chess(){
		super(11);
		System.out.println("Chess Constructor");
	}
}

class BoardGame extends Game{
	public BoardGame(int i){
		super(11);
		System.out.println("BoardGame Constructor");
	}
}
class Game {
	public Game(int i){
		System.out.println("Game Constructor");
	}
}