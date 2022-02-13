package Dice;

public class d100 implements Dice {

    private int numberRolled = 0;

    public int rollDaDice() {
        numberRolled = (int) Math.ceil(Math.random() * 100 + 1);
        return numberRolled;
    }

    public int getNumRolled() {
        return numberRolled;
    }
}
