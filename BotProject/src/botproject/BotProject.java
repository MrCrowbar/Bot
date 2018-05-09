/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botproject;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.MouseEvent;

/**
 *
 * @author crowbar
 */
public class BotProject {

    private static Robot myRobot = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            myRobot = new Robot();
        }
        catch(AWTException e){
            e.printStackTrace();
        }
        //for (int i = 0; i < 2; i++){
            klick();
        //}
    }
    public static void klick(){
        myRobot.delay(1000);
        myRobot.mouseMove(75,100);
        myRobot.mousePress(MouseEvent.BUTTON1_MASK);
        myRobot.delay(1000);
        myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
        
        myRobot.mouseMove(75,100);
        myRobot.mousePress(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
        myRobot.delay(1000);
        
        myRobot.mouseMove(75,140);
        myRobot.mousePress(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
        myRobot.delay(1000);
        
        myRobot.mouseMove(75,180);
        myRobot.mousePress(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
        myRobot.delay(1000);
        
        myRobot.mouseMove(75,220);
        myRobot.mousePress(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
        myRobot.delay(1000);
    }
    
}
