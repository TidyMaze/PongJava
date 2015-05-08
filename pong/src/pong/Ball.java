package pong;

public class Ball implements MovingObject {

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

}
