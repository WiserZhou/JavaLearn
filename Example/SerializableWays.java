package Example;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableWays implements Serializable {
  int id;
  String name;
  int age;
  String department;

  public SerializableWays(int id, String name, int age, String department) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.department = department;
  }

  public static void main(String[] args) {
    SerializableWays stu = new SerializableWays(981036, "Li Ming", 16, "CSD");
    try {
      FileOutputStream fo = new FileOutputStream("Example/data.ser");
      ObjectOutputStream so = new ObjectOutputStream(fo);
      so.writeObject(stu);
      so.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
