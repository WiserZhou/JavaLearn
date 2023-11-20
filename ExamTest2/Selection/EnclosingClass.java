package ExamTest2.Selection;

public class EnclosingClass {
  int id;
  String name;
  static int counter = 0;

  public EnclosingClass(int id, String name) {
    this.id = id;
    this.name = name;
    counter++;
  }

  public void print() {
    // Create an instance of the non-static member class internally
    MemberClass mc = new MemberClass();
    mc.print();
  }

  // Non-static member class
  class MemberClass {
    String name;

    public void print() {
      System.out.println(
          "id="
              + id
              + ", name="
              + EnclosingClass.this
                  .name); // Access the non-static member variable of the enclosing class
      System.out.println(
          "counter=" + counter); // Access the static member variable of the enclosing class
    }
  }

  public static void main(String[] args) {
    EnclosingClass ec1 = new EnclosingClass(1, "Tom");
    ec1.print();

    EnclosingClass ec2 = new EnclosingClass(2, "John");
    ec2.print();

    EnclosingClass ec3 = new EnclosingClass(3, "Dora");

    EnclosingClass.MemberClass mc = ec3.new MemberClass(); // Create an instance of the non-static member class externally

    mc.print();
  }
}
