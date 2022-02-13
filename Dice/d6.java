package Dice;

public class d6 implements Dice {

    private int numberRolled = 0;

    public int rollDaDice() {
        numberRolled = (int) Math.ceil(Math.random() * 6 + 1);
        return numberRolled;
    }

    public int getNumRolled() {
        return numberRolled;
    }
}
