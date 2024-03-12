import java.util.Random;
import java.util.Scanner;

class Die {
    private int value;
    private final Random random;

    public Die() {
        value = 0;
        random = new Random();
    }

    public void roll() {
        value = random.nextInt(6) + 1; // Generates a random number between 1 and 6 (inclusive)
    }

    public int getValue() {
        return value;
    }
}

class Dice {
    private final Die die1;
    private final Die die2;

    public Dice() {
        die1 = new Die();
        die2 = new Die();
    }

    public int getDieOneValue() {
        return die1.getValue();
    }

    public int getDieTwoValue() {
        return die2.getValue();
    }

    public int getSum() {
        return die1.getValue() + die2.getValue();
    }

    public void roll() {
        die1.roll();
        die2.roll();
    }

    public void printRoll() {
        System.out.println("Die 1: " + getDieOneValue());
        System.out.println("Die 2: " + getDieTwoValue());

        int sum = getSum();
        System.out.println("Total: " + sum);

        if (sum == 7) {
            System.out.println("Craps!");
        } else if (sum == 2) {
            System.out.println("Snake eyes!");
        } else if (sum == 12) {
            System.out.println("Box cars!");
        }
    }
}

public class dice_roller {
    public static void main(String[] args) {
        System.out.println("Welcome to the Dice Roller!");

        char rollAgain;
        Scanner scanner = new Scanner(System.in);
        do {
            Dice dice = new Dice();
            dice.roll();
            dice.printRoll();

            System.out.print("\nRoll again? (y/n): ");
            rollAgain = scanner.next().charAt(0);
            System.out.println();

        } while (rollAgain == 'y' || rollAgain == 'Y');
    }
}
