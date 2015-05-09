package model;

import java.awt.geom.Rectangle2D.Double;

public class MyDoubleRectangle2D extends Double {
  @Override
  public String toString() {
    return "Rectangle : x=" + getX() + ", y=" + getY() + ", width =" + getWidth() + ", height="
        + getHeight();
  }
}
