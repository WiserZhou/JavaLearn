package Experiment.Experiment3;

import javax.swing.*;
import java.awt.*;

public class HorseRaceProgram extends JFrame {
  private JProgressBar horse1ProgressBar;
  private JProgressBar horse2ProgressBar;

  public HorseRaceProgram() {
    setTitle("赛马程序");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(2, 1));

    horse1ProgressBar = new JProgressBar();
    horse1ProgressBar.setStringPainted(true);
    add(horse1ProgressBar);

    horse2ProgressBar = new JProgressBar();
    horse2ProgressBar.setStringPainted(true);
    add(horse2ProgressBar);
  }

  public void startRace() {
    Thread horse1Thread =
        new Thread(
            () -> {
              for (int i = 0; i <= 100; i++) {
                horse1ProgressBar.setValue(i);
                try {
                  Thread.sleep(100); // 模拟马1的速度
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    horse1Thread.setPriority(Thread.MAX_PRIORITY);

    Thread horse2Thread =
        new Thread(
            () -> {
              for (int i = 0; i <= 100; i++) {
                horse2ProgressBar.setValue(i);
                try {
                  Thread.sleep(200); // 模拟马2的速度
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    horse2Thread.setPriority(Thread.MIN_PRIORITY);

    horse1Thread.start();
    horse2Thread.start();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        () -> {
          HorseRaceProgram program = new HorseRaceProgram();
          program.setSize(300, 200);
          program.setVisible(true);
          program.startRace();
        });
  }
}
