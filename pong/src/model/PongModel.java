package model;

import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PongModel {

  private List<Paddle> paddles;
  private Ball ball;
  private Map<Rectangle2D, RectangularShaped> assosBoundingBoxes;

  public PongModel(List<Paddle> paddles, Ball ball) {
    this.paddles = paddles;
    this.ball = ball;
    this.assosBoundingBoxes = new HashMap<>();
  }

  public List<Paddle> getPaddles() {
    return paddles;
  }

  public Ball getBall() {
    return ball;
  }

  public void update() {
    ball.update();
  }
}
