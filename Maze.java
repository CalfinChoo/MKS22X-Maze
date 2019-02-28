import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public static String maze = "";
  public static char[][] charMaze;
  public Maze() {
    try {
      File text = new File("Mazel.txt");
      Scanner in = new Scanner(text);
      int rows = 0; int cols = 0;
      while(in.hasNextLine()) {
        String s = in.nextLine();
        maze += s + "\n";
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
  }
  public static void main(String[] args) {
    Maze m = new Maze();
    //System.out.print(m.maze);
    String s = "";
    for (char[] x : charMaze) {
      for (char y : x) {
        s += y;
      }
      s += "\n";
    }
    System.out.print(s);
  }
}
