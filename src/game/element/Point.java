package game.element;

import java.util.Random;

public class Point {
	private int pointX;
	private int pointY;
	
	public Point() {		
		Random rand = new Random();
		pointX = rand.nextInt(4);
		pointY = rand.nextInt(4);
	}
	
	public Point(int newX, int newY) {
		pointX = newX;
		pointY = newY;
	}
	
	public void setPoint(int newX, int newY) throws IndexOutOfBoundsException{
		if (newX >= 0 && newX < 4 &&
			newY >= 0 && newY < 4     ) {		
			pointX = newX;
			pointY = newY;
		}
		else {
			throw new IndexOutOfBoundsException();
		}			
	}
	
	public int getPointX () {
		return pointX;
	}
	
	public int getpointY() {
		return pointY;
	}
	
	public boolean isSamePoint(Point point) {
		return point.getPointX() == pointX &&
			   point.getpointY() == pointY;
	}
}
