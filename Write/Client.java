package Write;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
  public static void main(String[] args) {
    String serverIP = "localhost";
    int serverPort = 5432;
    try {
      Socket socket = new Socket(serverIP, serverPort);
      System.out.println("连接服务器成功！");

      DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

      for (int i = 0; i < 10; i++) {
        dataOutputStream.writeInt(i);
        System.out.println("发送整数：" + i);
      }

      int max = dataInputStream.readInt();
      System.out.println("接收到最大整数： " + max);

      dataInputStream.close();
      dataOutputStream.close();
      socket.close();

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
  }
}
