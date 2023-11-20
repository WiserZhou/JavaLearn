package ExamTest2.reasoning;

public class Test3D {
  public static void main(String[] args) {
    M a = new M();
    a.f();
    N b = new N();
    b.f();
  }
}

abstract class P {
  P() {
    System.out.println("P");
  }

  void f() {
    System.out.println("P.f");
  }
}

class M extends P {
  M() {
    super();
  }

  void f() {
    System.out.println("M.f");
  }
}

class N extends P {}
