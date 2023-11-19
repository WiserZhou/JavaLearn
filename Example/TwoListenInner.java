package Example;

import java.awt.*;
import java.awt.event.*;

public class TwoListenInner {
  private TextField tf;

  public static void main(String[] args) {
    TwoListenInner that = new TwoListenInner();
    that.go();
  }

  public void go() {
    Frame f = new Frame("Two listeners example");
    f.add("North", new Label("Click and drag the mouse"));
    tf = new TextField(30);
    f.add("South", tf);
    f.addMouseMotionListener(
        new MouseMotionAdapter() {
          public void mouseDragged(MouseEvent e) {
            String s = "Mouse dragging:X = " + e.getX() + "  Y=" + e.getY();
            tf.setText(s);
          }
        });
    f.addMouseListener(new MouseEventHandler());
    f.setSize(300, 200);
    f.setVisible(true);
  }

  public class MouseMotionHandler extends MouseMotionAdapter {
    public void mouseDragged(MouseEvent e) {
      String s = "Mouse dragging:X = " + e.getX() + "  Y=" + e.getY();
      tf.setText(s);
    }
  }

  public class MouseEventHandler extends MouseAdapter {
    public void mouseEntered(MouseEvent e) {
      String s = "The mouse entered";
      tf.setText(s);
    }

    public void mouseExited(MouseEvent e) {
      String s = "The mouse has left the building";
      tf.setText(s);
    }
  }
}


class TwoListenInner$ {
  private TextField tf;

  public static void main(String[] args) {
    TwoListenInner that = new TwoListenInner();
    that.go();
  }

  public void go() {
    Frame f = new Frame("Two listeners example");
    f.add("North", new Label("Click and drag the mouse"));
    tf = new TextField(30);
    f.add("South", tf);
    f.addMouseMotionListener(
            new MouseMotionAdapter() {
              public void mouseDragged(MouseEvent e) {
                String s = "Mouse dragging:X = " + e.getX() + "  Y=" + e.getY();
                tf.setText(s);
              }
            });
    f.addMouseListener(new MouseEventHandler());
    f.setSize(300, 200);
    f.setVisible(true);
  }

  public class MouseMotionHandler extends MouseMotionAdapter {
    public void mouseDragged(MouseEvent e) {
      String s = "Mouse dragging:X = " + e.getX() + "  Y=" + e.getY();
      tf.setText(s);
    }
  }

  public class MouseEventHandler extends MouseAdapter {
    public void mouseEntered(MouseEvent e) {
      String s = "The mouse entered";
      tf.setText(s);
    }

    public void mouseExited(MouseEvent e) {
      String s = "The mouse has left the building";
      tf.setText(s);
    }
  }
}
