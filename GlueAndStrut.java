import javax.swing.*;
import java.awt.*;

public class GlueAndStrut {
  private JFrame frame;
  private Box b1, b2, b3, b4;

  public static void main(String[] args) {
    GlueAndStrut that = new GlueAndStrut();
    that.go();
  }

  void go() {
    frame = new JFrame("Glue and Strut example");
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new GridLayout(4, 1));

    b1 = Box.createHorizontalBox();
    b1.add(new JLabel("Box 1: "));
    b1.add(new JButton("Yes"));
    b1.add(new JButton("No"));
    b1.add(new JButton("Cancel"));

    b2 = Box.createHorizontalBox();
    b2.add(new JLabel("Box 2: "));
    b2.add(new JButton("Yes"));
    b2.add(new JButton("No"));
    b2.add(Box.createHorizontalGlue()); // 可以使按钮在容器中均匀分布，并且根据窗口大小的变化而自动调整按钮之间的间距
    b2.add(new JButton("Cancel"));

    b3 = Box.createHorizontalBox();
    b3.add(new JLabel("Box 3: "));
    b3.add(new JButton("Yes"));
    b3.add(new JButton("No"));
    b3.add(Box.createHorizontalStrut(20));
    b3.add(new JButton("Cancel"));

    b4 = Box.createHorizontalBox();
    b4.add(new JLabel("Box 4: "));
    b4.add(new JButton("Yes"));
    b4.add(new JButton("No"));
    b4.add(Box.createRigidArea(new Dimension(50, 90)));
    b4.add(new JButton("Cancel"));

    contentPane.add(b1);
    contentPane.add(b2);
    contentPane.add(b3);
    contentPane.add(b4);

    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}
