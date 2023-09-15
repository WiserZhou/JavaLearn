public class Extends extends dateLearn {

  private String day;

  public Extends(String day) {}

  public void hello() {
    this.day = "1";
    System.out.println("hello2");
    super.hello();
  }

  public static void main(String[] args) {
    Extends ex = new Extends("hello");
    System.out.println(ex.getClass());
    System.out.println(ex.toString());
    System.out.println(ex instanceof dateLearn);
    ex.hello();
  }
}
