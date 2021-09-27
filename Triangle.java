public class Triangle {
	double bottomLeftCornerXPosition, bottomLeftCornerYPosution, width, height;
	Color color;
	public Triangle(double bottomLeftCornerXPosition, double bottomLeftCornerYPosition,double width, double height) {
	this.bottomLeftCornerXPosition = bottomLeftCornerXPosition;
	this.bottomLeftCornerYPosition = bottomLeftCornerYPosition;
	this.width = width;
	this.height = height;
}
public double calculatePerimeter() {
	//TO DO
}
public double calculateArea() {
	return width * height / 2;
}
public void setColor(Color color) {
	this.color = color;
}
public void setPos(double newBottomLeftCornerXPosition, double newBottomLeftCornerYPosition) {
	this.bottomLeftCornerXPosition = newBottomLeftCornerXPosition;
	this.bottomLeftCornerYPosition = newBottomLeftCornerYPosition;
}
public void setHeight (double newHeight) {
	this.height = newHeight;
}
public void setWidth (double newWidth) {
	this.width = newWidth;
}
public Color getColor() {
	return this.color;
}
public double getXPos() {
	return this.bottomLeftCornerXPosition;
}
public double getYPos() {
	return this.bottomLeftCornerYPosition;
}
public double getHeight() {
	return this.height;
}
public double getWidth() {
	return this.width;
}
}// Triangle Class
