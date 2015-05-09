package model;



public class Paddle implements RectangularShaped {

  private static final double DEFAULT_LENGTH = 30;
  private static final double DEFAULT_POSITION = 50;
  private static final double DEFAULT_WIDTH = 2;
  private PlayerType type;
  private double height;
  private double position;
  private double width;

  public Paddle(PlayerType type) {
    this.type = type;
    this.height = Paddle.DEFAULT_LENGTH;
    this.width = Paddle.DEFAULT_WIDTH;
    this.position = Paddle.DEFAULT_POSITION;
  }

  public double getVerticalRelativePosition() {
    return position;
  }

  public PlayerType getPlayerType() {
    return type;
  }

  public void addVerticalPosition(double offset) {
    this.position += offset;
  }

  @Override
  public double getWidth() {
    return width;
  }

  @Override
  public double getHeight() {
    return height;
  }
}
