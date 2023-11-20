package ExamTest2.Selection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GridBagLayoutDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("网格布袋布局");
    frame.setSize(300, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();
    GridBagLayout gridBagLayout = new GridBagLayout();
    contentPane.setLayout(gridBagLayout);

    // 创建 GridBagConstraints 对象，用于指定组件在网格布袋布局中的位置、大小和对齐方式等约束条件。
    GridBagConstraints gridBagConstraints = new GridBagConstraints();

    int[] gridx = {0, 0, 1, 2, 3, 0, 1, 2, 0, 2};
    int[] gridy = {0, 1, 1, 1, 1, 2, 2, 2, 3, 3};
    int[] gridwidth = {4, 1, 1, 1, 1, 1, 1, 1, 2, 2};
    int[] gridheight = {1, 1, 1, 1, 2, 1, 1, 1, 1, 1};

    String name;
    JButton button;

    for (int i = 0; i < gridx.length; i++) {
      name = "单元" + (i + 1);
      button = new JButton(name);
      gridBagConstraints.gridx = gridx[i];
      gridBagConstraints.gridy = gridy[i];
      gridBagConstraints.gridwidth = gridwidth[i];
      gridBagConstraints.gridheight = gridheight[i];
      gridBagConstraints.weightx = 100; // 表示在水平方向上，当容器空间改变时，组件的拉伸权重。值越大，组件在水平方向上的拉伸能力越强。
      gridBagConstraints.weighty = 100;
      gridBagConstraints.fill =
          GridBagConstraints
              .BOTH; // 表示组件在网格单元格中的填充方式。GridBagConstraints.BOTH
                     // 表示组件会填充整个单元格，使其占据所有可用的空间，即在水平和垂直两个方向上进行拉伸。
      gridBagLayout.setConstraints(button, gridBagConstraints);
      contentPane.add(button);
    }

    frame.setVisible(true);
  }
}
