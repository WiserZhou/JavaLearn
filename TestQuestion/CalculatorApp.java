package TestQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {

  private final JTextField display;

  private double currentResult;
  private String currentOperator;
  private boolean isNewInput;

  public CalculatorApp() {
    // 设置窗口属性
    setTitle("简单计算器");
    setSize(300, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // 创建文本框显示区域
    display = new JTextField();
    display.setEditable(false);
    add(display, BorderLayout.NORTH);

    // 创建按钮面板
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4, 4));

    // 按钮文本
    String[] buttonLabels = {
      "7", "8", "9", "/",
      "4", "5", "6", "*",
      "1", "2", "3", "-",
      "0", ".", "=", "+"
    };

    // 创建按钮并添加到面板
    for (String label : buttonLabels) {
      JButton button = new JButton(label);
      button.addActionListener(new ButtonClickListener());
      buttonPanel.add(button);
    }

    // 添加按钮面板到窗口
    add(buttonPanel, BorderLayout.CENTER);

    // 初始化变量
    currentResult = 0;
    currentOperator = "";
    isNewInput = true;
  }

  private class ButtonClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      JButton sourceButton = (JButton) e.getSource();
      String buttonText = sourceButton.getText();

      if (isNewInput) {
        display.setText("");
        isNewInput = false;
      }

      if ("0123456789.".contains(buttonText)) {
        display.setText(display.getText() + buttonText);
      } else if ("+-*/".contains(buttonText)) {
        calculateResult();
        currentOperator = buttonText;
        isNewInput = true;
      } else if ("=".equals(buttonText)) {
        calculateResult();
        currentOperator = "";
        isNewInput = true;
      }
    }

    private void calculateResult() {
      try {
        double inputValue = Double.parseDouble(display.getText());
        switch (currentOperator) {
          case "+":
            currentResult += inputValue;
            break;
          case "-":
            currentResult -= inputValue;
            break;
          case "*":
            currentResult *= inputValue;
            break;
          case "/":
            currentResult /= inputValue;
            break;
          default:
            currentResult = inputValue;
            break;
        }
        display.setText(String.valueOf(currentResult));
      } catch (NumberFormatException ex) {
        display.setText("Error");
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            new CalculatorApp().setVisible(true);
          }
        });
  }
}
