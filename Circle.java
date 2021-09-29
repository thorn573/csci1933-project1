import java.awt.Color;

public class Circle  {
	double centerXPos, centerYPos, radius;
	Color color;

	public Circle (double centerXPos, double centerYPos, double radius) {
		this.centerXPos = centerXPos;
		this.centerYPos = centerYPos;
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

	public void setPos(double newXPos, double newYPos) {
		this.centerXPos = newXPos;
		this.centerYPos = newYPos;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Color getColor() {
		return this.color;
	}

	public double getXPos() {
		return this.centerXPos;
	}

	public double getYPos() {
		return this.centerYPos;
	}

	public double getRadius() {
		return this.radius;
	}

	public static void main(String[] args) {
	}

}
