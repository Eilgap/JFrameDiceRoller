
/**
 * RollWindow creates a JFrame object with JButtons for rolling different
 * dice and JTextAreas for displaying results. Will call Roller to
 * determine random numbers
 *
 * @author Logan Keim and Calvin Niewind
 * @version 0.01
 */

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Color;

public class RollWindow extends JFrame
{
    //Where we'll start all the JFrame components, a Roller, and any necessary variables
    private Roller r = new Roller(); //This is what we'll call to roll dice
    private JButton incD4, decD4, //The buttons that will increment and decrement each set 
                    incD6, decD6,
                    incD8, decD8,
                    incD10, decD10,
                    incD12, decD12,
                    incD20, decD20,
                    incD100, decD100,
                    roll, //This will roll all dice
                    clear; //This will clear and reset all fields
    private JLabel lD4, lD6, lD8, lD10, lD12, lD20, lD100; //These are gonna label which buttons go to which dice
    private JTextField mod; //Any modifiers that'll be added to the roll
    private JTextArea aD4, aD6, aD8, aD10, aD12, aD20, aD100, //These are where the window will display how many of each die are gonna be rolled
                      out; //This is where I imagined we'd output the results of the rolls
    private ActionListener d; //This is what will listen for when our buttons are pressed
    private ArrayList<Integer> d4Vals = new ArrayList<Integer>(); //These ArrayLists are gonna hold the values of our rolled dice
    private ArrayList<Integer> d6Vals = new ArrayList<Integer>();
    private ArrayList<Integer> d8Vals = new ArrayList<Integer>();
    private ArrayList<Integer> d10Vals = new ArrayList<Integer>();
    private ArrayList<Integer> d12Vals = new ArrayList<Integer>();
    private ArrayList<Integer> d20Vals = new ArrayList<Integer>();
    private ArrayList<Integer> d100Vals = new ArrayList<Integer>();
    private static final int frameWidth = 225;
    private static final int frameHeight = 450;
    private static final int diceAreaWidth = 30;

    /**
     * Constructor for objects of class RollWindow
     */
    public RollWindow()
    {
        //Where we'll initialize JFrame components
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        incD4 = new JButton("+");
        incD6 = new JButton("+");
        incD8 = new JButton("+");
        incD10 = new JButton("+");
        incD12 = new JButton("+");
        incD20 = new JButton("+");
        incD100 = new JButton("+");
        decD4 = new JButton("-");
        decD6 = new JButton("-");
        decD8 = new JButton("-");
        decD10 = new JButton("-");
        decD12 = new JButton("-");
        decD20 = new JButton("-");
        decD100 = new JButton("-");
        roll = new JButton("Roll da dice!");
        clear = new JButton("Clear");

        lD4 = new JLabel("D4: ");
        lD6 = new JLabel("D6: ");
        lD8 = new JLabel("D8: ");
        lD10 = new JLabel("D10: ");
        lD12 = new JLabel("D12: ");
        lD20 = new JLabel("D20: ");
        lD100 = new JLabel("D100: ");

        aD4 = new JTextArea("0d4", 1, 7);
        aD6 = new JTextArea("0d6", 1, 7);
        aD8 = new JTextArea("0d8", 1, 7);
        aD10 = new JTextArea("0d10", 1, 7);
        aD12 = new JTextArea("0d12", 1, 7);
        aD20 = new JTextArea("0d20", 1, 7);
        aD100 = new JTextArea("0d100", 1, 7);

        mod = new JTextField(20);

        out = new JTextArea("", 8, 15);

        panel.add(lD4);
        panel.add(aD4);
        panel.add(incD4);
        panel.add(decD4);

        panel.add(lD6);
        panel.add(aD6);
        panel.add(incD6);
        panel.add(decD6);

        panel.add(lD8);
        panel.add(aD8);
        panel.add(incD8);
        panel.add(decD8);

        panel.add(lD10);
        panel.add(aD10);
        panel.add(incD10);
        panel.add(decD10);

        panel.add(lD12);
        panel.add(aD12);
        panel.add(incD12);
        panel.add(decD12);

        panel.add(lD20);
        panel.add(aD20);
        panel.add(incD20);
        panel.add(decD20);

        panel.add(lD100);
        panel.add(aD100);
        panel.add(incD100);
        panel.add(decD100);

        panel.add(mod);
        panel.add(roll);
        panel.add(clear);

        panel.add(out);

        add(panel);

        setSize(frameWidth, frameHeight);
    }
}
