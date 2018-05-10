package botproject;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class BotProject {
    private static Robot myRobot = null;
    private static int healX = 250;
    private static int healY = 742;
    private static int mouseX = 75;
    private static int mouseY = 75;
    private static int thiefX = 430;
    private static int thiefY = 420;

    public static void main(String[] args) {
        try {
            myRobot = new Robot();
        }
        catch(AWTException e){
            e.printStackTrace();
        }
        //Heal(healX,healY);
        //Prayer();
        clickIzq(thiefX,thiefY);
        myRobot.delay(500);
        while (true)
            Thief(thiefX,thiefY,mouseX,mouseY);
        //Cake();
    }

    public static void Prayer(int mouseX, int mouseY){
        clickIzq(mouseX,mouseY);
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 5; j++){
                clickIzq(mouseX,mouseY);
                mouseX+=40;
            }
            mouseX = 75;
            mouseY += 40;
        }
    }
    public static void Thief(int thiefX, int thiefY, int mouseX, int mouseY){
        Color thiefColor = myRobot.getPixelColor(155,260);
        //Robar
        while (thiefColor.getRed() < 50){
            thiefColor = myRobot.getPixelColor(155,260);                
            clickIzq(thiefX,thiefY);
            myRobot.delay(1500);
        }
        //Comer
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 5; j++){
                eatCake(mouseX,mouseY);
                mouseX += 40;
            }
            mouseX = 75;
            mouseY += 40;
        }
    }
    public static void Bank(){
        clickIzq(510,690);
        clickIzq(545,670);
        clickIzq(300,415);
        
        clickDer(555,215);
        clickIzq(555,300);
    }
    public static void Heal(int healX,int healY){
        int countX = 0;
        int countY = 0;
        Color healthColor = myRobot.getPixelColor(healX, healY);
        clickIzq(mouseX,mouseY);
        while (countY < 6){
            healthColor = myRobot.getPixelColor(healX,healY);
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
    public static void eatCake(int mouseX,int mouseY){
        for (int k = 0; k < 3; k++){
            clickIzq(mouseX,mouseY);
            myRobot.delay(1000);
        }
    }
    
    public static void clickIzq(int mouseX, int mouseY){
        myRobot.mouseMove(mouseX,mouseY);
        myRobot.mousePress(MouseEvent.BUTTON1_MASK);
        myRobot.delay(500);
        myRobot.mouseRelease(MouseEvent.BUTTON1_MASK);
        myRobot.delay(1000);
    }
        public static void clickDer(int mouseX, int mouseY){
        myRobot.mouseMove(mouseX,mouseY);
        myRobot.mousePress(MouseEvent.BUTTON3_MASK);
        myRobot.delay(500);
        myRobot.mouseRelease(MouseEvent.BUTTON3_MASK);
        myRobot.delay(1000);
    }
}
