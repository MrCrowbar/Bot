/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botproject;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author crowbar
 */
public class Miner {
    Robot myRobot = null;
    
    Miner(){
        try{
            myRobot = new Robot();
        }catch(AWTException e){
            e.printStackTrace();
        }
    }
    public void mineSand(int coordX, int coordY){
        int posX = 75;
        int posY = 110;
        byte count = 0;
        Color minerColor;
        minerColor = myRobot.getPixelColor(160, 288);
        if (minerColor.getRed() > 50){
            for (int i = 0; i < 6; i++){
                for (int j = 0; j < 5; j++){
                        clickIzq(posX,posY);
                        posX+=40;
                }
                posX = 75;
                posY+=35;
            }
            count = 1;
        }
        if (count == 1){
            clickIzq(coordX,coordY);//525,405
            count = 0;
        }
    }
    
    public void makeUrn(){
        int posX = 640;
        int posY = 215;
        Color minerColor = myRobot.getPixelColor(160,288);
        while (minerColor.getRed() < 50){
            myRobot.delay(2500);
            clickIzq(515,430);
            myRobot.delay(2500);
            clickIzq(460,465);
            minerColor = myRobot.getPixelColor(160,288);
        }
        clickIzq(800,670);
        myRobot.delay(7000);
        clickIzq(516,370);
        myRobot.delay(10000);
        clickIzq(910,650);
        myRobot.delay(15000);
        clickIzq(665,470);
        myRobot.delay(15000);
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 4; j++){
                clickIzq(posX,posY);
                myRobot.delay(1500);
                posX+=40;
            }
            posX = 640;
            posY += 35;
        }
        clickIzq(755,685);
        myRobot.delay(7000);
        clickIzq(385,717);
        myRobot.delay(7000);
        clickIzq(910,540);
        myRobot.delay(7000);
        clickIzq(463,550); //Ya le di click al minin
    }
    
    public void dropIron(Color minerColor){
        //Robar
        while (minerColor.getRed() > 50){
            myRobot.delay(500);
            minerColor = myRobot.getPixelColor(160,288);              
            //clickIzq(585,775);
            myRobot.keyPress(KeyEvent.VK_J);
            myRobot.delay(500);
            myRobot.keyRelease(KeyEvent.VK_J);
        }
    }
    
    public void clickIzq(int mouseX, int mouseY){
        myRobot.mouseMove(mouseX,mouseY);
        myRobot.mousePress(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        System.out.println("X: "+mouseX+" Y: "+mouseY);
    }
}
