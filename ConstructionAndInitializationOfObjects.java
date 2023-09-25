import java.util.Date;

public class ConstructionAndInitializationOfObjects {
  private int x = 5;
  private String name = "Fred";
  private Date created = new Date();

  ConstructionAndInitializationOfObjects(int x, String name, Date created) {
    this.x = x;
    this.name = name;
    this.created = created;
  }

  ConstructionAndInitializationOfObjects(String name) {
    this(1, name, null);
  }

  public static void main(String[] args) {
    Data data = new Data();
    String str = data.s2;
  }
}

final class Data {
  int s1;
  final String s2 = "Hello!";

  Data() {}

  final void getS1() {}

  final Integer getS2() {
    return 1;
  }
}
