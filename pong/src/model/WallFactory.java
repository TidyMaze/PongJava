package model;

public class WallFactory {



  private static final int WALL_WIDTH = 5;

  public Wall createWall(Position position) {
    switch (position) {
      case LEFT:
        return new Wall(0, 0, 100, WallFactory.WALL_WIDTH);
      default:
        break;
    }
    return null;
  }
}
