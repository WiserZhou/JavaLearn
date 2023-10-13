interface Pairable<T> {
  public T getFirst();

  public T getSecond();

  public void changeOrder();
}

class OrderedPair<T> implements Pairable<T> {
  private T first, second;

  public OrderedPair(T firstItem, T secondItem) {
    first = firstItem;
    second = secondItem;
  }

  public T getFirst() {
    return first;
  }

  public T getSecond() {
    return second;
  }

  public String toString() {
    return "(" + first + "," + second + ")";
  }

  public void changeOrder() {
    T temp = first;
    first = second;
    second = temp;
  }
}

public class OrderedPairs {
  public static void main(String[] args) {
    OrderedPair<String> fruit = new OrderedPair<>("apple", "banana");
  }
}
