package Dice;

public class d8 implements Dice {

    private int numberRolled = 0;

    @Overrride
    public int rollDaDice() {
        numberRolled = (int) Math.ceil(Math.random() * 8 + 1);
        return numberRolled;
    }

    public int getNumRolled() {
        return numberRolled;
    }
}
