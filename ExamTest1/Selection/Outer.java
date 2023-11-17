package ExamTest1.Selection;

public class Outer {//外部类

  public static void main(String[] args) {

    /**
     * 底层会分配一个类名Outer$1,去实现Inner接口
     * class Outer$1 implements Inner {
     *             @Override
     *             public void innerFun1() {
     *                 System.out.println("实现接口Inner，匿名内部类方法innerFun1()");
     *             }
     *         }
     */
    Inner inner = new Inner(){
      @Override
      public void innerFun1() {
        System.out.println("实现接口Inner，匿名内部类方法innerFun1()");
      }
    };
    System.out.println(inner);
    inner.innerFun1();

    /**
     * 底层会分配一个类名Outer$2，去继承InnerClass
     * class Outer$1 extends InnerClass {
     *             @Override
     *             public void innerFun1() {
     *                 System.out.println("匿名类继承了 InnerClass 类，匿名内部类方法innerFun1()");
     *             }
     *         }
     */
    Inner inner2 = new InnerClass(){
      @Override
      public void innerFun1() {
        System.out.println("匿名类继承了 InnerClass 类，匿名内部类方法innerFun1()");
      }
    };
    System.out.println(inner2);
    inner2.innerFun1();
  }
}
