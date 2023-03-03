package tgs.maze.project;

import java.util.ArrayList;

public class Game {

    ArrayList<Integer> idList = new ArrayList<Integer>() {{
        add(1);
    }};

    public int[][] getLocation(int id) {
        return [[1,2],[2,3],[3,4]];
    }
}
