// Written by Khoi Le (le000171)
// Written by Jessica Thorne (thorn573)

import java.awt.Color;

public class Rectangle {
  double topLeftXPos, topLeftYPos, width, height;
  Color color;

  public Rectangle (double x, double y, double w, double h) {
    topLeftXPos = x;
    topLeftYPos = y;
    width = w;
    height = h;
  }

  public double calculatePerimeter() {
    return (width * 2) + (height * 2);
  }

  public double calculateArea() {
    return width * height;
  }

  public void setColor(Color newC) {
		color = newC;
	}

  public void setPos(double newX, double newY) {
    topLeftXPos = newX;
    topLeftYPos = newY;
  }

  public void setHeight(double newH) {
    height = newH;
  }

  public void setWidth(double newW) {
    width = newW;
  }

  public Color getColor() {
		return color;
	}

  public double getXPos() {
    return topLeftXPos;
  }

  public double getYPos() {
    return topLeftYPos;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  public static void main(String[] args) {
    // Tests for Rectangle Class:
		Rectangle myRectangle = new Rectangle(1.2, 4.5, 2.1, 6.5);

		// 1) Calculate perimeter
		System.out.println("Rectangle perimeter: " + myRectangle.calculatePerimeter());

		// 2) Calculate area
		System.out.println("Rectangle area: " + myRectangle.calculateArea());

		// 3) Setting & getting color
		myRectangle.setColor(Color.blue);
		System.out.println("Rectangle color: " + myRectangle.getColor());

		// 4) Setting & getting new position
		System.out.println("Old rectangle position: (" + myRectangle.getXPos() + ", " + myRectangle.getYPos() + ")");
		myRectangle.setPos(8.9, 7.2);
		System.out.println("New rectangle position: (" + myRectangle.getXPos() + ", " + myRectangle.getYPos() + ")");

		// 5) Setting & getting new width
		System.out.println("Old rectangle width: " + myRectangle.getWidth());
		myRectangle.setWidth(9.2);
		System.out.println("New rectangle width: " + myRectangle.getWidth());

		// 6) Setting & getting new height
		System.out.println("Old rectangle height: " + myRectangle.getHeight());
		myRectangle.setHeight(6.7);
		System.out.println("New rectangle height: " + myRectangle.getHeight());
	}

} // Rectangle Class
