import java.io.FileNotFoundException;
public class Driver {
  public static void main(String[] args) {
    try {
      Maze test = new Maze("Mazel.txt");
      System.out.print(test.toString());
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
