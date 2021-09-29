import java.awt.Color;
import java.lang.Math;

public class Triangle {
	double botLeft_xPos, botLeft_yPos, width, height;
	Color color;

	public Triangle(double botLeft_xPos, double botLeft_yPos,double width, double height) {
		this.botLeft_xPos = botLeft_xPos;
		this.botLeft_yPos = botLeft_yPos;
		this.width = width;
		this.height = height;
	}

	public double calculatePerimeter() {
		// Find side length of triangle using the Pythagorean Theorem (a^2 + b^2 = c^2).
		// Theorem may be used because the geometry of an isoceles triangle dictates
		// the height vector forms a right angle with the base.
		double a = width / 2;
		double b = height;
		double c = Math.sqrt((a * a) + (b * b));

		return c;
	}

	public double calculateArea() {
		return width * height / 2;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPos(double newbotLeft_xPos, double newbotLeft_yPos) {
		this.botLeft_xPos = newbotLeft_xPos;
		this.botLeft_yPos = newbotLeft_yPos;
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
		return this.botLeft_xPos;
	}

	public double getYPos() {
		return this.botLeft_yPos;
	}

	public double getHeight() {
		return this.height;
	}

	public double getWidth() {
		return this.width;
	}

	public static void main(String[] args) {
	}

}
