package com.company;
import java.awt.*;
public class Cat {
    public int xpos;
    public int ypos;
    public String name;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;
    public Image Catpic;


    public Cat(){
        xpos = 22;
        ypos = 23;
        width = 24;
        height = 24;
        isAlive = true;
        Catpic = Toolkit.getDefaultToolkit().getImage("Image/Cat.png");
    }



    public void move(){
        rec = new Rectangle(xpos*24,ypos*24,width,height);
    }
}
