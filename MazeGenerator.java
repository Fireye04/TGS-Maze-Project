import java.util.ArrayList;
public class MazeGenerator {
    private int cols = 45;
    private int rows = 30;
    private int gridSize = 20;
    private int [][] grid = new int[rows][cols];
    int stage = 0;
    ArrayList<Integer> history = new ArrayList();


    public MazeGenerator(){
        initGrid();
        createSolution(10,10);
        loopNumber = loopNumber - 20;//reset loops for drawing fake paths
        stage = stage +2; //changes the color
        drawDecoys();


    }
    public void drawDecoys(){
        int rx = 3*history.size()/4;
        int node = history.get((int) (Math.random() * rx));

        int rc = node / 45;
        int cc = node % 45;

        createSolution(cc,rc);

    }

    public void initGrid(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                grid[i][j]=0;
            }
        }
    }
    private int loopNumber = 0;
    int min = rows * cols / 20;  // five percent of board
    int max = rows * cols / 5;  //twenty percent of board
    int loopMax = min +(int)(Math.random()*max);
    int previous = 0;
    int lastLoop = 0;
    int stuckLoop = 0;

    public void createSolution(int c,int r) {
        if(loopNumber==lastLoop){
            stuckLoop++;
            if(stuckLoop == 50){
                stuckLoop = 0;
                loopNumber = loopMax;
            }
        }else{
            lastLoop = loopNumber;
        }
        System.out.println(loopNumber+"  "+loopMax);
        if(grid[c][r]==0){
            grid[c][r] = 1+stage;
            history.add(r*45+c);
            loopNumber++;
        }
        int ran = (int) (Math.random() * 12);

        if(ran>3){ran = previous;}
        previous = ran;
        int dx = 0;
        int dy = 0;

        switch(ran){
            case 0:
                dy = -1;
                break;
            case 1:
                dx =  1;
                break;
            case 2:
                dy = 1;
                break;
            case 3:
                dx = -1;
                break;
        }
        int newX = r + dy;
        int newY = c + dx;

        if(newX<0){newX = 1;}
        if(newY<0){newY = 1;}
        if(newX>=cols){newX = cols - 1;}
        if(newY >= rows){newY = rows - 1;}

        if(loopNumber < loopMax){
            if(grid[newY][newX]==0) {
                createSolution(newY, newX);

            }
            else{
                int rx = history.size();
                int node = history.get((int) (Math.random() * rx));

                if(rx>1) {
                    node = history.remove((int) (Math.random() * rx));
                }

                int rc = node / 45;
                int cc = node % 45;

                createSolution(cc,rc);

            }
        }else {
            grid[c][r] = 2;
        }
    }

    public void drawGrid(){
        for(int[] r : grid){
            for(int c : r){
               // System.out.print(c);
            }
            //System.out.println();
        }
    }
    public int[][] getGrid(){
        return grid;
    }
    public static void  main(String[] args){
        MazeGenerator one = new MazeGenerator();
    }
}
