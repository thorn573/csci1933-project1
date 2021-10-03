// Written by Jessica Thorne (thorn573)

import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea = 0;
    private Color[] colorCycle = {Color.red, Color.green, Color.blue};
    private int levels;

    public FractalDrawer(int l) {
      levels = l;
    } // Constructor

    // Starts fractal recursive chain based on inputted shape type (circle, triangle, or rectangle.)
    public double drawFractal(String type) {
      Canvas myCanvas = new Canvas();

      switch (type) {
        case "circle": {
          drawCircleFractal(100, 400, 400, colorCycle[0], 0, myCanvas, levels);
          break;
        }
        case "triangle": {
          drawTriangleFractal(170, 170, 300, 500, colorCycle[0], 0, myCanvas, levels);
          break;
        }
        case "rectangle": {
          drawRectangleFractal(200, 200, 300, 300, colorCycle[0], 0, myCanvas, levels);
          break;
        }
        default: System.out.println("Shape input invalid. Restart program.");
      }

      return totalArea;
    }

    // Draws trangular fractal recursivly.
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, int cIndex, Canvas canvas, int level) {
      // 1) Draw triangle for this fractal cycle
      Triangle newTriangle = new Triangle(x, y, width, height);
      newTriangle.setColor(c);
      canvas.drawShape(newTriangle);

      // 2) Add new triangles area to fractals total area
      totalArea += newTriangle.calculateArea();

      if (level == 0) {
        // Base case is the last layer of the fractal.
        // No new triangles need to be calculated or drawn.
        return;
      } else {
        level--;

        // 3) Find width, height & color of new triangles
        double newWidth = width / 2;
        double newHeight = height / 2;
        cIndex++;
        if (cIndex > colorCycle.length - 1) {
          cIndex = 0;
        }
        Color newColor = colorCycle[cIndex];

        // 4) Start fractal cycle for new left positioned triangle
        double leftTriangleXPos = x - newWidth;
        double leftTriangleYPos = y;
        drawTriangleFractal(newWidth, newHeight, leftTriangleXPos, leftTriangleYPos, newColor, cIndex, canvas, level);

        // 5) Start fractal cycle for new right positioned triangle
        double rightTriangleXPos = x + width;
        double rightTriangleYPos = y;
        drawTriangleFractal(newWidth, newHeight, rightTriangleXPos, rightTriangleYPos, newColor, cIndex, canvas, level);

        // 6) Start fractal cycle for new top positioned triangle
        double topTriangleXPos = x + (width / 2) - (newWidth / 2);
        double topTriangleYPos = y - height;
        drawTriangleFractal(newWidth, newHeight, topTriangleXPos, topTriangleYPos, newColor, cIndex, canvas, level);
      }
    }

    // Draws circular fractal recursivly.
    public void drawCircleFractal(double radius, double x, double y, Color c, int cIndex, Canvas canvas, int level) {
      // 1) Draw circle for this fractal cycle
      Circle newCircle = new Circle(x, y, radius);
      newCircle.setColor(c);
      canvas.drawShape(newCircle);

      // 2) Add new circles area to fractals total area
      totalArea += newCircle.calculateArea();

      if (level == 0) {
        // Base case is the last layer of the fractal.
        // No new circles need to be calculated or drawn.
        return;
      } else {
        level--;

        // 3) Find radius & color of new circles
        double newRadius = radius / 2;
        cIndex++;
        if (cIndex > colorCycle.length - 1) {
          cIndex = 0;
        }
        Color newColor = colorCycle[cIndex];

        // 4) Start fractal cycle for new left positioned circle
        double leftCircleXPos = x - radius - newRadius;
        double leftCircleYPos = y;
        drawCircleFractal(newRadius, leftCircleXPos, leftCircleYPos, newColor, cIndex, canvas, level);

        // 5) Start fractal cycle for new right positioned circle
        double rightCircleXPos = x + radius + newRadius;
        double rightCircleYPos = y;
        drawCircleFractal(newRadius, rightCircleXPos, rightCircleYPos, newColor, cIndex, canvas, level);

        // 6) Start fractal cycle for new top positioned circle
        double topCircleXPos = x;
        double topCircleYPos = y - radius - newRadius;
        drawCircleFractal(newRadius, topCircleXPos, topCircleYPos, newColor, cIndex, canvas, level);

        // 7) Start fractal cycle for new bottom positioned circle
        double bottomCircleXPos = x;
        double bottomCircleYPos = y + radius + newRadius;
        drawCircleFractal(newRadius, bottomCircleXPos, bottomCircleYPos, newColor, cIndex, canvas, level);
      }
    }

    // Draws rectangular fractal recursivly.
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, int cIndex, Canvas canvas, int level) {
      // 1) Draw rectangle for this fractal cycle
      Rectangle newRectangle = new Rectangle(x, y, width, height);
      newRectangle.setColor(c);
      canvas.drawShape(newRectangle);

      // 2) Add new rectangles area to fractals total area
      totalArea += newRectangle.calculateArea();

      if (level == 0) {
        // Base case is the last layer of the fractal.
        // No new rectangles need to be calculated or drawn.
        return;
      } else {
        level--;

        // 3) Find width, height & color of new rectangles
        double newWidth = width / 2;
        double newHeight = height / 2;
        cIndex++;
        if (cIndex > colorCycle.length - 1) {
          cIndex = 0;
        }
        Color newColor = colorCycle[cIndex];

        // 4) Start fractal cycle for new left positioned rectangle
        double leftRectangleXPos = x - newWidth;
        double leftRectangleYPos = y + (0.5 * newHeight);
        drawRectangleFractal(newWidth, newHeight, leftRectangleXPos, leftRectangleYPos, newColor, cIndex, canvas, level);

        // 5) Start fractal cycle for new right positioned rectangle
        double rightRectangleXPos = x + width;
        double rightRectangleYPos = y + (0.5 * newHeight);
        drawRectangleFractal(newWidth, newHeight, rightRectangleXPos, rightRectangleYPos, newColor, cIndex, canvas, level);

        // 6) Start fractal cycle for new top positioned rectangle
        double topRectangleXPos = x + (0.5 * newWidth);
        double topRectangleYPos = y - newHeight;
        drawRectangleFractal(newWidth, newHeight, topRectangleXPos, topRectangleYPos, newColor, cIndex, canvas, level);

        // 7) Start fractal cycle for new bottom positioned rectangle
        double bottomRectangleXPos = x + (0.5 * newWidth);
        double bottomRectangleYPos = y + height;
        drawRectangleFractal(newWidth, newHeight, bottomRectangleXPos, bottomRectangleYPos, newColor, cIndex, canvas, level);
      }
    }

    public static void main(String[] args){
      System.out.println("Shape Options: \n - Circle \n - Triangle \n - Rectangle");
      System.out.print("Enter shape for fractal drawing: ");
      Scanner s = new Scanner(System.in);
      String shapeInput = s.nextLine().toLowerCase();

      FractalDrawer drawer = new FractalDrawer(7);
      double totalArea = drawer.drawFractal(shapeInput);

      System.out.print("Total fractal area: " + totalArea + " units squared.");
    }

} // FractalDrawer Class
