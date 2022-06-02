package Dice;

public class d12 implements Dice {

    private int numberRolled = 0;

    @Overrride
    public int rollDaDice() {
        numberRolled = (int) Math.ceil(Math.random() * 12 + 1);
        return numberRolled;
    }

    public int getNumRolled() {
        return numberRolled;
    }
}
