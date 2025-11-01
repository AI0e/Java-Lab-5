import java.util.List;
import java.util.Scanner;

/**
 * Main executable class for Laboratory Work #5.
 * This class demonstrates inheritance and polymorphism.
 *
 * Variant 1: Sweets
 * It creates a SweetGift and fills it with various types of Sweet
 * objects (Candy, ChocolateBar, Lollipop).
 *
 * It then performs the required actions:
 * 1. Calculates the total weight of the gift.
 * 2. Sorts the sweets by sugar content.
 * 3. Finds sweets within a specific chocolate content range.
 */
public class Lab5 {

    /**
     * Program entry point.
     * Handles the user interface loop and top-level exception handling.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                try {
                    SweetGift gift = new SweetGift();

                    gift.addSweet(new ChocolateBar("Dark Crown", 90, 30.0, 75));
                    gift.addSweet(new Candy("Milky Way", 52, 35.0, 0.35, "Nougat"));
                    gift.addSweet(new Lollipop("Chupa Chups", 12, 10.0, "Cherry"));
                    gift.addSweet(new Candy("Snickers", 55, 30.0, 0.30, "Caramel"));
                    gift.addSweet(new ChocolateBar("Milk Crown", 100, 50.0, 40));

                    System.out.println("--- Initial Gift Box ---");
                    System.out.println(gift);

                    double totalWeight = gift.calculateTotalWeight();
                    System.out.printf("\nTotal Gift Weight: %.1fg\n", totalWeight);

                    gift.sortSweetsBySugarContent();
                    System.out.println("\n--- Sorted by Sugar Content (ASC) ---");
                    System.out.println(gift);

                    System.out.println("\n--- Finding Sweets with 0-10% Chocolate ---");
                    List<Sweet> lowChocolate = gift.findSweetsByChocolateRange(0, 10);
                    lowChocolate.forEach(System.out::println);

                    System.out.println("\n--- Finding Sweets with 40-100% Chocolate ---");
                    List<Sweet> highChocolate = gift.findSweetsByChocolateRange(40, 100);
                    highChocolate.forEach(System.out::println);

                } catch (IllegalArgumentException e) {
                    System.err.println("Input error: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    e.printStackTrace();
                }

                String choice;
                do {
                    System.out.print("\nRun again? (y/n): ");
                    choice = scanner.nextLine().trim().toLowerCase();
                } while (!choice.equals("y") && !choice.equals("n"));

                if (choice.equals("y")) {
                    System.out.println("Restarting...");
                } else {
                    exit = true;
                    System.out.println("Program finished.");
                }
            }
        }
    }
}