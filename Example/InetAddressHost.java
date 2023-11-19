package Example;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class InetAddressHost {
  public static void main(String[] args) throws IOException {
    InetAddress localHost = InetAddress.getLocalHost();
    System.out.println("本地主机IP地址：" + localHost.getHostAddress());

    String hostName = "www.baidu.com";
    InetAddress inetAddress = InetAddress.getByName(hostName);
    System.out.println("主机名：" + hostName);
    System.out.println("IP地址：" + inetAddress.getHostAddress());

    InetAddress[] allAddresses = InetAddress.getAllByName("localhost");
    for (InetAddress address : allAddresses) {
      System.out.println("IP的地址：" + address.getHostAddress());
    }

    //    inetAddress = InetAddress.getByName("www.baidu.com");
    //    boolean isReachable = inetAddress.isReachable(5000); // 5000毫秒超时时间
    //    if (isReachable) {
    //      System.out.println("IP地址可达");
    //    } else {
    //      System.out.println("IP地址不可达");
    //    }
    //
    //    inetAddress = InetAddress.getByName("192.168.0.1");
    //    hostName = inetAddress.getHostName();
    //    System.out.println("IP地址：" + inetAddress.getHostAddress());
    //    System.out.println("主机名：" + hostName);
    URL ur10 = new URL("http://news.hitwh.edu.cn");
    URL url = new URL(ur10, "/news_show.asp?id=17980");

    System.out.println("url=" + url);
    System.out.println("Protocol=" + url.getProtocol()); // 获取该URL的协议名
    System.out.println("Host=" + url.getHost()); // 获取该uRL的主机名
    System.out.println("Port=" + url.getPort()); // 获取该uRL的端口号
    System.out.println("File=" + url.getFile()); // 获取该uRL的文件名
    System.out.println("Ref=" + url.getRef()); // 获取该uRz在文件中的相对位
    System.out.println("Path=" + url.getPath()); // 获取该uRL的路径
    System.out.println("Authority=" + url.getAuthority()); // 获取该uRz的权限信息
    System.out.println("UserInfo=" + url.getUserInfo()); // 获得使用者的信息

    new InetAddressHost().SOCKET();
  }

  public void open() {
    try {
      URL url = new URL("https://www.hitwh.edu.cn");
      InputStreamReader isr = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8);
      BufferedReader br = new BufferedReader(isr);
      String readStr;
      while ((readStr = br.readLine()) != null) {
        System.out.println(readStr);
      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    new Thread(
            new Runnable() {
              @Override
              public void run() {}
            })
        .start();
  }

  public void SOCKET() throws IOException {

    // 创建一个Socket对象，指定服务端IP和端口号
    Socket socket = new Socket("localhost", 8080);

    // 获取输出流，向服务端发送数据
    OutputStream outputStream = socket.getOutputStream();
    outputStream.write("Hello, server!".getBytes());

    // 关闭输出流和Socket连接
    outputStream.close();
    socket.close();
  }
}
