// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea = 0;  // member variable for tracking the total area
    private Color[] colorCycle = {Color.red, Color.green, Color.blue};

    public FractalDrawer() {}  // contructor

    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
      Canvas myCanvas = new Canvas(800, 800);

      switch (type) {
        case "circle": {
          drawCircleFractal(300, 400, 400, colorCycle[0], 0, myCanvas, 7);
          break;
        }
        case "triangle": {
          drawTriangleFractal(200, 200, 300, 500, colorCycle[0], 0, myCanvas, 7);
          break;
        }
        case "rectangle": {
          System.out.println("Shape is a rectangle");
          break;
        }
        default: System.out.println("Shape input invalid. Restart program.");
      }

      return 1.0;
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

    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas canvas, int level) {
    }

    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
      System.out.println("Shape Options: \n - Circle \n - Triangle \n - Rectangle");
      System.out.print("Enter shape for fractal drawing: ");
      Scanner s = new Scanner(System.in);
      String shapeInput = s.nextLine().toLowerCase();

      FractalDrawer drawer = new FractalDrawer();
      drawer.drawFractal(shapeInput);

      System.out.println("Shape input: " + shapeInput);

    }
}
