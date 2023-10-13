import javax.swing.*;
import java.awt.*;

public class JFrameDemo {
  JFrame frame; // 定义一个JFrame对象frame
  JButton button; // 定义一个JButton对象button
  JPanel contentPane; // 定义一个JPanel对象contentPane

  public void init() {
    frame = new JFrame("My JFrame"); // frame对象实例化
    button = new JButton("Press me"); // button对象实例化

    JPanel contentPane = new JPanel();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(button, BorderLayout.CENTER);
    frame.setContentPane(contentPane);

    //    frame.getContentPane().add(button, BorderLayout.CENTER);

    frame.pack();
    frame.setVisible(true);
  }

  public void init2() {
    JFrame frame1 = new JFrame("Frame with Panel");
    Container contentPane = frame1.getContentPane();
    contentPane.setBackground(Color.CYAN);

    JPanel panel = new JPanel();
    panel.setBackground(Color.YELLOW);

    JButton button1 = new JButton("Press me");
    panel.add(button1);

    contentPane.add(panel, BorderLayout.SOUTH);
    frame1.setSize(300, 200);
    frame1.setVisible(true);
  }

  public static void main(String[] args) {
    JFrameDemo frameDemo = new JFrameDemo();
    frameDemo.init2();
  }
}
