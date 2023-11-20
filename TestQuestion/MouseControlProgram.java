package TestQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseControlProgram extends JFrame {

  private final JLabel statusLabel;

  public MouseControlProgram() {
    setTitle("Mouse Control Program");
    setSize(400, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 创建标签用于显示状态信息
    statusLabel = new JLabel("Move the mouse or press a key");
    statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(statusLabel, BorderLayout.SOUTH);

    // 添加鼠标事件监听器
    addMouseListener(new MyMouseListener());
    addMouseMotionListener(new MyMouseMotionListener());

    // 添加键盘事件监听器
    addKeyListener(new MyKeyListener());

    // 设置焦点，使得键盘事件生效
    setFocusable(true);
  }

  private class MyMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
      // 检测鼠标点击事件
      updateStatus("Mouse Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
      // 检测鼠标按下事件
      updateStatus("Mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      // 检测鼠标释放事件
      updateStatus("Mouse Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      // 检测鼠标进入事件
      updateStatus("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
      // 检测鼠标退出事件
      updateStatus("Mouse Exited");
    }
  }

  private class MyMouseMotionListener implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {
      // 检测鼠标拖动事件
      updateStatus("Mouse Dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
      // 检测鼠标移动事件
      updateStatus("Mouse Moved");
    }
  }

  private class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
      // 检测键盘按键事件
      updateStatus("Key Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
      // 检测键盘按下事件
      updateStatus("Key Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
      // 检测键盘释放事件
      updateStatus("Key Released");
    }
  }

  private void updateStatus(String message) {
    // 更新状态信息
    statusLabel.setText(message);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            new MouseControlProgram().setVisible(true);
          }
        });
  }
}
