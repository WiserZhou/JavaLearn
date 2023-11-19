package Example;

class ToException {

  public static void main(String[] args) {
    int i = 0;
    String[] greetings = {"Hello world!", "No,I mena it!", "HELLO WORLD!!"};

    while (i < 4) {
      try {
        System.out.println(greetings[i]);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Resetting Index Value");
        i = -1;
      } catch (Exception e) {
        System.out.println(e.toString());
      } finally {
        System.out.println("This is always printed");
      }
      i++;
    }
  }
}

class MyException extends Exception {
  private int detail;

  MyException(int a) {
    detail = a;
  }

  /** 当对象被打印输出或作为字符串拼接时，会自动调用对象的 toString() 方法来获取其字符串表示形式。 */
  public String toString() {
    return "MyException[" + detail + "]";
  }
}

class ExceptionDemo {
  static void compute(int a) throws MyException {
    System.out.println("Called compute (" + a + ".");
    if (a > 10) throw new MyException(a);
    System.out.println("Normal exit");
  }

  public static void main(String[] args) {
    try {
      compute(1);
      compute(20);
    } catch (MyException e) {
      System.out.println("Exception caught " + e);
    }
  }
}


