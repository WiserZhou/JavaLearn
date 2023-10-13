import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo implements MouseListener {
  JPanel p1, p2;
  JLabel l1, l2;

  CardLayout myCard;
  JFrame frame;

  Container contentPane;

  public static void main(String[] args) {
    CardLayoutDemo that = new CardLayoutDemo();
    that.go();
  }

  void go() {
    frame = new JFrame("Card Test");
    contentPane = frame.getContentPane();
    myCard = new CardLayout();

    contentPane.setLayout(myCard);

    p1 = new JPanel();
    p2 = new JPanel();

    l1 = new JLabel("This is the first JPanel");
    p1.add(l1);
    p1.setBackground(Color.yellow);

    l2 = new JLabel("This is the second JPanel");
    p2.add(l2);
    p2.setBackground(Color.green);

    p1.addMouseListener(this);
    p2.addMouseListener(this);

    contentPane.add(p1, "First");
    contentPane.add(p2, "Second");

    myCard.show(contentPane, "First");
    frame.setSize(300, 200);
    frame.setVisible(true);
  }

  public void mouseClicked(MouseEvent e) {
    myCard.next(contentPane);
  }

  public void mousePressed(MouseEvent e) {}

  public void mouseReleased(MouseEvent e) {}

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}
}
