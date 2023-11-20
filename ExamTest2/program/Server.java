package ExamTest2.program;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) {
    // 指定服务器端口号
    int port = 5432;

    try {
      // 创建ServerSocket对象，并监听指定端口
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("服务器正在监听端口 " + port);

      // 等待客户端连接
      Socket socket = serverSocket.accept();
      System.out.println("客户端已连接");

      // 创建DataInputStream和DataOutputStream对象
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

      // 接收客户端发送的10个整数
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < 10; i++) {
        int num = dis.readInt();
        System.out.println("接收到整数: " + num);

        if (num > max) {
          max = num;
        }
      }

      // 将最大整数发送给客户端
      dos.writeInt(max);
      System.out.println("发送最大整数: " + max);

      // 关闭资源
      dis.close();
      dos.close();
      socket.close();
      serverSocket.close();

    } catch (IOException e) {
      System.out.println("服务器运行时出错: " + e.getMessage());
    }
  }
}
