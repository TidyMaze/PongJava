package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class PongWindow extends JFrame {

  private static final long serialVersionUID = -4071095185216071270L;

  private static final int PREFERRED_WIDTH = 1000;
  private static final int PREFERRED_HEIGHT = 500;

  public PongWindow(PongGamePanel gamePanel) {
    this.setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
    Container cp = this.getContentPane();
    cp.setLayout(new BorderLayout());
    cp.add(gamePanel, BorderLayout.CENTER);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
  }
}
