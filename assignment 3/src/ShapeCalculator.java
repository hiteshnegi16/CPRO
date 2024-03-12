import java.util.Scanner;

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Area Calculator\n");
        String continueInput;
        do {
            System.out.print("Calculate area of a circle, square, or rectangle? (c/s/r): ");
            char choice = scanner.nextLine().charAt(0);
            switch (choice) {
                case 'c':
                    System.out.print("CIRCLE:\nEnter radius: ");
                    double radius = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline character
                    Circle circle = new Circle(radius);
                    System.out.println(circle);
                    break;
                case 's':
                    System.out.print("SQUARE:\nEnter width: ");
                    double widthS = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline character
                    Square square = new Square(widthS);
                    System.out.println(square);
                    break;
                case 'r':
                    System.out.print("RECTANGLE:\nEnter width: ");
                    double widthR = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double heightR = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline character
                    Rectangle rectangle = new Rectangle(widthR, heightR);
                    System.out.println(rectangle);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.print("\nContinue? (y/n): ");
            continueInput = scanner.nextLine();
        } while (continueInput.equalsIgnoreCase("y"));
        scanner.close();
    }
}
