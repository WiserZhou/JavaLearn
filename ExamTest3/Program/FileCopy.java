package ExamTest3.Program;

import java.io.*;

public class FileCopy {
  public static void main(String[] args) throws IOException {
    String sourcePath = "";
    String destinationPath = "";

    File sourceFile = new File(sourcePath);
    File destinationFile = new File(destinationPath);
    FileInputStream fileInputStream = new FileInputStream(sourcePath);
    FileOutputStream fileOutputStream = new FileOutputStream(destinationPath);

    byte[] buffer = new byte[1024];
    int bytesRead;

    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
      fileOutputStream.write(buffer, 0, bytesRead);
    }

    fileInputStream.close();
    fileOutputStream.close();
  }
}
