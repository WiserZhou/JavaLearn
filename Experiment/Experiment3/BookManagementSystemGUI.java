package Experiment.Experiment3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookManagementSystemGUI extends JFrame {
  private final ArrayList<Book> bookList = new ArrayList<>(); // 创建一个ArrayList用于存储图书信息
  private JTextField nameField; // 输入书名的文本框
  private JTextField authorField; // 输入作者的文本框
  private JTextField publisherField; // 输入出版社的文本框
  private JTextField pubDateField; // 输入出版日期的文本框
  private JTextField pageCountField; // 输入页数的文本框
  private JTextArea summaryArea; // 输入摘要的文本域
  private JList<Book> bookListUI; // 显示图书列表的JList组件

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            BookManagementSystemGUI gui = new BookManagementSystemGUI();
            gui.createAndShowGUI();
          }
        });
  }

  private void createAndShowGUI() {
    setTitle("图书管理系统"); // 设置窗口标题
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭时退出程序
    setResizable(false); // 禁止调整窗口大小

    JPanel mainPanel = new JPanel(new BorderLayout()); // 创建一个主面板，使用边界布局
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 设置主面板的边距

    JLabel titleLabel = new JLabel("图书管理系统", SwingConstants.CENTER); // 创建一个标签，显示系统标题
    mainPanel.add(titleLabel, BorderLayout.NORTH); // 将标题标签添加到主面板的北部

    JPanel inputPanel =
        new JPanel(new GridLayout(8, 2, 5, 5)); // 创建一个面板用于显示输入框和按钮，使用网格布局，8行2列，组件之间的水平和垂直间距为5
    inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // 设置输入面板的边距

    inputPanel.add(new JLabel("书名：")); // 添加标签到输入面板
    nameField = new JTextField(); // 创建输入书名的文本框
    inputPanel.add(nameField); // 添加文本框到输入面板

    inputPanel.add(new JLabel("作者：")); // 添加标签到输入面板
    authorField = new JTextField(); // 创建输入作者的文本框
    inputPanel.add(authorField); // 添加文本框到输入面板

    inputPanel.add(new JLabel("出版社：")); // 添加标签到输入面板
    publisherField = new JTextField(); // 创建输入出版社的文本框
    inputPanel.add(publisherField); // 添加文本框到输入面板

    inputPanel.add(new JLabel("刊号：")); // 添加标签到输入面板
    JTextField issnField = new JTextField(); // 创建输入刊号的文本框
    inputPanel.add(issnField); // 添加文本框到输入面板

    inputPanel.add(new JLabel("出版日期：")); // 添加标签到输入面板
    pubDateField = new JTextField(); // 创建输入出版日期的文本框
    inputPanel.add(pubDateField); // 添加文本框到输入面板

    inputPanel.add(new JLabel("页数：")); // 添加标签到输入面板
    pageCountField = new JTextField(); // 创建输入页数的文本框
    inputPanel.add(pageCountField); // 添加文本框到输入面板

    inputPanel.add(new JLabel("摘要：")); // 添加标签到输入面板
    summaryArea = new JTextArea(); // 创建输入摘要的文本域
    JScrollPane scrollPane = new JScrollPane(summaryArea); // 创建一个带滚动条的面板用于包含摘要区域
    inputPanel.add(scrollPane); // 添加带滚动条的面板到输入面板

    mainPanel.add(inputPanel, BorderLayout.WEST); // 将输入面板添加到主面板的西部

    DefaultListModel<Book> bookListModel = new DefaultListModel<>(); // 创建一个默认的列表模型，用于存储图书列表数据
    bookListUI = new JList<>(bookListModel); // 创建一个JList组件，使用默认的列表模型
    JScrollPane bookListScrollPane = new JScrollPane(bookListUI); // 创建一个带滚动条的面板用于包含图书列表
    mainPanel.add(bookListScrollPane, BorderLayout.CENTER); // 将图书列表面板添加到主面板的中部

    JPanel buttonPanel = getjPanel();

    mainPanel.add(buttonPanel, BorderLayout.SOUTH); // 将按钮面板添加到主面板的南部

    add(mainPanel); // 将主面板添加到窗口
    pack(); // 根据组件的首选大小调整窗口大小
    setLocationRelativeTo(null); // 将窗口居中显示
    setVisible(true); // 设置窗口可见
  }

  private JPanel getjPanel() {
    JPanel buttonPanel = new JPanel(new FlowLayout()); // 创建一个面板用于包含按钮，使用流式布局

    JButton insertButton = new JButton("插入图书"); // 创建一个插入图书的按钮
    insertButton.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            insertBook(); // 给插入按钮添加点击事件监听器
          }
        });
    buttonPanel.add(insertButton); // 将插入按钮添加到按钮面板

    JButton deleteButton = new JButton("删除图书"); // 创建一个删除图书的按钮
    deleteButton.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            deleteBook(); // 给删除按钮添加点击事件监听器
          }
        });
    buttonPanel.add(deleteButton); // 将删除按钮添加到按钮面板

    JButton searchButton = new JButton("查找图书"); // 创建一个查找图书的按钮
    searchButton.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            searchBook(); // 给查找按钮添加点击事件监听器
          }
        });
    buttonPanel.add(searchButton); // 将查找按钮添加到按钮面板
    return buttonPanel;
  }

  private void insertBook() {
    String name = nameField.getText(); // 获取输入的书名
    String author = authorField.getText(); // 获取输入的作者
    String publisher = publisherField.getText(); // 获取输入的出版社
    String pubDate = pubDateField.getText(); // 获取输入的出版日期
    int pageCount = Integer.parseInt(pageCountField.getText()); // 将输入的页数转换为整数
    String summary = summaryArea.getText(); // 获取输入的摘要

    Book book = new Book(name, author, publisher, pubDate, pageCount, summary); // 创建一个图书对象
    if (bookList.add(book)) { // 将图书对象添加到图书列表中
      DefaultListModel<Book> model = (DefaultListModel<Book>) bookListUI.getModel(); // 获取图书列表组件的模型
      model.addElement(book); // 将已插入的图书添加到JList组件中
      JOptionPane.showMessageDialog(this, "插入成功！"); // 弹出插入成功的提示框
    } else {
      JOptionPane.showMessageDialog(this, "插入失败！"); // 弹出插入失败的提示框
    }
  }

  private void deleteBook() {
    int selectedIndex = bookListUI.getSelectedIndex(); // 获取选中的图书索引
    if (selectedIndex != -1) { // 判断是否选中了一个图书
      Book book = bookListUI.getSelectedValue(); // 获取选中的图书对象
      bookList.remove(book); // 从图书列表中移除选中的图书
      DefaultListModel<Book> model = (DefaultListModel<Book>) bookListUI.getModel(); // 获取图书列表组件的模型
      model.removeElement(book); // 将删除的图书从JList组件中移除
      JOptionPane.showMessageDialog(this, "删除成功！"); // 弹出删除成功的提示框
    } else {
      JOptionPane.showMessageDialog(this, "请选中要删除的图书！"); // 弹出未选中图书的提示框
    }
  }

  private void searchBook() {
    String keyword = nameField.getText(); // 获取输入的关键字
    boolean found = false; // 标记是否找到匹配的图书
    StringBuilder result = new StringBuilder(); // 用于存储查找结果
    for (Book book : bookList) { // 遍历图书列表
      if (book.contains(keyword)) { // 判断图书是否包含关键字
        result.append(book.toString()).append("\n\n"); // 将匹配的图书添加到结果中
        found = true; // 标记已找到匹配的图书
      }
    }
    if (found) {
      JOptionPane.showMessageDialog(this, result.toString()); // 弹出查找结果的提示框
    } else {
      JOptionPane.showMessageDialog(this, "未找到相关图书！"); // 弹出未找到图书的提示框
    }
  }
}

class Book {

  private final String name;
  private final String author;
  private final String publisher;

  public Book(
      String name, String author, String publisher, String pubDate, int pageCount, String summary) {
    this.name = name;
    this.author = author;
    this.publisher = publisher;
  }

  public String getName() {
    return name;
  }

  public boolean contains(String keyword) {
    return name.contains(keyword)
        || author.contains(keyword)
        || publisher.contains(keyword); // 判断图书是否包含关键字
  }

  @Override
  public String toString() {
    return name; // 返回图书名称的字符串表示
  }
}
// 以上是一个简单的图书管理系统的GUI界面代码，主要实现了图书信息的插入、删除和查找的功能。
