package Exam.program;

import java.io.*;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 8080);

    OutputStream outputStream = socket.getOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

    int[] arrayInt = {1, 2, 3, 4, 5};
    for (int i : arrayInt) {
      dataOutputStream.writeInt(i);
    }

    dataOutputStream.flush();

    InputStream inputStream = socket.getInputStream();
    DataInputStream dataInputStream = new DataInputStream(inputStream);

    System.out.println(dataInputStream.readInt());

    dataOutputStream.close();
    outputStream.close();
    inputStream.close();
    dataOutputStream.close();
  }
}
