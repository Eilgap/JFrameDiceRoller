package Dice;

public class d20 implements Dice {

    private int numberRolled = 0;

    @Overrride
    public int rollDaDice() {
        numberRolled = (int) Math.ceil(Math.random() * 20 + 1);
        return numberRolled;
    }

    public int getNumRolled() {
        return numberRolled;
    }
}
