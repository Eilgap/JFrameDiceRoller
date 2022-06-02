package Dice;

public class d4 implements Dice {

    private int numberRolled = 0;

    @Override
    public int rollDaDice() {
        numberRolled = (int) Math.ceil(Math.random() * 4 + 1);
        return numberRolled;
    }

    public int getNumRolled() {
        return numberRolled;
    }
}
