package com.company;
import java.awt.*;

public class Rat {

    public String name;
    public int xpos;                //the x position
    public int ypos;                //the y position

    public int width;
    public int height;
    public Rectangle rec;
            //a boolean to denote if the hero is alive or dead.




    public Rat(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;

        width = 24;
        height = 24;


    } // constructor

    private int[] pathfind(int[][] maze){
        return new int[]{0, 1};
    }

    public void move(int[][] maze) {
        int[] moveVector = pathfind(maze);
        xpos += moveVector[0];
        ypos += moveVector[1];
        rec = new Rectangle(xpos*24,ypos*24,width,height);
    }
}
