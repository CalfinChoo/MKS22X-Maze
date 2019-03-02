import java.io.FileNotFoundException;
// public class Driver {
//   public static void main(String[] args) {
//     try {
//       Maze test = new Maze("Mazel.txt");
//       test.setAnimate(true);
//       //test.solve();
//       System.out.println(test.solve());
//       System.out.print(test.toString());
//     } catch(FileNotFoundException e) {
//       e.printStackTrace();
//     }
//   }
// }
public class Driver{
    public static void main(String[]args){
      String filename = "data3.dat";
      try{
        Maze f;
        f = new Maze(filename);//true animates the maze.

        f.setAnimate(true);
        int s = f.solve();
        System.out.println("Steps: " + s);
        System.out.println(f);
      }catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename);
      }
    }
}
