package ExamTest2.program;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

  public static void main(String[] args) {
    // 指定服务器的IP地址和端口号
    String serverIP = "202.102.144.106";
    int serverPort = 5432;

    try {
      // 创建Socket对象，指定服务器的IP地址和端口号
      Socket socket = new Socket(serverIP, serverPort);
      System.out.println("连接服务器成功");

      // 创建DataInputStream和DataOutputStream对象
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

      // 发送10个整数给服务器
      for (int i = 1; i <= 10; i++) {
        dos.writeInt(i);
        System.out.println("发送整数: " + i);
      }

      // 接收服务器返回的最大整数
      int max = dis.readInt();
      System.out.println("接收到最大整数: " + max);

      // 关闭资源
      dis.close();
      dos.close();
      socket.close();

    } catch (IOException e) {
      System.out.println("客户端运行时出错: " + e.getMessage());
    }
  }
}
