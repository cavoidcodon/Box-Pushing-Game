package game.element;

public class Map {
	private char map[][];
	
	public Map () {
		map = new char [4][4];
	}
	
	public void setMap(Pusher player, Box box, StorgePoint storge) {
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				map[i][j] = '-';
			}
		}
		
		map[player.getPosition().getPointX()][player.getPosition().getpointY()] = 'P';
		map[box.getPosition().getPointX()][box.getPosition().getpointY()] = 'B';
		map[storge.getPosition().getPointX()][storge.getPosition().getpointY()] = 'S';
	}
	
	public void displayMap() {
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
