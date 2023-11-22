package ExamTest3.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin {
  public static void main(String[] args) {

    JFrame frame = new JFrame("用户登录");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setLayout(new FlowLayout());

    JLabel usernameLabel = new JLabel("用户名:");
    JTextField usernameField = new JTextField(15);

    JLabel passwordLabel = new JLabel("密码:");
    JPasswordField passwordField = new JPasswordField(15);

    JButton loginButton = new JButton("登录");
    loginButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            if (username.equals("admin") && password.equals("password")) {
              JOptionPane.showMessageDialog(frame, "Welcome to " + username + "!");
            } else {
              JOptionPane.showMessageDialog(frame, "登录失败", "错误", JOptionPane.ERROR_MESSAGE);
            }
          }
        });

    frame.add(usernameLabel);
    frame.add(usernameField);
    frame.add(passwordLabel);
    frame.add(passwordField);
    frame.add(loginButton);

    frame.setVisible(true);
  }
}
