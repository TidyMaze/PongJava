package pong;

import java.util.List;

public class PongModel {

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

}
