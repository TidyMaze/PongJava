package model;

import java.util.Observable;

public class Ball extends Observable implements MovingObject, RectangularShaped {

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

    if (isOutOfScreen())
      moveBallInScreen();

    this.setChanged();
    notifyObservers();
  }

  private void moveBallInScreen() {
    double rayon = diameter / 2;
    if (isOutLeft())
      moveBallInLeft(rayon);
    if (isOutRight())
      moveBallInRight(rayon);
    if (isOutUp())
      moveBallInUp(rayon);
    if (isOutDown())
      moveBallInDown(rayon);
  }

  private void moveBallInDown(double rayon) {
    System.out.println("out up");
    y = moveInIncrease(rayon, y);
    invertVSpeed();
  }


  private void moveBallInUp(double rayon) {
    System.out.println("out up");
    y = moveInDecrease(rayon, y);
    invertVSpeed();
  }


  private void moveBallInRight(double rayon) {
    System.out.println("out right");
    x = moveInIncrease(rayon, x);
    invertHSpeed();
  }

  private void moveBallInLeft(double rayon) {
    System.out.println("out left");
    x = moveInDecrease(rayon, x);
    invertHSpeed();
  }

  private static double moveInDecrease(double rayon, double coord) {
    return -coord + 2 * rayon;
  }

  private static double moveInIncrease(double rayon, double coord) {
    return 200 - coord - 2 * rayon;
  }

  private void invertVSpeed() {
    verticalSpeed = -verticalSpeed;
  }

  private void invertHSpeed() {
    horizontalSpeed = -horizontalSpeed;
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

  @Override
  public double getWidth() {
    return diameter;
  }

  @Override
  public double getHeight() {
    return diameter;
  }
}
