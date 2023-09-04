import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateLearn {
  public static void main(String[] args) throws ParseException {
    // 无参构造函数，表示当前日期和时间
    Date currentDate = new Date();
    Date date = currentDate;
    int year = date.getYear(); // 获取年份（从 1900 年开始计算，需加上 1900）
    int month = date.getMonth(); // 获取月份（0-11，需要加上 1）
    int day = date.getDate(); // 获取日期
    int hour = date.getHours(); // 获取小时
    int minute = date.getMinutes(); // 获取分钟
    int second = date.getSeconds(); // 获取秒钟

    // 带参数的构造函数，表示特定日期和时间
    Date specificDate = new Date(year, month, day, hour, minute, second);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String formattedDate = sdf.format(date); // 将 Date 对象格式化为字符串
    Date parsedDate = sdf.parse("2023-09-04 10:30:00"); // 将字符串解析为 Date 对象
  }
}
