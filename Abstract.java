public class Abstract extends ObjectStorage {
  private int point = 0;

  @Override
  void put(Object o) {
    storage[point++] = o;
    objectNum++;
  }

  @Override
  Object get() {
    objectNum--;
    return storage[--point];
  }
}

abstract class ObjectStorage {
  int objectNum = 0;
  Object[] storage = new Object[100];

  abstract void put(Object o);

  abstract Object get();
}
