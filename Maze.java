import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  //public String maze = "";
  private char[][] maze;
  private boolean animate;

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
            //String s = in.nextLine();
            //maze += s + "\n";
            rows++;
            cols = s.length();
          }
          charMaze = new char[rows][cols];
          Scanner inC = new Scanner(text);
          int countRow = 0;
          while(inC.hasNextLine()) {
            String s = inC.nextLine();
            for (int i = 0; i < s.length(); i++) {
              charMaze[countRow][i] = s.charAt(i);
            }
            countRow++;
          }
        } catch(FileNotFoundException e) {
          e.printStackTrace();
        }
        setAnimate();
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
      for (int y = 0; x < char)
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
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
    private int solve(int row, int col){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        return -1; //so it compiles
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
}
