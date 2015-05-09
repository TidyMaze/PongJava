package pong;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PongModel extends Observable implements Observer {

  private List<Paddle> paddles;
  private Ball ball;

  public PongModel(List<Paddle> paddles, Ball ball) {
    this.paddles = paddles;
    this.ball = ball;
  }

  public List<Paddle> getPaddles() {
    return paddles;
  }

  public Ball getBall() {
    return ball;
  }

  @Override
  public void update(Observable o, Object arg) {
    this.setChanged();
    this.notifyObservers();
  }

  public void update() {
    ball.update();
  }
}
