
/**
 * 
 *
 * @author Logan Keim and Calvin Niewind
 * @version 0.01
 */
public class Roller
{

    private Dice dice;

    public void setDaDice(Dice d)
    {
        dice = d;
    }

    public Roller()
    {
        dice.rollDaDice();
    }
}
