import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  //public String maze = "";
  private char[][] maze;
  private boolean animate;
  private int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private int steps;

  /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
         throw a FileNotFoundException or IllegalStateException
    */
    public Maze(String filename) throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR
        try {
          File text = new File(filename);
          Scanner in = new Scanner(text);
          int rows = 0; int cols = 0;
          while(in.hasNextLine()) {
            String s = in.nextLine();
            //maze += s + "\n";
            rows++;
            cols = s.length();
          }
          maze = new char[rows][cols];
          Scanner inC = new Scanner(text);
          int countRow = 0;
          while(inC.hasNextLine()) {
            String s = inC.nextLine();
            for (int i = 0; i < s.length(); i++) {
              maze[countRow][i] = s.charAt(i);
            }
            countRow++;
          }
          steps = -1;
        } catch(FileNotFoundException e) {
          e.printStackTrace();
        }
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }





   /*Return the string that represents the maze.
     It should look like the text file with some characters replaced.
    */
    public String toString(){
      String s = "";
      for (int y = 0; y < maze.length; y++) {
        for (int x = 0; x < maze[y].length; x++) {
          //if (maze[y][x] == 'S') s += '@';
          if (maze[y][x] == '.') s += ' ';
          else s += maze[y][x];
        }
        s += "\n";
      }
      return s;
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
      int row = 0; int col = 0;
      for (int r = 0; r < maze.length; r++) {
        for (int c = 0; c < maze[r].length; c++) {
          if (maze[r][c] == 'S') {
            //maze[r][c] = '@';
            row = r; col = c;
          }
        }
      }
      return solve(row, col, 0);
            //find the location of the S.

            //erase the S

            //and start solving at the location of the s.
            //return solve(???,???);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int countSteps){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
          if (maze[row][col] == 'E') steps = countSteps;
          else {
            maze[row][col] = '@';
            for (int i = 0; i < moves.length; i++) {
              int r = row + moves[i][0];
              int c = col + moves[i][1];
              if (r >= 0 && r < maze.length && c >= 0 && c < maze[r].length) {
                if (maze[r][c] != '#' && maze[r][c] != '.' && maze[r][c] != '@' && steps == -1) {
                  solve(r, c, countSteps + 1);
                }
              }
            }
            if (steps == -1) maze[row][col] = '.';
          }
          return steps;
    }

}

  // public static void main(String[] args) {
  //   Maze m = new Maze();
  //   //System.out.print(m.maze);
  //   String s = "";
  //   for (char[] x : charMaze) {
  //     for (char y : x) {
  //       s += y;
  //     }
  //     s += "\n";
  //   }
  //   System.out.print(s);
  // }
  //}
