package com.company;
import java.util.Random;
import java.awt.*;
import java.util.regex.Pattern;
import java.math.*;
public class Main {
    private static final Pattern checkIfParsable = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static int[][] Maze = new int[][]{
            {0, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1}
    };

    public static void main(String[] args) {
        gui GUI = new gui();
        boolean secondTry = false;
        long lastRatUpdate = System.currentTimeMillis();
        Cat cat = new Cat();
        cat.move();
        Rat rat = new Rat(0,8);
        rat.move(Maze, cat);
        // The array of equations for moving 0:N, 1:E, 2:S, 3:W, formatted as first addend, second addend
        int[][] equations = new int[][]{{2,3},{3,-3},{4,3},{5,5}};
        while(true){
            if (Maze[cat.xpos][cat.ypos] == 3){
                GUI.textArea.setText("You Win!");
            }
            long frameBegin = System.currentTimeMillis();
            for (int i = 0; i < Maze.length; i++) {
                for (int j = 0; j < Maze[0].length; j++) {
                    if (Maze[i][j] == 1) {
                        GUI.g.fillRect(i*24, j*24, 24,24);
                    }
                }
            }
            if (frameBegin - lastRatUpdate > 5000){
                lastRatUpdate = frameBegin;
                rat.move(Maze, cat);
            }
            for (int i = 0; i < 4; i++) {
                int dx = 0;
                int dy = 0;
                switch (i){
                    case 0:{
                        dy = -1;
                        break;
                    }
                    case 1:{
                        dx = 1;
                        break;
                    }
                    case 2:{
                        dy = 1;
                        break;
                    }
                    case 3:{
                        dx = -1;
                    }
                }
//                if (equations[i][1] >= 0){
//                    GUI.g.setColor(new Color(40, 100, 200));
//                    GUI.g.drawString((equations[i][0] + "+" + equations[i][1]), cat.xpos*24 + 27*dx - 5, cat.ypos*24 + 24*dy + 17);
//                }
//                else{
//                    GUI.g.setColor(new Color(40, 100, 200));
//                    GUI.g.drawString((equations[i][0] + "-" + Math.abs(equations[i][1])), cat.xpos*24 + 32*dx - 8, cat.ypos*24 + 24*dy + 16);
//                }
                int x = cat.xpos * 24 + 30 * dx - 1;
                int y = cat.ypos * 24 + 24 * dy + 16;
                String eq = equations[i][0] + (equations[i][1] >= 0 ? "+" : "-") + Math.abs(equations[i][1]);
                GUI.g.drawString(eq, x, y);
            }
            if (GUI.buttonPressed && checkIfParsable.matcher(GUI.textArea.getText()).matches() && GUI.textArea.getText() != null){
                for (int i = 0; i < 4; i++) {
                    if (equations[i][0] + equations[i][1] == Integer.parseInt(GUI.textArea.getText())){
                        switch (i){
                            case(0): {
                                if (cat.ypos-1 >= 0) {
                                    if (Maze[cat.xpos][cat.ypos - 1] != 1) {
                                        cat.ypos -= 1;
                                        cat.move();
                                        secondTry=false;
                                        equations = randomEquations();
                                    }
                                }
                                break;
                            }
                            case(1): {
                                if (cat.xpos+1 <= Maze.length) {
                                    if (Maze[cat.xpos + 1][cat.ypos] != 1) {
                                        cat.xpos += 1;
                                        cat.move();
                                        secondTry=false;
                                        equations = randomEquations();
                                    }
                                }
                                break;
                            }
                            case(2):{
                                if (cat.ypos+1 <= Maze.length) {
                                    if (Maze[cat.xpos][cat.ypos + 1] != 1) {
                                        cat.ypos += 1;
                                        cat.move();
                                        secondTry=false;
                                        equations = randomEquations();
                                    }
                                }
                                break;
                            }
                            case(3):{
                                if (cat.xpos-1 >= 0) {
                                    if (Maze[cat.xpos-1][cat.ypos] != 1) {
                                        cat.xpos -= 1;
                                        cat.move();
                                        secondTry=false;
                                        equations = randomEquations();
                                    }
                                }
                                break;
                            }
                            default:{
                                if(secondTry){
                                    equations = randomEquations();
                                    secondTry=false;
                                }
                                else{
                                    secondTry=true;
                                }
                            }
                        }
                    }
                }
                GUI.textArea.setText("");
                GUI.buttonPressed = false;
            }
            GUI.g.setColor(Color.blue);
            GUI.g.drawImage(cat.Catpic, cat.xpos*24, cat.ypos*24, 24, 24, null);
            GUI.g.setColor(Color.red);
            GUI.g.draw(rat.rec);
            GUI.update();
            if (cat.xpos == rat.xpos && cat.ypos == rat.ypos){
                GUI.textArea.setText("You Lose!");
            }
        }

    }
    public static int[][] randomEquations(){
        return new int[][]{generateEquation(), generateEquation(), generateEquation(), generateEquation()};
    }
    public static int[] generateEquation(){
        Random rand = new Random();

        int num1 = rand.nextInt(1,9);
        int num2 = rand.nextInt(-num1, num1);
        return new int[]{num1, num2};
    }
}
