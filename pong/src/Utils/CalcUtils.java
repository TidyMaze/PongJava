package Utils;

import java.util.HashMap;

import model.Position;

public class CalcUtils {


  public static double moy(double a, double b) {
    return (a + b) / 2;
  }

  public static double alignX(Position position, int wallWidth) {
    HashMap<Position, Double> map = createAlignMapX(wallWidth);
    return returnAlignementOrException(position, map);
  }

  private static HashMap<Position, Double> createAlignMapX(int wallWidth) {
    HashMap<Position, Double> map = new HashMap<>();
    map.put(Position.LEFT, 0.0);
    map.put(Position.TOP, 0.0);
    map.put(Position.RIGHT, 100.0 - wallWidth);
    map.put(Position.BOTTOM, 0.0);
    return map;
  }

  private static double returnAlignementOrException(Position position, HashMap<Position, Double> map)
      throws RuntimeException {
    testPositionOrException(position, map);
    return map.get(position);
  }

  private static void testPositionOrException(Position position, HashMap<Position, Double> map)
      throws RuntimeException {
    if (!map.containsKey(position))
      throw new RuntimeException("aucune position " + position);
  }

  public static double alignY(Position position, int wallWidth) {
    HashMap<Position, Double> map = createMapAlignY(wallWidth);
    return returnAlignementOrException(position, map);
  }

  private static HashMap<Position, Double> createMapAlignY(int wallWidth) {
    HashMap<Position, Double> map = new HashMap<>();
    map.put(Position.LEFT, 0.0);
    map.put(Position.TOP, 0.0);
    map.put(Position.RIGHT, 0.0);
    map.put(Position.BOTTOM, 100.0 - wallWidth);
    return map;
  }
}
