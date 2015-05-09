package Utils;

import java.util.HashMap;

import model.Position;

public class CalcUtils {


  public static double moy(double a, double b) {
    return (a + b) / 2;
  }

  public static double alignX(Position position, int wallWidth) {
    HashMap<Position, Double> map = new HashMap<>();
    map.put(Position.LEFT, 0.0);
    map.put(Position.TOP, 0.0);
    map.put(Position.RIGHT, 100.0 - wallWidth);
    map.put(Position.BOTTOM, 0.0);
    return map.get(position);
  }

  public static double alignY(Position position, int wallWidth) {
    HashMap<Position, Double> map = new HashMap<>();
    map.put(Position.LEFT, 0.0);
    map.put(Position.TOP, 0.0);
    map.put(Position.RIGHT, 0.0);
    map.put(Position.BOTTOM, 100.0 - wallWidth);
    return map.get(position);
  }
}
