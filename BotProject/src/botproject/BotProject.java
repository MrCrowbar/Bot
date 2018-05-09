package botproject;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.MouseEvent;

public class BotProject {
    private static Robot myRobot = null;
    public static void main(String[] args) {
        try {
            myRobot = new Robot();
        }
        catch(AWTException e){
            e.printStackTrace();
        }
            klick();
    }
    
    public static void klick(){
        int cantY = 100;
        int cantX = 75;
        //Dar click para activar ventana
        myRobot.delay(1000);
        myRobot.mouseMove(75,100);
        myRobot.mousePress(MouseEvent.BUTTON1_MASK);
        myRobot.delay(1000);
        myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
        
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 5; j++){
                myRobot.mouseMove(cantX,cantY);
                myRobot.mousePress(MouseEvent.BUTTON1_MASK);
                myRobot.delay(500);
                myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
                myRobot.delay(1000);
                cantX+=40;
            }
            cantX = 75;
            cantY+= 40;
        }
    }
}
