package pong;

import java.util.Observable;

public class Paddle extends Observable {

  private static final double DEFAULT_LENGTH = 30;
  private static final double DEFAULT_POSITION = 50;
  private PlayerType type;
  private double length;
  private double position;

  public Paddle(PlayerType type) {
    this.type = type;
    this.length = Paddle.DEFAULT_LENGTH;
    this.position = Paddle.DEFAULT_POSITION;
  }

  public double getVerticalRelativePosition() {
    return position;
  }

  public double getLength() {
    return length;
  }

  public PlayerType getPlayerType() {
    return type;
  }

  public void addVerticalPosition(double offset) {
    this.position += offset;
    this.setChanged();
    this.notifyObservers();
  }
}
