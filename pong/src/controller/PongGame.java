package controller;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import view.PongGamePanel;
import model.Paddle;
import model.PongModel;

public class PongGame extends KeyAdapter {

  private static final double MOVE_REL = 4;
  private PongModel model;
  private PongGamePanel panel;

  public PongGame(PongModel model, PongGamePanel panel) {
    this.model = model;
    this.panel = panel;
  }

  public void startGame() {
    new Timer(16, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        model.update();
        panel.update();
        Toolkit.getDefaultToolkit().sync();
      }
    }).start();
  }

  @Override
  public void keyPressed(KeyEvent event) {
    int keyCode = event.getKeyCode();
    Paddle paddle;
    if (isKey(KeyEvent.VK_UP, keyCode)) {
      paddle = model.getPaddles().get(0);
      paddle.addVerticalPosition(-MOVE_REL);
    }
    if (isKey(KeyEvent.VK_DOWN, keyCode)) {
      paddle = model.getPaddles().get(0);
      paddle.addVerticalPosition(MOVE_REL);
    }
  }

  private static boolean isKey(int keyToCompare, int keyCompared) {
    return keyToCompare == keyCompared;
  }
}
