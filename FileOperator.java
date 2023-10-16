import java.io.*;

public class FileOperator {
  public static void main(String[] args) {
    try {
      FileInputStream in = new FileInputStream("myFile.dat");
      while (in.available() > 0) {
        System.out.println((char)in.read() + " ");
      }
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for reading");
    } catch (EOFException e) {
      System.out.println("Error:EOF encountered ,file may be corrupted");
    } catch (IOException e) {
      System.out.println("Error: Cannot read from file");
    }
  }

  public static void main3(String[] args) {
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
