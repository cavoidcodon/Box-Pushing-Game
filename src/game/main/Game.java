package game.main;

//import java.util.Random;
import java.util.Scanner;
//import java.util.Vector;
import game.element.*;

public class Game {
	private Map map;
	private Pusher pusher;
	private Box box;
	private StorgePoint storge;
	private boolean isOver;
	private boolean isFinish;
	
	public Game () throws IndexOutOfBoundsException{
		map = new Map();
		pusher = new Pusher();
		box = new Box();
		storge = new StorgePoint();
		isOver = false;
		isFinish = false;
		
		//
		// Generate random position for Pusher, Box, StorgePoint
		// These positions must be distinct
		//
		/*
		Random rand = new Random();
		Vector<Integer> positionCollection = new Vector<Integer>();
		int iNew = 0;
		for (int i=0; i<3; ) {
			iNew = rand.nextInt(16);
			if (!positionCollection.contains(iNew)) {
				i ++;
				positionCollection.add(iNew);
			}
		}
		
		pusher.setPosition(positionCollection.get(0)/4, positionCollection.get(0)%4);
		box.setPosition(positionCollection.get(1)/4, positionCollection.get(1)%4);
		storge.setPosition(positionCollection.get(2)/4, positionCollection.get(2)%4);
		*/
		
		//
		// Fix position for Pusher, Box, StorgePoint
		//
		pusher.setPosition(0, 0);
		box.setPosition(1, 2);
		storge.setPosition(3, 2);
		
		map.setMap(pusher, box, storge);
	}
	
	public void start() throws IndexOutOfBoundsException{
		map.displayMap();
		
		Scanner input = new Scanner(System.in);
		while (!isOver && !isFinish) {
			
			// input control key 'A', 'W', 'D', 'S'
			System.out.println("Next Step: ");
			String inputString = input.nextLine();
			inputString.toUpperCase();
			char controlKey = inputString.charAt(0);
			
			switch (controlKey)
			{
				case 'A':
					pusher.moveLeft();
					if (pusher.getPosition().isSamePoint(box.getPosition())) {
						box.moveLeft();
					}
					break;
				case 'W':
					pusher.moveUp();
					if (pusher.getPosition().isSamePoint(box.getPosition())) {
						box.moveUp();
					}
					break;
				case 'D':
					pusher.moveRight();
					if (pusher.getPosition().isSamePoint(box.getPosition())) {
						box.moveRight();
					}
					break;
				case 'S':
					pusher.moveDown();
					if (pusher.getPosition().isSamePoint(box.getPosition())) {
						box.moveDown();
					}
					break;
				default:
					System.out.println("Invalid Control Key !");
			}
			
			// if the position of box == position of storage point ==> Win
			if (box.getPosition().isSamePoint(storge.getPosition())) {
				isFinish = true;
			}
			else if (box.getPosition().isSamePoint(new Point(0, 0)) ||
					 box.getPosition().isSamePoint(new Point(3, 0)) ||
					 box.getPosition().isSamePoint(new Point(3, 3)) ||
					 box.getPosition().isSamePoint(new Point(0, 3))) {
				
				isOver = true;
			}
			
			// reset map
			map.setMap(pusher, box, storge);
			map.displayMap();
		}
		
		if (isFinish) {
			System.out.println("You Won !!!!");
		}
		else {
			System.out.println("Game Over !");
		}
		
		input.close();
	}
}
