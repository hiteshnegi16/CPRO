import java.util.Scanner;

abstract class Shape {
    public abstract double getArea();

    @Override
    public String toString() {
        return "Area: " + getArea();
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return width * width;
    }
}

class Rectangle extends Square {
    private double height;

    public Rectangle(double width, double height) {
        super(width);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return getWidth() * height;
    }
}

public class ShapeCalcEx {
    private static final Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Area Calculator\n");
        String continueInput;
        do {
            char choice = getShapeType();
            switch (choice) {
                case 'c':
                    calculateCircleArea();
                    break;
                case 's':
                    calculateSquareArea();
                    break;
                case 'r':
                    calculateRectangleArea();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            continueInput = getString("\nContinue? (y/n): ");
        } while (continueInput.equalsIgnoreCase("y"));
    }

    private static char getShapeType() {
        return getString("Calculate area of a circle, square, or rectangle? (c/s/r): ").charAt(0);
    }

    private static void calculateCircleArea() {
        double radius = getDouble("CIRCLE:\nEnter radius: ");
        Circle circle = new Circle(radius);
        System.out.println(circle);
    }

    private static void calculateSquareArea() {
        double width = getDouble("SQUARE:\nEnter width: ");
        Square square = new Square(width);
        System.out.println(square);
    }

    private static void calculateRectangleArea() {
        double width = getDouble("RECTANGLE:\nEnter width: ");
        double height = getDouble("Enter height: ");
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println(rectangle);
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return inputScanner.nextLine();
    }

    public static double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(inputScanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid number value.");
            }
        }
    }
}
