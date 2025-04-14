package com.company;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Rat {

    public String name;
    public int xpos;                //the x position
    public int ypos;                //the y position
    public Image Ratpic;
    public int width;
    public int height;
    public Rectangle rec;

    public Rat(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;

        width = 24;
        height = 24;

        Ratpic = Toolkit.getDefaultToolkit().getImage("Image/ratimage.png");

    } // constructor

    private static final int[] ROW_DIRS = {-1, 1, 0, 0};
    private static final int[] COL_DIRS = {0, 0, -1, 1};
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static List<int[]> findPath(int[][] grid, int startX, int startY, int endX, int endY) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if (currentX == endX && currentY == endY) {
                return reconstructPath(parentMap, new int[]{endX, endY});
            }

            for (int i = 0; i < ROW_DIRS.length; i++) {
                int newX = currentX + ROW_DIRS[i];
                int newY = currentY + COL_DIRS[i];

                if (isValid(newX, newY, grid, visited)) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    parentMap.put(Arrays.toString(new int[]{newX, newY}), Arrays.toString(new int[]{currentX, currentY}));
                }
            }
        }

        return Collections.emptyList();
    }

    private static boolean isValid(int x, int y, int[][] grid, boolean[][] visited) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0 && !visited[x][y];
    }

    private static List<int[]> reconstructPath(Map<String, String> parentMap, int[] endNode) {
        List<int[]> path = new ArrayList<>();
        String current = Arrays.toString(endNode);

        while (parentMap.containsKey(current)) {
            String parent = parentMap.get(current);
            int[] parentCoords = parseArrayString(parent);
            int[] currentCoords = parseArrayString(current);
            path.add(new int[]{currentCoords[0] - parentCoords[0], currentCoords[1] - parentCoords[1]});
            current = parent;
        }

        Collections.reverse(path);
        return path;
    }

    private static int[] parseArrayString(String s) {
        String[] parts = s.replace("[", "").replace("]", "").replace(" ", "").split(",");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }

    public void move(int[][] maze, Cat cat) {
        List<int[]> path = findPath(maze, xpos, ypos, cat.xpos, cat.ypos);

        if (!path.isEmpty()) {
            xpos += path.get(0)[0];
            ypos += path.get(0)[1];
        }

        rec = new Rectangle(xpos * 24, ypos * 24, width, height);
    }
}
