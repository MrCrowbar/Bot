/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botproject;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;

/**
 *
 * @author crowbar
 */
//Ventana de runescape en 726
public class Thief {
    private static final int mouseX = 75;
    private static final int mouseY = 75;
    static Robot myRobot = null;
    
    Thief(){
        try{
        myRobot = new Robot();
        }
        catch(AWTException e){
            e.printStackTrace();
        }
    }
    
    public void steal(){
        Color thiefColor = myRobot.getPixelColor(155,260);
        //Robar
        while (thiefColor.getRed() < 50){
            myRobot.delay(1500);
            thiefColor = myRobot.getPixelColor(155,260);              
            clickIzq(440,420);            
        }
        //Comer
        /*for (int i = 0; i < 6; i++){
            for (int j = 0; j < 5; j++){
                eatCake(mouseX,mouseY);
                mouseX += 40;
            }
            mouseX = 75;
            mouseY += 40;
        }
*/
    }
    
    //Pararse en (385,420)
    public void runToBank(){
        clickIzq(630,700);
        myRobot.delay(10000);
        
        clickIzq(500,675);
        myRobot.delay(10000);
        
        clickIzq(535,603);
        myRobot.delay(13000);
        
        //clickIzq(330,475);
        //myRobot.delay(10000);        
    }
    
    //Pararse en (380,435)
    public void runToStall(){
        clickIzq(710,615);
        myRobot.delay(10000);
        
        clickIzq(660,505);
        myRobot.delay(10000);
        
        clickIzq(630,545);
        myRobot.delay(7000);
        
        clickIzq(550,455);
        myRobot.delay(2000);
    }
    
    public void bank(){
        int posX = 550;
        int posY = 215;
        Color bankColor;
        for (int k = 0; k < 4; k++){
            clickIzq(300,420);
            myRobot.delay(1000);
        }        
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 4; j++){
                bankColor = myRobot.getPixelColor(posX,posY);
                while (bankColor.getRed() > 50 || bankColor.getGreen() > 50 || bankColor.getBlue() > 50){
                    bankColor = myRobot.getPixelColor(posX,posY);
                    clickIzq(posX,posY);             
                }
                posX+=50;
            }
            posX = 550;
            posY+=35;
        }        
    }
    
    public static void clickIzq(int mouseX, int mouseY){
        myRobot.mouseMove(mouseX,mouseY);
        myRobot.mousePress(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        System.out.println("X: "+mouseX+" Y: "+mouseY);
    }
}
