public class Rectangle {
  double topLeft_xPos, topLeft_yPos, width, height;
  Color color;

  public Rectangle (double topLeft_xPos, double topLeft_yPos, double width, double height) {
    this.topLeft_xPos = topLeft_xPos;
    this.topLeft_yPos = topLeft_yPos;
    this.width = width;
    this.height = height;
  }

  public double calculatePerimeter() {
    return (width * 2) + (height * 2);
  }

  public double calculateArea() {
    return width * height;
  }

  public void setColor(Color color) {
		this.color = color;
	}

  public void setPos(double newXPos, double newYPos) {
    this.topLeft_xPos = newXPos;
    this.topLeft_yPos = newYPos;
  }

  public void setHeight(double newHeight) {
    this.height = newHeight;
  }

  public void setWidth(double newWidth) {
    this.width = newWidth;
  }

  public Color getColor() {
		return this.color;
	}

  public double getXPos() {
    return this.topLeft_xPos;
  }

  public double getYPos() {
    return this.topLeft_yPos;
  }

  public double getWidth() {
    return this.width;
  }

  public double getHeight() {
    return this.height;
  }

}
