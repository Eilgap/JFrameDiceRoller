
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
    //private Roller r = new Roller(); //This is what we'll call to roll dice
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
    private ActionListener d = new buttonPushes(); //This is what will listen for when our buttons are pressed
    private ArrayList<Integer> d4Vals = new ArrayList<Integer>(); //These ArrayLists are gonna hold the values of our rolled dice
    private ArrayList<Integer> d6Vals = new ArrayList<Integer>();
    private ArrayList<Integer> d8Vals = new ArrayList<Integer>();
    private ArrayList<Integer> d10Vals = new ArrayList<Integer>();
    private ArrayList<Integer> d12Vals = new ArrayList<Integer>();
    private ArrayList<Integer> d20Vals = new ArrayList<Integer>();
    private ArrayList<Integer> d100Vals = new ArrayList<Integer>();
    private ArrayList<Integer> rollAmounts = new ArrayList<Integer>();
    private static final int frameWidth = 225;
    private static final int frameHeight = 450;
    private static final int diceAreaWidth = 30;
    private int c = 0;

    /**
     * Constructor for objects of class RollWindow
     */
    public RollWindow()
    {
        //Where we'll initialize JFrame components
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);

        Collections.addAll(rollAmounts, 0, 0, 0, 0, 0, 0, 0);

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
        roll = new JButton("Roll the dice!");
        clear = new JButton("Clear");

        incD4.addActionListener(d);
        decD4.addActionListener(d);
        incD6.addActionListener(d);
        decD6.addActionListener(d);
        incD8.addActionListener(d);
        decD8.addActionListener(d);
        incD10.addActionListener(d);
        decD10.addActionListener(d);
        incD12.addActionListener(d);
        decD12.addActionListener(d);
        incD20.addActionListener(d);
        decD20.addActionListener(d);
        incD100.addActionListener(d);
        decD100.addActionListener(d);
        roll.addActionListener(d);
        clear.addActionListener(d);

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

        out = new JTextArea("", 8, 20);

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

    public class buttonPushes implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == roll)
            {
                int t = 0;
                int y = 0;
                while(t <= 6)
                {
                    if(rollAmounts.get(t) > 0)
                    {
                        y = 1;
                    }
                    t++;
                }
                if(y == 1)
                {
                    roller();

                    d4Vals.clear();
                    d6Vals.clear();
                    d8Vals.clear();
                    d10Vals.clear();
                    d12Vals.clear();
                    d20Vals.clear();
                    d100Vals.clear();
                }
            }
            if (e.getSource() == clear)
            {
                Collections.addAll(rollAmounts, 0, 0, 0, 0, 0, 0, 0);
                aD4.setText("0d4");
                aD6.setText("0d6");
                aD8.setText("0d8");
                aD10.setText("0d10");
                aD12.setText("0d12");
                aD20.setText("0d20");
                aD100.setText("0d100");
                mod.setText("");
                out.setText("");
                rollAmounts.clear();
                Collections.addAll(rollAmounts, 0, 0, 0, 0, 0, 0, 0);
            }
            if (e.getSource() == incD4)
            {
                rollAmounts.set(0, rollAmounts.get(0) + 1);
                aD4.setText(rollAmounts.get(0) + "d4");
            }
            if (e.getSource() == decD4 && rollAmounts.get(0) != 0)
            {
                rollAmounts.set(0, rollAmounts.get(0) - 1);
                aD4.setText(rollAmounts.get(0) + "d4");
            }
            if (e.getSource() == incD6)
            {
                rollAmounts.set(1, rollAmounts.get(1) + 1);
                aD6.setText(rollAmounts.get(1) + "d6");
            }
            if (e.getSource() == decD6 && rollAmounts.get(1) != 0)
            {
                rollAmounts.set(1, rollAmounts.get(1) - 1);
                aD6.setText(rollAmounts.get(1) + "d6");
            }
            if (e.getSource() == incD8)
            {
                rollAmounts.set(2, rollAmounts.get(2) + 1);
                aD8.setText(rollAmounts.get(2) + "d8");
            }
            if (e.getSource() == decD8 && rollAmounts.get(2) != 0)
            {
                rollAmounts.set(2, rollAmounts.get(2) - 1);
                aD8.setText(rollAmounts.get(2) + "d8");
            }
            if (e.getSource() == incD10)
            {
                rollAmounts.set(3, rollAmounts.get(3) + 1);
                aD10.setText(rollAmounts.get(3) + "d10");
            }
            if (e.getSource() == decD10 && rollAmounts.get(3) != 0)
            {
                rollAmounts.set(3, rollAmounts.get(3) - 1);
                aD10.setText(rollAmounts.get(3) + "d10");
            }
            if (e.getSource() == incD12)
            {
                rollAmounts.set(4, rollAmounts.get(4) + 1);
                aD12.setText(rollAmounts.get(4) + "d12");
            }
            if (e.getSource() == decD12 && rollAmounts.get(4) != 0)
            {
                rollAmounts.set(4, rollAmounts.get(4) - 1);
                aD12.setText(rollAmounts.get(4) + "d12");
            }
            if (e.getSource() == incD20)
            {
                rollAmounts.set(5, rollAmounts.get(5) + 1);
                aD20.setText(rollAmounts.get(5) + "d20");
            }
            if (e.getSource() == decD20 && rollAmounts.get(3) != 0)
            {
                rollAmounts.set(5, rollAmounts.get(5) - 1);
                aD20.setText(rollAmounts.get(5) + "d20");
            }
            if (e.getSource() == incD100)
            {
                rollAmounts.set(6, rollAmounts.get(6) + 1);
                aD100.setText(rollAmounts.get(6) + "d100");
            }
            if (e.getSource() == decD100 && rollAmounts.get(6) != 0)
            {
                rollAmounts.set(6, rollAmounts.get(6) - 1);
                aD100.setText(rollAmounts.get(6) + "d100");
            }
        }
    }

    public void roller()
    {
        out.setText("");
        Random r = new Random();
        c = 0;
        int total = 0;
        int total2 = 0;
        for(int i = 0; i < rollAmounts.get(0); i++)
        {
            d4Vals.add(r.nextInt(4) + 1);
        }
        for(int d : d4Vals)
            total += d;
        out.append(rollAmounts.get(0) + "D4 Total: " + total);
        total2 += total;
        total = 0;

        for(int i = 0; i < rollAmounts.get(1); i++)
        {
            d6Vals.add(r.nextInt(6) + 1);
        }
        for(int d : d6Vals)
            total += d;
        out.append("\n" + rollAmounts.get(1) + "D6 Total: " + total);
        total2 += total;
        total = 0;

        for(int i = 0; i < rollAmounts.get(2); i++)
        {
            d8Vals.add(r.nextInt(8) + 1);
        }
        for(int d : d8Vals)
            total += d;
        out.append("\n" + rollAmounts.get(2) + "D8 Total: " + total);
        total2 += total;
        total = 0;

        for(int i = 0; i < rollAmounts.get(3); i++)
        {
            d10Vals.add(r.nextInt(10) + 1);
        }
        for(int d : d10Vals)
            total += d;
        out.append("\n" + rollAmounts.get(3) + "D10 Total: " + total);
        total2 += total;
        total = 0;

        for(int i = 0; i < rollAmounts.get(4); i++)
        {
            d12Vals.add(r.nextInt(12) + 1);
        }
        for(int d : d12Vals)
            total += d;
        out.append("\n" + rollAmounts.get(4) + "D12 Total: " + total);
        total2 += total;
        total = 0;

        for(int i = 0; i < rollAmounts.get(5); i++)
        {
            d20Vals.add(r.nextInt(20) + 1);
        }
        for(int d : d20Vals)
            total += d;
        out.append("\n" + rollAmounts.get(5) + "D20 Total: " + total);
        total2 += total;
        total = 0;

        for(int i = 0; i < rollAmounts.get(6); i++)
        {
            d100Vals.add(r.nextInt(100) + 1);
        }
        for(int d : d100Vals)
            total += d;
        out.append("\n" + rollAmounts.get(6) + "D100 Total: " + total);
        total2 += total;
        total = 0;

        out.append("\nTotal for all rolled dice: " + total2);
    }
}
