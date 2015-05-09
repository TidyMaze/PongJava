package pong;

import java.util.Observable;

public class Ball extends Observable implements MovingObject {

  private static final double DEFAULT_START_Y = 50.0;

  private static final double DEFAULT_START_X = 50.0;

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

  public Ball(double diameter) {
    this(diameter, DEFAULT_START_X, DEFAULT_START_Y);
  }

  public Ball(double diameter, double defaultStartX, double defaultStartY) {
    this.x = defaultStartX;
    this.y = defaultStartY;
    this.diameter = diameter;
  }
}
