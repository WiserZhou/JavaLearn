package Write;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    int port = 5432;
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("服务器正在监听端口：" + port);

      Socket socket = serverSocket.accept();
      System.out.println("客户端已连接");

      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
      DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

      int max = Integer.MIN_VALUE;
      for (int i = 0; i < 10; i++) {
        int num = dataInputStream.readInt();
        System.out.println("接收到整数：" + num);

        if (num > max) max = num;
      }

      dataOutputStream.writeInt(max);
      System.out.println("已选出最大的整数：" + max);

      dataInputStream.close();
      dataOutputStream.close();
      socket.close();
      serverSocket.close();

    } catch (IOException e) {
      System.out.println("服务器运行时报错：" + e.getMessage());
    }
  }
}
