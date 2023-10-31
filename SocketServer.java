import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
  public static void main(String[] args) throws IOException {
    // 创建一个ServerSocket对象，指定监听端口号
    ServerSocket serverSocket = new ServerSocket(8080);

    // 调用accept()方法，等待客户端连接
    Socket socket2 = serverSocket.accept();

    // 获取输入流，读取客户端发送的数据
    InputStream inputStream = socket2.getInputStream();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int len;
    while ((len = inputStream.read(buffer)) != -1) {
      baos.write(buffer, 0, len);
    }
    System.out.println("Received from client: " + baos.toString());

    // 关闭输入流、输出流和Socket连接
    inputStream.close();
    socket2.close();
    serverSocket.close();
  }
}
