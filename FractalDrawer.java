// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea = 0;  // member variable for tracking the total area
    private Color[] colorCycle = {Color.red, Color.green, Color.blue};
    private int colorIndex = 0;

    public FractalDrawer() {}  // contructor

    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
      Canvas myCanvas = new Canvas(800, 800);

      switch (type) {
        case "circle": {
          System.out.println("Shape is a circle");
          break;
        }
        case "triangle": {
          drawTriangleFractal(200, 200, 300, 500, colorCycle[colorIndex], myCanvas, 7);
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

    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas canvas, int level) {
      // Triangle constructor parameters = (double botLeft_xPos, double botLeft_yPos, double width, double height)

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
        colorIndex++;
        if (colorIndex > colorCycle.length - 1) {
          colorIndex = 0;
        }
        Color newColor = colorCycle[colorIndex];

        // 2) start cycle for left triangle
        double leftTriangle_XPos = x - newWidth;
        double leftTriangle_YPos = y;
        drawTriangleFractal(newWidth, newHeight, leftTriangle_XPos, leftTriangle_YPos, newColor, canvas, level);

        // 3) start cycle for right triangle
        double rightTriangle_XPos = x + width;
        double rightTriangle_YPos = y;
        drawTriangleFractal(newWidth, newHeight, rightTriangle_XPos, rightTriangle_YPos, newColor, canvas, level);

        // 4) start crycle for top triangle
        double topTriangle_XPos = x + (width / 2) - (newWidth / 2);
        double topTriangle_YPos = y - height;
        drawTriangleFractal(newWidth, newHeight, topTriangle_XPos, topTriangle_YPos, newColor, canvas, level);
      }
    }

    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas canvas, int level) {
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
