import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public static String maze = "";
  public Maze() {
    try {
      File text = new File("Mazel.txt");
      Scanner in = new Scanner(text);
      while(in.hasNextLine()) {
        maze += in.nextLine() + "\n";
      }
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    Maze m = new Maze();
    System.out.print(m.maze);
  }
}
