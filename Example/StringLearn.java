package Example;

public class StringLearn {
  public static void main(String[] args) {}

  public void StringLearn() {
    String string = "hello world!";
    string.length();
    string.charAt(1); // 返回字符串中index为1的位置的字符
    string.toLowerCase();
    string.toUpperCase();
    string.substring(3); // 截取从beginIndex开始到结尾的字符串
    string.replace('a', 'b');
    string.concat("你好,世界！");
    string.equals("hello world!");
    String string1 = new StringBuffer("He is").append("age").append("years").toString();
  }
}
