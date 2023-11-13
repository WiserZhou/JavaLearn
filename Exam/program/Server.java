package Exam.program;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(8080);
    System.out.println("waiting ...");
    Socket socket = serverSocket.accept();
    System.out.println("connected!");

    InputStream inputStream = socket.getInputStream();
    DataInputStream dataInputStream = new DataInputStream(inputStream);

    int sum = 0;
    while (dataInputStream.available() > 0) {
      int number = dataInputStream.readInt();
      sum += number;
    }

    System.out.println("calculated!");

    OutputStream outputStream = socket.getOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
    dataOutputStream.writeInt(sum);
    System.out.println("the data has been sent");

    dataOutputStream.close();
    dataInputStream.close();
    outputStream.close();
    inputStream.close();
  }
}
