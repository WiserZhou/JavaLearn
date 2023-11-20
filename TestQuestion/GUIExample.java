package TestQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIExample extends JFrame {

  private final JTextArea textArea;

  public GUIExample() {
    // 设置窗口属性
    setTitle("图形界面程序");
    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // 创建文本区
    textArea = new JTextArea();
    add(new JScrollPane(textArea), BorderLayout.CENTER);

    // 创建按钮
    JButton okButton = new JButton("Ok");
    JButton cancelButton = new JButton("Cancel");
    JButton exitButton = new JButton("Exit");

    // 添加按钮到窗口
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(okButton);
    buttonPanel.add(cancelButton);
    buttonPanel.add(exitButton);
    add(buttonPanel, BorderLayout.SOUTH);

    // 添加按钮的事件监听器
    okButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            textArea.append("Ok is pressed\n");
          }
        });

    cancelButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            textArea.append("Cancel is pressed\n");
          }
        });

    exitButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            System.exit(0);
          }
        });
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            new GUIExample().setVisible(true);
          }
        });
  }
}
