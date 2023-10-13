import javax.swing.*;
import java.awt.*;

public class ExGui {
  private JFrame frame;
  private JButton b1;
  private JButton b2;

  public static void main(String[] args) {
    ExGui that = new ExGui();
    that.go(); // 无法直接调用go函数，因为不是静态成员函数，所以必须通过对象进行调用
  }

  public void go() {
    frame = new JFrame("GUI example");
    Container contentPane = frame.getContentPane();

    contentPane.setLayout(new FlowLayout());

    b1 = new JButton("Press me ");
    b2 = new JButton("Don't press Me");

    contentPane.add(b1);
    contentPane.add(b2);

    frame.pack();
    frame.setVisible(true);
  }
}
