import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
  private JFrame frame;
  private JButton be, bw, bn, bs, bc;

  public static void main(String[] args) {
    BorderLayoutDemo that =
        new BorderLayoutDemo(); // FrameLayout趋于将每一个控件分配各自最优的大小，而BorderLayout趋于给控件分配已经确定好的位置
    that.go();
  }

  void go() {
    frame = new JFrame("Border Layout");
    be = new JButton("East");
    bs = new JButton("South");
    bw = new JButton("West");
    bn = new JButton("North");
    bc = new JButton("Center");

    frame.getContentPane().add(be, BorderLayout.EAST);
    frame.getContentPane().add(bs, BorderLayout.SOUTH);
    frame.getContentPane().add(bw, BorderLayout.WEST);
    frame.getContentPane().add(bn, BorderLayout.NORTH);
    frame.getContentPane().add(bc, BorderLayout.CENTER);

    frame.setSize(350, 200);
    frame.setVisible(true);
  }
}
