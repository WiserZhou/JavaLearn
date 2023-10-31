import java.io.IOException;
import java.net.InetAddress;

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

    inetAddress = InetAddress.getByName("www.baidu.com");
    boolean isReachable = inetAddress.isReachable(5000); // 5000毫秒超时时间
    if (isReachable) {
      System.out.println("IP地址可达");
    } else {
      System.out.println("IP地址不可达");
    }

    inetAddress = InetAddress.getByName("192.168.0.1");
    hostName = inetAddress.getHostName();
    System.out.println("IP地址：" + inetAddress.getHostAddress());
    System.out.println("主机名：" + hostName);
  }
}
