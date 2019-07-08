package game.element;

public class GeneralElement {
	protected Point position;
	
	public GeneralElement() {
		position = new Point();
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void setPosition(int xValue, int yValue) throws IndexOutOfBoundsException{
		position.setPoint(xValue, yValue);
	}
}
