// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea = 0;  // member variable for tracking the total area

    public FractalDrawer() {}  // contructor

    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
      switch (type) {
        case "circle": {
          System.out.println("Shape is a circle");
          break;
        }
        case "triangle": {
          System.out.println("Shape is a triangle");
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
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
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
