package model;

import java.util.Observable;

public class Ball extends Observable implements MovingObject, RectangularShaped {

  private static final double DEFAULT_START_Y = 50.0;

  private static final double DEFAULT_START_X = 50.0;

  private static final double DEFAULT_H_SPEED = 0.75;

  private static final double DEFAULT_V_SPEED = 0.50;

  private static final double DEFAULT_RADIUS = 1.5;

  /**
   * X relatif (0-100)
   */
  private double x;

  /**
   * Y relatif (0-100)
   */
  private double y;

  /**
   * Vitesse horizontale relative (0-100)
   */
  private double horizontalSpeed;

  /**
   * Vitesse verticale relative (0-100)
   */
  private double verticalSpeed;

  private double radius;

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
    return radius * 2;
  }

  public Ball() {
    this(DEFAULT_RADIUS, DEFAULT_START_X, DEFAULT_START_Y, DEFAULT_H_SPEED, DEFAULT_V_SPEED);
  }

  public Ball(double radius, double x, double y, double hSpeed, double vSpeed) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.horizontalSpeed = hSpeed;
    this.verticalSpeed = vSpeed;
  }

  /**
   * Déplace la balle en prennant en compte les rebonds
   */
  public void update() {
    x += horizontalSpeed;
    y += verticalSpeed;

    handleBump();

    this.setChanged();
    notifyObservers();
  }

  private void handleBump() {
    if (isOutOfScreen())
      moveBallInScreen();
  }

  /**
   * Replace la balle dans l'écran si elle dépasse de l'écran
   */
  private void moveBallInScreen() {
    if (isOutLeft()) moveBallInLeft();
    if (isOutRight()) moveBallInRight();
    if (isOutUp()) moveBallInUp();
    if (isOutDown()) moveBallInDown();
  }

  private double getRadius() {
    return radius;
  }

  private void moveBallInDown() {
    System.out.println("out up");
    y = 200 - y - getDiameter();
    invertVSpeed();
  }


  private void moveBallInUp() {
    System.out.println("out up");
    y = -y + getDiameter();
    invertVSpeed();
  }


  private void moveBallInRight() {
    System.out.println("out right");
    x = 200 - x - getDiameter();
    invertHSpeed();
  }

  private void moveBallInLeft() {
    System.out.println("out left");
    x = -x + getDiameter();
    invertHSpeed();
  }

  private void invertVSpeed() {
    verticalSpeed = -verticalSpeed;
  }

  private void invertHSpeed() {
    horizontalSpeed = -horizontalSpeed;
  }

  /**
   * Indique si la balle est en dehors de l'écran
   * 
   * @return boolean, true si une part de la balle est en dehors de la bordure du jeu
   */
  private boolean isOutOfScreen() {
    return isOutLeft()
        || isOutRight()
        || isOutUp()
        || isOutDown();
  }

  private boolean isOutDown() {
    return y > 100 - radius;
  }

  private boolean isOutUp() {
    return y < 0 + radius;
  }

  private boolean isOutRight() {
    return x > 100 - radius;
  }

  private boolean isOutLeft() {
    return x < 0 + radius;
  }

  @Override
  public double getWidth() {
    return getDiameter();
  }

  @Override
  public double getHeight() {
    return getDiameter();
  }

  /**
   * Calcule la position du bord gauche
   * 
   * @return position relative du bord gauche (0-100)
   */
  public double getLeft() {
    return x - radius;
  }

  /**
   * Calcule la position du bord haut
   * 
   * @return position relative du bord haut (0-100)
   */
  public double getTop() {
    return y - radius;
  }
}
