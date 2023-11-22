package Write;

import java.io.*;

public class Read {
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
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
