// Written by Khoi Le (le000171)

import java.awt.Color;
import java.lang.Math;

public class Triangle {
	private double bottomLeftXPos, bottomLeftYPos, width, height;
	private Color color;

	public Triangle(double x, double y, double w, double h) {
		bottomLeftXPos = x;
		bottomLeftYPos = y;
		width = w;
		height = h;
	} // Constructor

	public double calculatePerimeter() {
		// Find the diagonal side lengths by using the Pythagorean Theorem (a^2 + b^2 = c^2).
		// Theorem may be used because the geometry of an isoceles triangle dictates
		// the height vector forms a right angle with the base thus splitting the triangle
		// into two right triangles.
		double a = width / 2;
		double b = height;
		double c = Math.sqrt((a * a) + (b * b));

		return (2 * c) + width;
	}

	public double calculateArea() {
		return (width * height) / 2;
	}

	public void setColor(Color newC) {
		color = newC;
	}

	public void setPos(double newX, double newY) {
		bottomLeftXPos = newX;
		bottomLeftYPos = newY;
	}

	public void setHeight (double newH) {
		height = newH;
	}

	public void setWidth (double newW) {
		width = newW;
	}

	public Color getColor() {
		return color;
	}

	public double getXPos() {
		return bottomLeftXPos;
	}

	public double getYPos() {
		return bottomLeftYPos;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public static void main(String[] args) {
		// Tests for Triangle Class:
		Triangle myTriangle = new Triangle(1.2, 4.5, 2.1, 6.5);

		// 1) Calculate perimeter
		System.out.println("Triangle perimeter: " + myTriangle.calculatePerimeter());

		// 2) Calculate area
		System.out.println("Triangle area: " + myTriangle.calculateArea());

		// 3) Setting & getting color
		myTriangle.setColor(Color.blue);
		System.out.println("Triangle color: " + myTriangle.getColor());

		// 4) Setting & getting new position
		System.out.println("Old triangle position: (" + myTriangle.getXPos() + ", " + myTriangle.getYPos() + ")");
		myTriangle.setPos(8.9, 7.2);
		System.out.println("New triangle position: (" + myTriangle.getXPos() + ", " + myTriangle.getYPos() + ")");

		// 5) Setting & getting new width
		System.out.println("Old triangle width: " + myTriangle.getWidth());
		myTriangle.setWidth(9.2);
		System.out.println("New triangle width: " + myTriangle.getWidth());

		// 6) Setting & getting new height
		System.out.println("Old triangle height: " + myTriangle.getHeight());
		myTriangle.setHeight(6.7);
		System.out.println("New triangle height: " + myTriangle.getHeight());

	}

} // Triangle Class
