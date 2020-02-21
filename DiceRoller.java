import java.util.concurrent.ThreadLocalRandom;
import java.util.Hashtable;
public class DiceRoller {
    // create hashtable
    static Hashtable<Integer, Integer> DiceFrequency;
    // Singleton
    public DiceRoller getInstance(Object instance) {
        if (instance == null) {
            instance = new DiceRoller(6, 2);
        }
        return (DiceRoller) instance;
    }
    // Constructor
    public DiceRoller(int numberOfSides, int numberOfDice) {
        DiceFrequency = new Hashtable<>();
        // maxSum == the highest possible sum
        int maxSum = numberOfDice * numberOfSides;
        // iterates through all the possible sums to set up DiceFrequency hashtable
        for (int i=1; i<maxSum+1; i++) {
            // sets up empty values for DiceFrequency
            DiceFrequency.put(i, 0);
        }
    }
    public void rollDice(int numberOfSides, int numberOfDice) {
        // number of times dice are rolled
        for (int i = 0; i < 37; i++) {
            // stores random int from 1-6 in count
            //int count = ThreadLocalRandom.current().nextInt(1, 7);
            int count = 0;
            // number of dice rolled
            for (int j = 0; j<numberOfDice; j++) {
                // adds the previous count to another random int (1-6) and updates the count
                count += ThreadLocalRandom.current().nextInt(1, numberOfSides+1);
            }
            // if count = 5, value is incremented by 1
            DiceFrequency.put(count, DiceFrequency.get(count)+1);
        }
        // prints values maxSum amount of times
        printValues(numberOfSides * numberOfDice);
    }
    // Sum: Frequency
    private void printValues(int maxSum) {
        // iterates through all sums that could be rolled
        for (int i=1; i<maxSum+1; i++) {
            // gets Sum, then puts it in variable number
            int number = DiceFrequency.get(i);
            // sets up Sum: Frequency output
            System.out.print(i + ": ");
            // puts * in Frequency, number amount of times
            for (int j=0; j<number; j++) {
                // prints one * for every time rolled
                System.out.print("*");
            }
            // makes new line
            System.out.println("");
        }
    }
}