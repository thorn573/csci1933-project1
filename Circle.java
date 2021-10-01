// Written by Khoi Le (le000171)
// Written by Jessica Thorne (thorn573)

import java.awt.Color;

public class Circle  {
	private double centerXPos, centerYPos, radius;
	private Color color;

	public Circle (double x, double y, double r) {
		centerXPos = x;
		centerYPos = y;
		radius = r;
	}

	public double calculatePerimeter() {
		return (2 * radius) * 3.14;
	}

	public double calculateArea() {
		return (radius * radius) * 3.14;
	}

	public void setColor(Color newC) {
		color = newC;
	}

	public void setPos(double newX, double newY) {
		centerXPos = newX;
		centerYPos = newY;
	}

	public void setRadius(double newR) {
		radius = newR;
	}

	public Color getColor() {
		return color;
	}

	public double getXPos() {
		return centerXPos;
	}

	public double getYPos() {
		return centerYPos;
	}

	public double getRadius() {
		return radius;
	}

	public static void main(String[] args) {
		// Tests for Circle Class:
		Circle myCircle = new Circle(1.3, 4.7, 3.8);

		// 1) Calculate perimeter
		System.out.println("Circle perimeter: " + myCircle.calculatePerimeter());

		// 2) Calculate area
		System.out.println("Circle area: " + myCircle.calculateArea());

		// 3) Setting & getting color
		myCircle.setColor(Color.blue);
		System.out.println("Circle color: " + myCircle.getColor());

		// 4) Setting & getting new position
		System.out.println("Old circle position: (" + myCircle.getXPos() + ", " + myCircle.getYPos() + ")");
		myCircle.setPos(1.6, 8.9);
		System.out.println("New circle position: (" + myCircle.getXPos() + ", " + myCircle.getYPos() + ")");

		// 5) Setting & getting new radius
		System.out.println("Old circle radius: " + myCircle.getRadius());
		myCircle.setRadius(9.3);
		System.out.println("New circle radius: " + myCircle.getRadius());

	}

} // Circle Class
