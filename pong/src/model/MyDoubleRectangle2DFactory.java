package model;

public class MyDoubleRectangle2DFactory {

  public static MyDoubleRectangle2D createRectangleFrom(LocatedAndRectangularShaped source) {
    return new MyDoubleRectangle2D(source.getX(), source.getY(), source.getWidth(),
        source.getHeight());
  }

}
