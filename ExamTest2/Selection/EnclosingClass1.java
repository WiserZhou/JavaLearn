package ExamTest2.Selection;

public class EnclosingClass1 {
  int id;
  String name;
  static int counter = 0;

  public EnclosingClass1(int id, String name) {
    this.id = id;
    this.name = name;
    counter++;
  }

  public void print() {
    MemberClass mc = new MemberClass(); // Create an instance of static member class internally
    System.out.println("id=" + id + ", name=" + name);
    mc.print();
  }

  // Static member class
  static class MemberClass {
    String name;


    public void print() {
      //System.out.println("id=" + id + ", name=" + EnclosingClass1.this.name);
      // Access the non-static member variable of the enclosing class
      // It seems like there's a commented line of code that's incomplete.

      System.out.println("counter=" + counter);
    }
  }

  public static void main(String[] args) {
    EnclosingClass1 ec1 = new EnclosingClass1(1, "Tom");
    ec1.print();

    EnclosingClass1 ec2 = new EnclosingClass1(2, "John");
    ec2.print();

    EnclosingClass1 ec3 = new EnclosingClass1(3, "Dora");

    EnclosingClass1.MemberClass mc =
        new EnclosingClass1.MemberClass(); // Create an instance of static member class externally
    mc.print();
  }
}
