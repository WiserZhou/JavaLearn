package Example;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo {
  private JFrame frame;
  private JPanel pv, ph;

  public static void main(String[] args) {
    BoxLayoutDemo that = new BoxLayoutDemo();
    that.go();
  }

  void go() {
    frame = new JFrame("Box Layout example");
    Container contentPane = frame.getContentPane();

    pv = new JPanel();
    pv.setLayout(new BoxLayout(pv, BoxLayout.Y_AXIS)); // 将pv的布局设置为垂直布局

    pv.add(new JLabel(" Monday"));
    pv.add(new JLabel(" Tuesday"));
    pv.add(new JLabel(" Wednesday"));
    pv.add(new JLabel(" Thursday"));
    pv.add(new JLabel(" Friday"));
    pv.add(new JLabel(" Saturday"));
    pv.add(new JLabel(" Sunday"));

    contentPane.add(pv, BorderLayout.CENTER);

    ph = new JPanel();

    ph.setLayout(new BoxLayout(ph, BoxLayout.X_AXIS));

    ph.add(new JButton("Yes"));
    ph.add(new JButton("No"));
    ph.add(new JButton("Cancel"));

    contentPane.add(ph, BorderLayout.SOUTH);

    frame.pack();
    frame.setVisible(true);
  }
}
