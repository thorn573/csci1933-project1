public class Circle  {
	double centerXPosition, centerYPosition, radius;
	Color color;
	public Circle (double centerXPosition, double centerYPosition, double radius) {
	this.centerXPosition = centerXPosition;
	this.centerYPosition = centerYPosition;
	this.radius = radius;
}
public double calculatePerimeter() {
	return radius * 2 * 3.14;
}
public double calculateArea() {
	return radius * radius * 3.14;
}
public void setColor(Color color) {
	this.color = color;
}
public void setPos(double newCenterXPosition, double newCenterYPosition) {
this.centerXPosition = newCenterXPosition;
	this.centerYPosition = newCenterYPosition;
}
public void setRadius(double radius) {
	this.radius = radius;
}
public Color getColor() {
	return this.color;
}
public double getXPos() {
	return this.centerXPosition;
}
public double getYPos() {
	return this.centerYPosition;
}
public double getRadius() {
	return this.radius;
}
}// Circle Class
