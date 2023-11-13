# 1

```java
public class Test3A {
    public static void main(String[] args) {
        int i, j;
        outer:
        for (i = 1; i < 4; i++) {
            inner:
            for (j = 1; j < 4; j++) {
                if (j == 2) {
                    continue outer;
                }
                System.out.println("i=" + i + ",j=" + j);
            }
        }
    }
}

```

程序运行结果为

```
i=1,j=1
i=2,j=1
i=3,j=1
```

在Java中，标签（Label）是为了在嵌套的循环或代码块中跳转或标记特定位置而使用的标识符。它们通常与break和continue语句一起使用。

标签由标识符和冒号组成，放置在循环、代码块或语句前面。例如：

```
labelName: for (int i = 0; i < 10; i++) {
    // 循环体
    if (condition) {
        break labelName; // 使用标签进行跳出循环
    }
}
```

在上面的例子中，labelName是一个标签，它被放置在for循环前面。当满足某个条件时，可以使用break语句结合标签来跳出循环。

标签还可以与continue语句一起使用，在内部循环中跳过当前迭代，并继续下一次迭代。

```
labelName: for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (someCondition) {
            continue labelName; // 使用标签进行循环跳过
        }
    }
}
```

在上述示例中，当满足某个条件时，使用continue语句结合标签labelName，可以跳过内部循环的当前迭代，并开始下一次外部循环的迭代。

请注意，标签的命名应遵循Java的命名规范，以字母开头，只包含字母、数字和下划线，并且需要有意义以便于理解代码的逻辑。


# 2

```java
public class Test3B {
  public static void main(String[] args) {
    int m = 1, n = 1;
    System.out.print(m + " ");
    for (int i = 2; i <= 10; i++) {
      System.out.print(n + " ");
      if (i % 5 == 0) System.out.print("\n");
      n = n + 1;
      m = n - m;
    }
  }
}

```
程序运行结果为：
```
1 1 2 3 4 
5 6 7 8 9 
```
# 3
```java
public class Test3C {
  public static void main(String[] args) {
    int i, s = 0;
    int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    for (i = 0; i < a.length; i++) if (a[i] % 3 == 0) s += a[i];
    System.out.println("s=" + s);
  }
}
```

程序运行结果为：
```
s=18
```

# 4
```java
public class Test3D {
  public static void main(String[] args) {
    B b = new B();
    System.out.println(b.f(10.0, 8.0));
    System.out.println(b.g(3));
  }
}

class A {
  double f(double x, double y) {
    return x + y;
  }

  static int g(int n) {
    return n * n;
  }
}

class B extends A {
  double f(double x, double y) {
    double m = super.f(x, y);
    return m + x * y;
  }

  static int g(int n) {
    int m = A.g(n);
    return m + n;
  }
}
```
程序运行结果为：
```
98.0
12
```