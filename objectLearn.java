public class objectLearn {
  String value;

  void setValue(String value) {
    this.value = value;
  }

  objectLearn(String value) {
    this.value = value;
  }

  public static void main(String[] args) {
    objectLearn objectLearn1 = new objectLearn("hhaha");
    objectLearn1.change(objectLearn1, "sa"); // 当对象作为值进行传递的时候，实际上传递的是对象的引用
    System.out.println(objectLearn1.value);
  }

  public void change(objectLearn objectLearn1, String string) {
    objectLearn1.setValue(string);
  }
}
