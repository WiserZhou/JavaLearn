import java.io.*;
import java.util.Date;

public class ObjectStream {
  public static void main(String[] args) throws IOException {
    Date d = null;
    FileInputStream f = new FileInputStream("date.ser");
    ObjectInputStream s = new ObjectInputStream(f);
    try {
      d = (Date) s.readObject();
      s.close();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println("Date serialized at " + d);
  }
}
