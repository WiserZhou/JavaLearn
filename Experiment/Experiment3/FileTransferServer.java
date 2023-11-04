package Experiment.Experiment3;

import java.io.*;
import java.net.*;

public class FileTransferServer {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("Server started.");

    while (true) {
      Socket clientSocket = serverSocket.accept();
      System.out.println("Client connected.");

      InputStream inputStream = clientSocket.getInputStream();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String fileName = bufferedReader.readLine();
      System.out.println("File name: " + fileName);

      OutputStream outputStream = clientSocket.getOutputStream();
      PrintWriter printWriter = new PrintWriter(outputStream, true);

      File file = new File(fileName);
      if (file.exists()) {
        printWriter.println("FILE EXISTS");
        System.out.println("File exists.");
      } else {
        printWriter.println("FILE NOT FOUND");
        System.out.println("File not found.");
      }

      String action = bufferedReader.readLine();
      if (action.equals("DOWNLOAD")) {
        if (file.exists()) {
          FileInputStream fileInputStream = new FileInputStream(file);
          byte[] buffer = new byte[1024];
          int bytesRead;
          while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
          }
          fileInputStream.close();
          System.out.println("File sent.");
        }
      } else if (action.equals("UPLOAD")) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
          fileOutputStream.write(buffer, 0, bytesRead);
        }
        fileOutputStream.close();
        System.out.println("File received.");
      }

      clientSocket.close();
      System.out.println("Client disconnected.");
    }
  }
}
