import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("ActionEvent Demo");

    MyButton b = new MyButton("Close");

    frame.getContentPane().add(b, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }
}

class MyButton extends JButton implements ActionListener {

  /**
   * 在构造的时候顺便添加上事件的监听
   *
   * @param text
   */
  public MyButton(String text) {
    super(text);
    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.exit(0);
  }
  //  public void
  //  @Override
  //  public void actionPerformed(ActionEvent e) {}
}
