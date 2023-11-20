# 1

```java
public class Test3A {
    public static void main(String[] args) {
        int i, s = 0;
        int a[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (i = 0; i < a.length; i++)
            if (a[i] % 2 == 0 || a[i] % 3 == 0) s += a[i];
        System.out.println("s=" + s);
    }
}
```

程序运行结果为：

```
s = 42
```

# 2

```java
public class Test3B {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6 - i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

```

程序运行结果为：

```
******
*****
****
***
**
*
```

# 3

```java
public class Test3C {
    static long number = 120456;

    public static void main(String[] args) {
        long a = 0;
        long digit;
        while (number > 0) {
            digit = number % 10;
            a = a * 10 + digit;
            number = number / 10;
        }
        System.out.println(a);
    }
}

```

程序运行结果为：

```
654021
```

# 4

```java
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

```

程序运行结果为：

```
P
M.f
P
P.f
```








