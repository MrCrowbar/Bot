/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botproject;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.Robot;
import java.awt.AWTException;

/**
 *
 * @author crowbar
 */
public class Heal {
    private static final int HEAL_X = 250;
    private static final int HEAL_Y = 742;
    private static int mouseX = 75;
    private static int mouseY = 75;
    private Robot myRobot = null;
    Heal(){
        try{
            myRobot = new Robot();
        }
        catch(AWTException e){
            e.printStackTrace();
        }
    }
     public void Heal(int HEAL_X,int HEAL_Y){
        int countX = 0;
        int countY = 0;
        Color healthColor;
        clickIzq(mouseX,mouseY);
        while (countY < 6){
            healthColor = myRobot.getPixelColor(HEAL_X,HEAL_Y);
            if (healthColor.getRed() < 100){
                eatCake(mouseX,mouseY);        
                mouseX += 40;
                countX++;
                if (countX == 4){
                    countX = 0;
                    countY++;
                    mouseY += 40;
                    mouseX = 75;
                }            
            }
            System.out.println("CountX: "+countX+", CountY: "+countY);
            System.out.println("Rojo: " + healthColor.getRed());
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
     
    public void eatCake(int mouseX, int mouseY){
        for (int i = 0; i < 3; i++){
            clickIzq(mouseX,mouseY);
            myRobot.delay(1000);
        }
    }
    
    
}
