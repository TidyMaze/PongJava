package model;

import Utils.CalcUtils;

public class WallFactory {

  private static final int WALL_WIDTH = 5;

  public Wall createWall(Position position) {
    double x = CalcUtils.alignX(position, WALL_WIDTH);
    double y = CalcUtils.alignY(position, WALL_WIDTH);
    return createWallAligned(position, x, y);
  }

  private Wall createWallAligned(Position position, double x, double y) throws RuntimeException {
    if (isVertical(position))
      return new Wall(x, y, WALL_WIDTH, 100);
    if (isHorizontal(position))
      return new Wall(x, y, 100, WALL_WIDTH);
    throw new RuntimeException("Position invalide : " + position);
  }

  private boolean isHorizontal(Position position) {
    return position == Position.TOP || position == Position.BOTTOM;
  }

  private boolean isVertical(Position position) {
    return position == Position.LEFT || position == Position.RIGHT;
  }
}
