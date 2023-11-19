package Example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TwoListener implements MouseMotionListener, MouseListener {
  private JFrame frame;
  private JTextField tf;

  public static void main(String[] args) {
    TwoListener two = new TwoListener();
    two.go();
  }

  public void go() {
    frame = new JFrame("Two listeners example");
    Container contentPane = frame.getContentPane();
    contentPane.add(new Label("Click and drag the mouse"), BorderLayout.NORTH);

    tf = new JTextField(30);
    contentPane.add(tf, BorderLayout.SOUTH);

    frame.addMouseMotionListener(this);
    frame.addMouseListener(this);

    frame.setSize(300, 300);
    frame.setVisible(true);
  }

  public void mouseMoved(MouseEvent e) {}

  public void mouseClicked(MouseEvent e) {}

  public void mouseEntered(MouseEvent e) {
    String s = "The mouse entered";
    tf.setText(s);
  }

  public void mouseExited(MouseEvent e) {
    String s = "The mouse has left the building";
    tf.setText(s);
  }

  public void mousePressed(MouseEvent e) {}

  public void mouseReleased(MouseEvent e) {}

  public void mouseDragged(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tf.setText("Mouse dragging: X = " + x + " Y = " + y);
  }
}
