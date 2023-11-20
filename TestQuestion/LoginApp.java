package TestQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp extends JFrame {

  private final JTextField usernameField;
  private final JPasswordField passwordField;

  public LoginApp() {
    // 设置窗口属性
    setTitle("用户登录");
    setSize(350, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(3, 2));

    // 创建组件
    JLabel usernameLabel = new JLabel("用户名:");
    JLabel passwordLabel = new JLabel("密码:");
    usernameField = new JTextField();
    passwordField = new JPasswordField();
    JButton loginButton = new JButton("登录");
    JButton exitButton = new JButton("退出");

    // 添加组件到窗口
    add(usernameLabel);
    add(usernameField);
    add(passwordLabel);
    add(passwordField);
    add(loginButton);
    add(exitButton);

    // 添加登录按钮的事件监听器
    loginButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            login();
          }
        });

    // 添加退出按钮的事件监听器
    exitButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            System.exit(0);
          }
        });
  }

  private void login() {
    String username = usernameField.getText();
    char[] passwordChars = passwordField.getPassword();
    String password = new String(passwordChars);

    // 在实际应用中，这里可以加入用户名密码验证的逻辑

    // 弹出消息对话框
    JOptionPane.showMessageDialog(
        this, "Welcome to " + username, "登陆成功", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            new LoginApp().setVisible(true);
          }
        });
  }
}
