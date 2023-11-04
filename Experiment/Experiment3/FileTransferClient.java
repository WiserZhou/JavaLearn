package Experiment.Experiment3;

import java.io.*;
import java.net.*;

public class FileTransferClient {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 8888);
    System.out.println("Connected to server.");

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = bufferedReader.readLine();

    OutputStream outputStream = socket.getOutputStream();
    PrintWriter printWriter = new PrintWriter(outputStream, true);
    printWriter.println(fileName);

    InputStream inputStream = socket.getInputStream();
    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
    String response = bufferedReader2.readLine();

    if (response.equals("FILE EXISTS")) {
      System.out.println("File exists on server. Do you want to download or upload? (D/U)");
      String action = bufferedReader.readLine();
      printWriter.println(action);
      if (action.equals("D")) {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
          fileOutputStream.write(buffer, 0, bytesRead);
        }
        fileOutputStream.close();
        System.out.println("File downloaded.");
      } else if (action.equals("U")) {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, bytesRead);
        }
        fileInputStream.close();
        System.out.println("File uploaded.");
      }
    } else if (response.equals("FILE NOT FOUND")) {
      System.out.println("File not found on server.");
    }

    socket.close();
    System.out.println("Connection closed.");
  }
}
