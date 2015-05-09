package pong;

import java.util.Observable;

public class Ball extends Observable implements MovingObject {

  private static final double DEFAULT_START_Y = 50.0;

  private static final double DEFAULT_START_X = 50.0;

  private static final double DEFAULT_H_SPEED = 0.75;

  private static final double DEFAULT_V_SPEED = 0.50;

  private static final double DEFAULT_DIAMETER = 3;

  /**
   * X relatif (0-100)
   */
  private double x;

  /**
   * Y relatif (0-100)
   */
  private double y;

  /**
   * Diamètre relatif (0-100)
   */
  private double diameter;

  /**
   * Vitesse horizontale relative (0-100)
   */
  private double horizontalSpeed;

  /**
   * Vitesse verticale relative (0-100)
   */
  private double verticalSpeed;

  /**
   * 
   * @return X relatif (0-100)
   */
  @Override
  public double getX() {
    return this.x;
  }

  /**
   * 
   * @return Y relatif (0-100)
   */
  @Override
  public double getY() {
    return this.y;
  }

  /**
   * 
   * @return Vitesse horizontale relative (0-100)
   */
  @Override
  public double getHorizontalSpeed() {
    return this.horizontalSpeed;
  }

  /**
   * 
   * @return Vitesse verticale relative (0-100)
   */
  @Override
  public double getVerticalSpeed() {
    return this.verticalSpeed;
  }

  /**
   * 
   * @return Diamètre relatif (0-100)
   */
  public double getDiameter() {
    return diameter;
  }

  public void setDiameter(double diameter) {
    this.diameter = diameter;
  }

  public Ball() {
    this(DEFAULT_DIAMETER, DEFAULT_START_X, DEFAULT_START_Y, DEFAULT_H_SPEED, DEFAULT_V_SPEED);
  }

  public Ball(double diameter, double x, double y, double hSpeed, double vSpeed) {
    this.x = x;
    this.y = y;
    this.diameter = diameter;
    this.horizontalSpeed = hSpeed;
    this.verticalSpeed = vSpeed;
  }

  public void update() {
    x += horizontalSpeed;
    y += verticalSpeed;

    if (isOutOfScreen()) {
      System.out.println("Out of screen");
      moveBallInScreen();
    }

    this.setChanged();
    notifyObservers();
  }

  private void moveBallInScreen() {
    if (isOutLeft()) {
      System.out.println("out left");
      double rayon = diameter / 2;
      double posiCenter = x;
      double posiLeft = posiCenter - rayon;
      double delta = posiLeft - 0;
      double newLeft = -delta;
      double newCenter = newLeft + rayon;
      this.x = newCenter + 1;
      horizontalSpeed = -horizontalSpeed;
    }
    if (isOutRight()) {
      System.out.println("out right");
      double rayon = diameter / 2;
      double posiCenter = x;
      double posiRight = posiCenter + rayon;
      double delta = posiRight - 100;
      double newRight = 100 - delta;
      double newCenter = newRight - rayon;
      this.x = newCenter - 1;
      horizontalSpeed = -horizontalSpeed;
    }
    if (isOutUp()) {
      System.out.println("out up");
      double rayon = diameter / 2;
      double posiCenter = y;
      double posiUp = posiCenter - rayon;
      double delta = posiUp - 0;
      double newUp = -delta;
      double newCenter = newUp + rayon;
      this.y = newCenter + 1;
      verticalSpeed = -verticalSpeed;
    }
    if (isOutDown()) {
      System.out.println("out down");
      double rayon = diameter / 2;
      double posiCenter = y;
      double posiDown = posiCenter + rayon;
      double delta = posiDown - 100;
      double newDown = 100 - delta;
      double newCenter = newDown - rayon;
      this.y = newCenter - 1;
      verticalSpeed = -verticalSpeed;
    }
  }

  private boolean isOutOfScreen() {
    return isOutLeft()
        || isOutRight()
        || isOutUp()
        || isOutDown();
  }

  private boolean isOutDown() {
    return y > 100 - diameter / 2;
  }

  private boolean isOutUp() {
    return y < 0 + diameter / 2;
  }

  private boolean isOutRight() {
    return x > 100 - diameter / 2;
  }

  private boolean isOutLeft() {
    return x < 0 + diameter / 2;
  }
}
