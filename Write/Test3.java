package Write;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class Test3 {
  public static void main(String[] args) {
    String filePath = "";
    try {
      FileReader fileReader = new FileReader(filePath);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }
      bufferedReader.close();
      fileReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
