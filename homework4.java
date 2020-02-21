import java.util.Hashtable;
public class homework4 {
    public static void main(String args[]) {
        // Dice == calling the constructor
        DiceRoller Dice = new DiceRoller(6, 2);
        // does the actual rolling of the die
        Dice.rollDice(6, 2);
    }
}