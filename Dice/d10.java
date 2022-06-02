package Dice;

public class d10 implements Dice {

    private int numberRolled = 0;

    @Override
    public int rollDaDice() {
        numberRolled = (int) Math.ceil(Math.random() * 10 + 1);
        return numberRolled;
    }

    public int getNumRolled() {
        return numberRolled;
    }
}
