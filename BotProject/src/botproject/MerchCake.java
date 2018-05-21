/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botproject;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;

/**
 *
 * @author crowbar
 */
public class MerchCake {
    int mouseX = 75;
    int mouseY = 75;
    Robot myRobot = null;
    MerchCake(){
        try{
            myRobot = new Robot();            
        }
        catch(AWTException e){
            e.printStackTrace();
        }
    }
    
    public void biteCake(){
        clickIzq(mouseX,mouseY);
        myRobot.delay(500);
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 5; j++){
                myRobot.delay(500);
                clickIzq(mouseX,mouseY);
                mouseX += 40;
            }
            mouseX = 75;
            mouseY += 40;
        }
    }
    
     public void clickIzq(int mouseX, int mouseY){
        myRobot.mouseMove(mouseX,mouseY);
        myRobot.mousePress(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        //System.out.println("X: "+mouseX+" Y: "+mouseY);
    }
}
