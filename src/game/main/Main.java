package game.main;

public class Main {

	public static void main(String[] args) {
		Game boxPushingGame = new Game();
		try {
			boxPushingGame.start();
		}catch (IndexOutOfBoundsException err) {
			System.out.println("You Can Not Go Or Push The Box Out Of Map!");
			System.out.println("Game over !");
		}

	}

}
