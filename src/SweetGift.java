import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a gift box (container) that holds various sweets.
 * This class demonstrates polymorphism by managing a List<Sweet>,
 * which can contain any object that inherits from Sweet.
 */
public class SweetGift {

    private final List<Sweet> sweets;

    /**
     * Constructs a new, empty gift box.
     */
    public SweetGift() {
        this.sweets = new ArrayList<>();
    }

    /**
     * Adds any type of Sweet (Candy, Lollipop, etc.) to the gift.
     *
     * @param sweet The sweet to add.
     */
    public void addSweet(Sweet sweet) {
        if (sweet == null) {
            throw new IllegalArgumentException("Cannot add a null sweet.");
        }
        this.sweets.add(sweet);
    }

    /**
     * Action 1: Calculates the total weight of all sweets in the gift.
     *
     * @return The total weight in grams.
     */
    public double calculateTotalWeight() {
        double totalWeight = 0.0;
        for (Sweet sweet : sweets) {
            totalWeight += sweet.getWeight();
        }
        return totalWeight;
    }

    /**
     * Action 2: Sorts the sweets in the gift by sugar content (ascending).
     * This modifies the internal list.
     */
    public void sortSweetsBySugarContent() {
        this.sweets.sort(Comparator.comparingDouble(Sweet::getSugarContent));
    }

    /**
     * Action 3: Finds all sweets within a specified chocolate content range.
     *
     * @param minPercent The minimum chocolate percentage (0-100).
     * @param maxPercent The maximum chocolate percentage (0-100).
     * @return A new list containing only the matching sweets.
     */
    public List<Sweet> findSweetsByChocolateRange(double minPercent, double maxPercent) {
        double min = minPercent / 100.0;
        double max = maxPercent / 100.0;

        if (min > max) {
            throw new IllegalArgumentException("Min percent cannot be greater than max percent.");
        }

        return this.sweets.stream()
                .filter(sweet -> sweet.getChocolateContent() >= min &&
                        sweet.getChocolateContent() <= max)
                .collect(Collectors.toList());
    }

    /**
     * Returns a string representation of the gift and its contents.
     *
     * @return A formatted string listing all sweets.
     */
    @Override
    public String toString() {
        if (sweets.isEmpty()) {
            return "The gift box is empty.";
        }

        StringBuilder sb = new StringBuilder("--- Sweet Gift Contents ---\n");
        for (Sweet sweet : sweets) {
            sb.append(sweet.toString()).append("\n");
        }
        sb.append("---------------------------");
        return sb.toString();
    }
}