package model;

import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import view.PongGamePanel;

public class PongModel {

  private List<Paddle> paddles;
  private Ball ball;
  private Map<RectangularShaped, Rectangle2D.Double> assosBoundingBoxes;

  /**
   * Constructeur principal, prend en paramètres les composants du model
   * 
   * @param paddles liste des raquettes à utiliser dans la partie
   * @param ball balle à utiliser dans la partie
   */
  public PongModel(List<Paddle> paddles, Ball ball) {
    this.paddles = paddles;
    this.ball = ball;
    this.assosBoundingBoxes = new HashMap<>();

    createRectangles();
  }

  private void createRectangles() {
    createRectanglesForPaddles();
    createRectangleForBall();
  }

  private void createRectangleForBall() {
    assosBoundingBoxes.put(ball, new Rectangle2D.Double());
  }

  private void createRectanglesForPaddles() {
    for (Paddle p : paddles)
      createRectangleFor(p);
  }

  private void createRectangleFor(Paddle p) {
    assosBoundingBoxes.put(p, new Rectangle2D.Double());
  }

  public List<Paddle> getPaddles() {
    return paddles;
  }

  public Ball getBall() {
    return ball;
  }

  public void update() {
    ball.update();
    updateRectangles();
  }

  private void updateRectangles() {
    updatePaddlesRectangles();
    updateBallRectangle();
  }

  private void updateBallRectangle() {
    Rectangle2D rectBall = this.assosBoundingBoxes.get(ball);
    rectBall.setRect(ball.getX() - ball.getDiameter() / 2, ball.getY() - ball.getDiameter() / 2,
        ball.getDiameter(), ball.getDiameter());
    System.out.println("ball : " + rectBall);
  }

  private void updatePaddlesRectangles() {
    for (Paddle p : paddles)
      updatePaddleRectangle(p);
  }

  private void updatePaddleRectangle(Paddle p) {
    Rectangle2D rectPaddle = this.assosBoundingBoxes.get(p);
    rectPaddle.setRect(PongGamePanel.calculateHorizontalRelativePosition(p.getPlayerType())
        - PongGamePanel.paddleWidth / 2,
        p.getVerticalRelativePosition() - p.getLength() / 2,
        ball.getDiameter(), ball.getDiameter());
    System.out.println("paddle " + p.getPlayerType() + " : " + rectPaddle);
  }
}
