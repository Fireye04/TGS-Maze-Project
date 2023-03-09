
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


    public class DrawingMaze extends JPanel {
        int[][] drawingGrid;
        int gridSize = 20;

        public DrawingMaze(){
        }
        public DrawingMaze(int [][] mgrid){
            drawingGrid = mgrid;
        }


        public void paintComponent(Graphics g) {
            super.paintComponent(g);

                for(int i=0;i<drawingGrid.length;i++) {
                    for (int j = 0; j < drawingGrid[0].length; j++) {
                        int cell = drawingGrid[i][j];
                        if (cell == 0) {
                            g.setColor(Color.WHITE);
                        } else if(cell == 1) {
                            g.setColor(Color.BLACK);
                        }else if(cell ==2){
                            g.setColor(Color.RED);
                        }else{
                            g.setColor(Color.ORANGE);
                        }

                        g.fillRect(j * gridSize, i * gridSize, gridSize, gridSize);
                   }
                 }
        }


        public static void main(String[] args) {
                MazeGenerator maze = new MazeGenerator();
                JPanel panel  = new DrawingMaze(maze.getGrid());
                panel.setBackground(Color.GREEN.darker());
                JFrame frame = new JFrame("A simple graphics program");
                frame.setSize(900, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(panel, BorderLayout.CENTER);
                frame.setVisible(true);

        }
    }

