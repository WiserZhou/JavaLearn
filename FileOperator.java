import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperator {
  public static void main(String[] args) {
    try {
      FileOutputStream out = new FileOutputStream("myFile.dat");
      out.write('H');
      out.write('e');
      out.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for writing");
    } catch (IOException e) {
      System.out.println("Error: Cannot write to file");
    }
  }
}
