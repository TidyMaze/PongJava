package pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PongGame extends KeyAdapter {

  private static final double MOVE_REL = 4;
  private PongModel model;

  public PongGame(PongModel model) {
    this.model = model;
  }

  public void startGame() {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    scheduler.scheduleAtFixedRate(new Runnable() {

      @Override
      public void run() {
        model.update();
      }
    }, 0, 30, TimeUnit.MILLISECONDS);
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
