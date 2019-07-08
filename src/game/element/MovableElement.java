package game.element;

//
// An object can go left, right, up, down using control key 'A', 'D', 'W', 'S'
//

public class MovableElement extends GeneralElement{
	public void moveLeft() throws IndexOutOfBoundsException{
		position.setPoint(position.getPointX(), position.getpointY() - 1);
	}
	
	public void moveRight() throws IndexOutOfBoundsException{
		position.setPoint(position.getPointX(), position.getpointY() + 1);
	}
	
	public void moveUp() throws IndexOutOfBoundsException{
		position.setPoint(position.getPointX() - 1, position.getpointY());
	}
	
	public void moveDown() throws IndexOutOfBoundsException{
		position.setPoint(position.getPointX() + 1, position.getpointY());
	}
}
