// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea = 0;  // member variable for tracking the total area
    private Color[] colorCycle = {Color.red, Color.green, Color.blue};
    private int levels;

    public FractalDrawer(int levels) {
      this.levels = levels;
    }  // contructor

    public double findCircleFractalArea(double radius) {
      double area = 0.0;
      int count = 0;

      while (count <= levels) {
        count++;

        Circle tempCircle = new Circle(0, 0, radius);
        area += tempCircle.calculateArea();

        radius = radius / 2;
      }

      return area;
    }

    public double findTriangleFractalArea(double width, double height) {
      double area = 0.0;
      int count = 0;

      while (count <= levels) {
        count++;

        Triangle tempTriangle = new Triangle(0, 0, width, height);
        area += tempTriangle.calculateArea();

        width = width / 2;
        height = height / 2;
      }

      return area;
    }

    public double findRectangleFractalArea(double width, double height) {
      double area = 0.0;
      int count = 0;

      while (count <= levels) {
        count++;

        Rectangle tempRectangle = new Rectangle(0, 0, width, height);
        area += tempRectangle.calculateArea();

        width = width / 2;
        height = height / 2;
      }

      return area;
    }

    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
      Canvas myCanvas = new Canvas(600, 600);
      double area = 0.0;

      switch (type) {
        case "circle": {
          int radius = 250;
          area = findCircleFractalArea(radius);
          drawCircleFractal(radius, 300, 300, colorCycle[0], 0, myCanvas, levels);
          break;
        }
        case "triangle": {
          int width = 170;
          int height = 170;
          area = findTriangleFractalArea(width, height);
          drawTriangleFractal(width, height, 200, 400, colorCycle[0], 0, myCanvas, levels);
          break;
        }
        case "rectangle": {
          int width = 300;
          int height = 200;
          area = findRectangleFractalArea(width, height);
          drawRectangleFractal(width, height, 150, 170, colorCycle[0], 0, myCanvas, levels);
          break;
        }
        default: System.out.println("Shape input invalid. Restart program.");
      }

      return area;
    }

    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, int cIndex, Canvas canvas, int level) {
      // 1) draw triangle for this cycle
      Triangle newTriangle = new Triangle(x, y, width, height);
      newTriangle.setColor(c);
      canvas.drawShape(newTriangle);

      if (level == 0) {
        return;
      } else {
        level--;

        double newWidth = width / 2;
        double newHeight = height / 2;
        cIndex++;
        if (cIndex > colorCycle.length - 1) {
          cIndex = 0;
        }
        Color newColor = colorCycle[cIndex];

        // 2) start cycle for left triangle
        double leftTriangle_xPos = x - newWidth;
        double leftTriangle_yPos = y;
        drawTriangleFractal(newWidth, newHeight, leftTriangle_xPos, leftTriangle_yPos, newColor, cIndex, canvas, level);

        // 3) start cycle for right triangle
        double rightTriangle_xPos = x + width;
        double rightTriangle_yPos = y;
        drawTriangleFractal(newWidth, newHeight, rightTriangle_xPos, rightTriangle_yPos, newColor, cIndex, canvas, level);

        // 4) start crycle for top triangle
        double topTriangle_xPos = x + (width / 2) - (newWidth / 2);
        double topTriangle_yPos = y - height;
        drawTriangleFractal(newWidth, newHeight, topTriangle_xPos, topTriangle_yPos, newColor, cIndex, canvas, level);
      }
    }

    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, int cIndex, Canvas canvas, int level) {
      // 1) draw circle for this cycle
      Circle newCircle = new Circle(x, y, radius);
      newCircle.setColor(c);
      canvas.drawShape(newCircle);

      if (level == 0) {
        return;
      } else {
        level--;

        double newRadius = radius / 2;
        cIndex++;
        if (cIndex > colorCycle.length - 1) {
          cIndex = 0;
        }
        Color newColor = colorCycle[cIndex];

        // 2) start cycle for left circle
        double leftCircle_xPos = x - radius + newRadius;
        double leftCircle_yPos = y;
        drawCircleFractal(newRadius, leftCircle_xPos, leftCircle_yPos, newColor, cIndex, canvas, level);

        // 3) start cycle for right circle
        double rightCircle_xPos = x + radius - newRadius;
        double rightCircle_yPos = y;
        drawCircleFractal(newRadius, rightCircle_xPos, rightCircle_yPos, newColor, cIndex, canvas, level);

        // 4) start cycle for top circle
        double topCircle_xPos = x;
        double topCircle_yPos = y - radius + newRadius;
        drawCircleFractal(newRadius, topCircle_xPos, topCircle_yPos, newColor, cIndex, canvas, level);

        // 5) start cycle for bottom circle
        double bottomCircle_xPos = x;
        double bottomCircle_yPos = y + radius - newRadius;
        drawCircleFractal(newRadius, bottomCircle_xPos, bottomCircle_yPos, newColor, cIndex, canvas, level);
      }
    }

    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, int cIndex, Canvas canvas, int level) {
      // 1) draw circle for this cycle
      Rectangle newRectangle = new Rectangle(x, y, width, height);
      newRectangle.setColor(c);
      canvas.drawShape(newRectangle);

      if (level == 0) {
        return;
      } else {
        level--;

        double newWidth = width / 2;
        double newHeight = height / 2;
        cIndex++;
        if (cIndex > colorCycle.length - 1) {
          cIndex = 0;
        }
        Color newColor = colorCycle[cIndex];

        // 2) start cycle for left rectangle
        double leftRectangle_xPos = x - newWidth;
        double leftRectangle_yPos = y + (0.5 * newHeight);
        drawRectangleFractal(newWidth, newHeight, leftRectangle_xPos, leftRectangle_yPos, newColor, cIndex, canvas, level);

        // 3) start cycle for right rectangle
        double rightRectangle_xPos = x + width;
        double rightRectangle_yPos = y + (0.5 * newHeight);
        drawRectangleFractal(newWidth, newHeight, rightRectangle_xPos, rightRectangle_yPos, newColor, cIndex, canvas, level);

        // 4) start cycle for top rectangle
        double topRectangle_xPos = x + (0.5 * newWidth);
        double topRectangle_yPos = y - newHeight;
        drawRectangleFractal(newWidth, newHeight, topRectangle_xPos, topRectangle_yPos, newColor, cIndex, canvas, level);

        // 5) start cycle for bottom rectangle
        double bottomRectangle_xPos = x + (0.5 * newWidth);
        double bottomRectangle_yPos = y + height;
        drawRectangleFractal(newWidth, newHeight, bottomRectangle_xPos, bottomRectangle_yPos, newColor, cIndex, canvas, level);
      }
    }

    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
      System.out.println("Shape Options: \n - Circle \n - Triangle \n - Rectangle");
      System.out.print("Enter shape for fractal drawing: ");
      Scanner s = new Scanner(System.in);
      String shapeInput = s.nextLine().toLowerCase();

      FractalDrawer drawer = new FractalDrawer(7);
      double totalArea = drawer.drawFractal(shapeInput);

      System.out.print("Total fractal area: " + totalArea + " units squared.");
    }
}
