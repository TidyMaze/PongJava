package pong;

public class Paddle {

  private static final int DEFAULT_LENGTH = 30;
  private static final int DEFAULT_POSITION = 50;
  private PlayerType type;
  private int length;
  private int position;

  public Paddle(PlayerType type) {
    this.type = type;
    this.length = Paddle.DEFAULT_LENGTH;
    this.position = Paddle.DEFAULT_POSITION;
  }

  public int getVerticalRelativePosition() {
    return this.position;
  }

  public int getLength() {
    return length;
  }

  public PlayerType getPlayerType() {
    return type;
  }
}
