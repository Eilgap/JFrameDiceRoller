/**
 * This class creates a RollWindow object and displays it
 *
 * @authors Logan Keim & Calvin Niewind
 * @version 1.0
 */

import javax.swing.*;
public class WindowViewer
{
    public static void main(String[] args)
   {
      RollWindow frame = new RollWindow();      //Creates RollWindow object named frame
      frame.setTitle("Dice Roller Program");    //Sets title of RollWindow object
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets RollWindow object to automatically close when the x button is pressed
      frame.setVisible(true);                   //Makes the RollWindow object visible
   }
}
