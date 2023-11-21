package Write;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    String serverIP = "202.102.144.106";
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

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
